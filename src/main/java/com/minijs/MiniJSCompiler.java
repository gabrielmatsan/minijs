package com.minijs;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class MiniJSCompiler {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Uso: java MiniJSCompiler <arquivo.minijs>");
            System.out.println("\nExemplo: java MiniJSCompiler exemplo.minijs");
            return;
        }

        String inputFile = args[0];
        System.out.println("====================================");
        System.out.println("    MiniJS Compiler v1.0");
        System.out.println("====================================\n");
        System.out.println("Arquivo de entrada: " + inputFile);
        System.out.println("\n--- ANÁLISE LÉXICA ---");

        // Análise Léxica
        CharStream input = CharStreams.fromFileName(inputFile);
        MiniJSLexer lexer = new MiniJSLexer(input);

        // Coletar todos os tokens para análise
        List<Token> tokens = new ArrayList<>();
        Token token;
        while ((token = lexer.nextToken()).getType() != Token.EOF) {
            tokens.add(token);
        }

        // Exibir tabela de tokens
        System.out.println("\nTabela de Tokens:");
        System.out.println(String.format("%-5s %-20s %-30s %-10s", "Linha", "Token", "Lexema", "Tipo"));
        System.out.println("---------------------------------------------------------------");

        for (Token t : tokens) {
            String tokenName = lexer.getVocabulary().getSymbolicName(t.getType());
            if (tokenName != null) {
                System.out.println(String.format("%-5d %-20s %-30s %-10d",
                    t.getLine(),
                    tokenName,
                    t.getText().replace("\n", "\\n").replace("\t", "\\t"),
                    t.getType()));
            }
        }

        // Estatísticas léxicas
        Map<String, Integer> tokenStats = new HashMap<>();
        for (Token t : tokens) {
            String tokenName = lexer.getVocabulary().getSymbolicName(t.getType());
            if (tokenName != null) {
                tokenStats.put(tokenName, tokenStats.getOrDefault(tokenName, 0) + 1);
            }
        }

        System.out.println("\nEstatísticas de Tokens:");
        tokenStats.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println("  " + entry.getKey() + ": " + entry.getValue()));

        System.out.println("\nTotal de tokens: " + tokens.size());

        // Resetar lexer para análise sintática
        lexer.reset();
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        System.out.println("\n--- ANÁLISE SINTÁTICA ---");

        // Análise Sintática
        MiniJSParser parser = new MiniJSParser(tokenStream);

        // Adicionar listener de erros customizado
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                   Object offendingSymbol,
                                   int line, int charPositionInLine,
                                   String msg,
                                   RecognitionException e) {
                System.err.println("Erro sintático na linha " + line +
                                 ", posição " + charPositionInLine + ": " + msg);
            }
        });

        // Parse do programa
        ParseTree tree = parser.program();

        // Verificar se houve erros sintáticos
        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("\n✓ Análise sintática concluída com sucesso!");
            System.out.println("  Nenhum erro sintático encontrado.\n");

            // Exibir a árvore sintática
            System.out.println("Árvore Sintática Abstrata:");
            printTree(tree, parser, "", true);

            // Análise semântica básica
            System.out.println("\n--- ANÁLISE SEMÂNTICA BÁSICA ---");
            MiniJSSemanticAnalyzer analyzer = new MiniJSSemanticAnalyzer();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(analyzer, tree);

            System.out.println("\nVariáveis declaradas:");
            for (String var : analyzer.getDeclaredVariables()) {
                System.out.println("  - " + var);
            }

            System.out.println("\nFunções declaradas:");
            for (String func : analyzer.getDeclaredFunctions()) {
                System.out.println("  - " + func);
            }

            System.out.println("\nChamadas console.log:");
            System.out.println("  Total: " + analyzer.getConsoleLogs().size() + " chamada(s)");

        } else {
            System.out.println("\n✗ Análise sintática falhou!");
            System.out.println("  " + parser.getNumberOfSyntaxErrors() + " erro(s) encontrado(s).\n");
        }

        System.out.println("\n====================================");
        System.out.println("    Compilação Finalizada");
        System.out.println("====================================");
    }

    private static void printTree(ParseTree tree, Parser parser, String prefix, boolean isLast) {
        String nodeName = tree.getClass().getSimpleName();

        if (tree instanceof RuleContext) {
            int ruleIndex = ((RuleContext) tree).getRuleIndex();
            nodeName = parser.getRuleNames()[ruleIndex];
        } else if (tree instanceof TerminalNode) {
            Token token = ((TerminalNode) tree).getSymbol();
            nodeName = "'" + token.getText() + "'";
        }

        System.out.println(prefix + (isLast ? "└── " : "├── ") + nodeName);

        List<ParseTree> children = new ArrayList<>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            children.add(tree.getChild(i));
        }

        for (int i = 0; i < children.size(); i++) {
            printTree(children.get(i), parser,
                     prefix + (isLast ? "    " : "│   "),
                     i == children.size() - 1);
        }
    }
}