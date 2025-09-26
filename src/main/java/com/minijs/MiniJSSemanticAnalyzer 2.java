package com.minijs;

import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MiniJSSemanticAnalyzer extends MiniJSBaseListener {
    private Set<String> declaredVariables = new HashSet<>();
    private Set<String> declaredFunctions = new HashSet<>();
    private Stack<Set<String>> scopes = new Stack<>();

    public MiniJSSemanticAnalyzer() {
        scopes.push(new HashSet<>()); // Global scope
    }

    @Override
    public void enterBlock(MiniJSParser.BlockContext ctx) {
        scopes.push(new HashSet<>()); // New scope
    }

    @Override
    public void exitBlock(MiniJSParser.BlockContext ctx) {
        scopes.pop(); // Exit scope
    }

    @Override
    public void enterVariableDeclaration(MiniJSParser.VariableDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        declaredVariables.add(varName);
        scopes.peek().add(varName);
        System.out.println("  Variável declarada: " + varName +
                         " (tipo: " + ctx.getChild(0).getText() + ")");
    }

    @Override
    public void enterFunctionDeclaration(MiniJSParser.FunctionDeclarationContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        declaredFunctions.add(funcName);
        System.out.println("  Função declarada: " + funcName + "()");

        // Parâmetros da função
        if (ctx.parameterList() != null) {
            List<TerminalNode> params = ctx.parameterList().IDENTIFIER();
            System.out.println("    Parâmetros: " + params.size());
            for (TerminalNode param : params) {
                System.out.println("      - " + param.getText());
            }
        }
    }

    public Set<String> getDeclaredVariables() {
        return declaredVariables;
    }

    public Set<String> getDeclaredFunctions() {
        return declaredFunctions;
    }
}