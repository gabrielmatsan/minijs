# Processo de Criação da Linguagem MiniJS - Documentação Completa

## Índice

1. [Visão Geral](#visão-geral)
2. [Arquitetura do Compilador](#arquitetura-do-compilador)
3. [Fase 1: Especificação da Linguagem](#fase-1-especificação-da-linguagem)
4. [Fase 2: Definição da Gramática ANTLR](#fase-2-definição-da-gramática-antlr)
5. [Fase 3: Configuração do Projeto Maven](#fase-3-configuração-do-projeto-maven)
6. [Fase 4: Implementação do Compilador Principal](#fase-4-implementação-do-compilador-principal)
7. [Fase 5: Análise Semântica](#fase-5-análise-semântica)
8. [Fase 6: Geração Automática de Código](#fase-6-geração-automática-de-código)
9. [Fase 7: Integração e Testes](#fase-7-integração-e-testes)
10. [Decisões de Design](#decisões-de-design)
11. [Desafios Encontrados](#desafios-encontrados)
12. [Tecnologias Utilizadas](#tecnologias-utilizadas)
13. [Estrutura Final do Projeto](#estrutura-final-do-projeto)

---

## Visão Geral

O **MiniJS** é uma linguagem de programação educacional inspirada no JavaScript, desenvolvida como projeto acadêmico para demonstrar os princípios fundamentais de construção de compiladores. O projeto implementa um compilador completo que realiza análise léxica, sintática e semântica básica.

### Objetivos do Projeto

- Demonstrar o processo completo de criação de uma linguagem de programação
- Implementar as três fases principais de um compilador
- Utilizar ferramentas modernas de geração de parsers (ANTLR)
- Criar uma linguagem funcional e didática

---

## Arquitetura do Compilador

O compilador MiniJS segue a arquitetura clássica de compiladores, dividida em três fases principais:

```
Código Fonte MiniJS → [Análise Léxica] → [Análise Sintática] → [Análise Semântica] → Saída
                           ↓                    ↓                     ↓
                      Tokens gerados    Árvore Sintática    Verificações semânticas
```

### Componentes Principais

1. **MiniJSLexer**: Analisador léxico gerado pelo ANTLR
2. **MiniJSParser**: Analisador sintático gerado pelo ANTLR
3. **MiniJSCompiler**: Classe principal que coordena todo o processo
4. **MiniJSSemanticAnalyzer**: Implementa análises semânticas básicas

---

## Fase 1: Especificação da Linguagem

### Características Definidas para o MiniJS

#### Tipos de Dados Suportados

- **Números**: Inteiros e decimais (ex: `42`, `3.14`)
- **Strings**: Delimitadas por aspas simples ou duplas (ex: `"hello"`, `'world'`)
- **Booleanos**: `true` e `false`
- **Arrays**: Listas de elementos (ex: `[1, 2, 3]`)
- **Objetos**: Estruturas chave-valor (ex: `{name: "João", age: 25}`)
- **Valores especiais**: `null` e `undefined`

#### Declaração de Variáveis

```javascript
let nome = "João";
const PI = 3.14;
var contador = 0;
```

#### Estruturas de Controle

```javascript
// Condicional
if (idade >= 18) {
  console.log("Maior de idade");
} else {
  console.log("Menor de idade");
}

// Loops
while (i < 10) {
  i++;
}
for (let i = 0; i < 5; i++) {}
do {
  x--;
} while (x > 0);
```

#### Funções

```javascript
function saudacao(nome) {
  console.log("Olá, " + nome);
  return nome;
}
```

#### Operadores Suportados

- **Aritméticos**: `+`, `-`, `*`, `/`, `%`
- **Comparação**: `==`, `!=`, `===`, `!==`, `<`, `>`, `<=`, `>=`
- **Lógicos**: `&&`, `||`, `!`
- **Incremento/Decremento**: `++`, `--`
- **Atribuição**: `=`

---

## Fase 2: Definição da Gramática ANTLR

### Arquivo MiniJS.g4

A gramática foi estruturada em duas partes principais:

#### 2.1 Regras do Parser (Análise Sintática)

```antlr
grammar MiniJS;

program
    : statement* EOF
    ;

statement
    : variableDeclaration
    | functionDeclaration
    | ifStatement
    | whileStatement
    | forStatement
    | doWhileStatement
    | returnStatement
    | consoleLogStatement
    | expressionStatement
    | block
    ;
```

**Decisões de Design na Gramática:**

- **Hierarquia de precedência de operadores**: Implementada através de regras recursivas ordenadas
- **Associatividade**: Operadores aritméticos são associativos à esquerda
- **Estruturas aninhadas**: Suporte completo a blocos e escopos aninhados

#### 2.2 Regras do Lexer (Análise Léxica)

```antlr
// Palavras-chave
LET         : 'let';
CONST       : 'const';
VAR         : 'var';
FUNCTION    : 'function';
IF          : 'if';
ELSE        : 'else';

// Identificadores
IDENTIFIER  : [a-zA-Z_$][a-zA-Z0-9_$]*;

// Números
NUMBER      : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
```

**Características do Lexer:**

- **Suporte a notação científica**: Para números (ex: `1.5e-10`)
- **Identificadores JavaScript-style**: Permite `_`, `$` e caracteres alfanuméricos
- **Comentários**: Suporte a comentários de linha (`//`) e bloco (`/* */`)

---

## Fase 3: Configuração do Projeto Maven

### Arquivo pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.minijs</groupId>
    <artifactId>minijs-compiler</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <antlr.version>4.13.1</antlr.version>
    </properties>
</project>
```

### Plugins Essenciais Configurados

#### 3.1 Plugin ANTLR Maven

```xml
<plugin>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-maven-plugin</artifactId>
    <version>${antlr.version}</version>
    <configuration>
        <visitor>true</visitor>
        <listener>true</listener>
    </configuration>
</plugin>
```

**Funcionalidades habilitadas:**

- **Visitor Pattern**: Para travessia da árvore sintática
- **Listener Pattern**: Para análise semântica baseada em eventos
- **Geração automática**: Classes Java geradas a partir da gramática

#### 3.2 Plugin Shade (Empacotamento)

- Cria JAR executável independente
- Inclui todas as dependências necessárias
- Define classe principal (`MiniJSCompiler`)

---

## Fase 4: Implementação do Compilador Principal

### Classe MiniJSCompiler.java

#### 4.1 Estrutura do Programa Principal

```java
public class MiniJSCompiler {
    public static void main(String[] args) throws Exception {
        // 1. Validação de argumentos
        // 2. Análise Léxica
        // 3. Análise Sintática
        // 4. Análise Semântica
        // 5. Relatórios de saída
    }
}
```

#### 4.2 Implementação da Análise Léxica

```java
// Criação do lexer
CharStream input = CharStreams.fromFileName(inputFile);
MiniJSLexer lexer = new MiniJSLexer(input);

// Coleta de tokens
List<Token> tokens = new ArrayList<>();
Token token;
while ((token = lexer.nextToken()).getType() != Token.EOF) {
    tokens.add(token);
}
```

**Funcionalidades implementadas:**

- **Tabela de tokens**: Exibe linha, tipo, lexema e código do token
- **Estatísticas**: Contagem de cada tipo de token encontrado
- **Tratamento de erros**: Identificação de tokens inválidos

#### 4.3 Implementação da Análise Sintática

```java
// Criação do parser
MiniJSParser parser = new MiniJSParser(tokenStream);

// Tratamento de erros customizado
parser.addErrorListener(new BaseErrorListener() {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                           Object offendingSymbol,
                           int line, int charPositionInLine,
                           String msg, RecognitionException e) {
        System.err.println("Erro sintático na linha " + line + ": " + msg);
    }
});

// Geração da árvore sintática
ParseTree tree = parser.program();
```

#### 4.4 Visualização da Árvore Sintática

```java
private static void printTree(ParseTree tree, Parser parser, String prefix, boolean isLast) {
    String nodeName = tree.getClass().getSimpleName();

    if (tree instanceof RuleContext) {
        int ruleIndex = ((RuleContext) tree).getRuleIndex();
        nodeName = parser.getRuleNames()[ruleIndex];
    }

    System.out.println(prefix + (isLast ? "└── " : "├── ") + nodeName);
    // ... recursão para filhos
}
```

---

## Fase 5: Análise Semântica

### Classe MiniJSSemanticAnalyzer.java

#### 5.1 Estrutura do Analisador

```java
public class MiniJSSemanticAnalyzer extends MiniJSBaseListener {
    private Set<String> declaredVariables = new HashSet<>();
    private Set<String> declaredFunctions = new HashSet<>();
    private Stack<Set<String>> scopes = new Stack<>();
    private List<String> consoleLogs = new ArrayList<>();
}
```

#### 5.2 Gerenciamento de Escopo

```java
@Override
public void enterBlock(MiniJSParser.BlockContext ctx) {
    scopes.push(new HashSet<>()); // Novo escopo
}

@Override
public void exitBlock(MiniJSParser.BlockContext ctx) {
    scopes.pop(); // Sair do escopo
}
```

#### 5.3 Rastreamento de Declarações

```java
@Override
public void enterVariableDeclaration(MiniJSParser.VariableDeclarationContext ctx) {
    String varName = ctx.IDENTIFIER().getText();
    declaredVariables.add(varName);
    scopes.peek().add(varName);

    System.out.println("Variável declarada: " + varName +
                      " (tipo: " + ctx.getChild(0).getText() + ")");
}
```

**Análises Implementadas:**

- **Controle de escopo**: Stack de escopos para variáveis locais/globais
- **Registro de declarações**: Variáveis e funções declaradas
- **Análise de chamadas**: Detecção de chamadas `console.log`
- **Contagem de parâmetros**: Análise de funções e seus parâmetros

---

## Fase 6: Geração Automática de Código

### Arquivos Gerados pelo ANTLR

O ANTLR gera automaticamente várias classes Java a partir da gramática:

#### 6.1 Classes do Lexer

- **MiniJSLexer.java**: Analisador léxico principal
- **MiniJSLexer.tokens**: Mapeamento de tokens
- **MiniJSLexer.interp**: Dados interpretativos do lexer

#### 6.2 Classes do Parser

- **MiniJSParser.java**: Analisador sintático principal
- **MiniJSBaseListener.java**: Listener base para análise semântica
- **MiniJSListener.java**: Interface do listener
- **MiniJSBaseVisitor.java**: Visitor base para travessia da árvore
- **MiniJSVisitor.java**: Interface do visitor

#### 6.3 Arquivos de Configuração

- **MiniJS.tokens**: Definições de tokens
- **MiniJS.interp**: Dados interpretativos do parser

### Processo de Geração

```bash
mvn clean compile
# ANTLR processa MiniJS.g4 → gera classes Java → compila projeto
```

#### 6.4 Descompilação com FernFlower

Durante o desenvolvimento e debugging, é comum usar ferramentas de descompilação para analisar o bytecode gerado. O **FernFlower** é uma ferramenta de descompilação Java que:

- **Converte bytecode (.class) de volta para código Java**
- **Mantém a funcionalidade original** do código compilado
- **Gera código legível** para análise e debugging
- **É integrada ao IntelliJ IDEA** como descompilador padrão

**Exemplo de uso:**

```bash
# O bytecode compilado em target/classes/com/minijs/MiniJSCompiler.class
# pode ser descompilado para análise usando FernFlower
```

**Características do código descompilado:**

- Variáveis locais renomeadas (`var1`, `var2`, etc.)
- Sintaxe otimizada pelo compilador Java
- Estrutura funcionalmente equivalente ao original
- Comentário identificador: `// Source code is decompiled from a .class file using FernFlower decompiler`

---

## Fase 7: Integração e Testes

### Scripts de Automatização

#### compile.sh

```bash
#!/bin/bash
echo "Compilando MiniJS Compiler..."
mvn clean compile
echo "Compilação concluída!"
```

#### run.sh

```bash
#!/bin/bash
if [ $# -eq 0 ]; then
    echo "Uso: ./run.sh <arquivo.minijs>"
    exit 1
fi

mvn exec:java -Dexec.mainClass="com.minijs.MiniJSCompiler" -Dexec.args="$1"
```

### Exemplo de Teste (exemplo.minijs)

```javascript
let nome = "João";
const idade = 25;

function saudacao(nome) {
  console.log("Olá, " + nome);
  return nome;
}

if (idade >= 18) {
  console.log("Maior de idade");
}

saudacao(nome);
```

### Saída do Compilador

```
====================================
    MiniJS Compiler v1.0
====================================

--- ANÁLISE LÉXICA ---
Tabela de Tokens:
Linha Token                Lexema                         Tipo
---------------------------------------------------------------
1     LET                  let                            1
1     IDENTIFIER           nome                           32
1     ASSIGN               =                              37
1     STRING               "João"                         34

--- ANÁLISE SINTÁTICA ---
✓ Análise sintática concluída com sucesso!

Árvore Sintática Abstrata:
└── program
    ├── statement
    │   └── variableDeclaration
    │       ├── 'let'
    │       ├── 'nome'
    │       └── ...

--- ANÁLISE SEMÂNTICA BÁSICA ---
Variáveis declaradas:
  - nome
  - idade

Funções declaradas:
  - saudacao

Chamadas console.log:
  Total: 2 chamada(s)
```

---

## Decisões de Design

### 1. Escolha do ANTLR

**Vantagens:**

- Geração automática de lexer/parser de alta qualidade
- Suporte a múltiplos patterns (Visitor/Listener)
- Documentação extensa e comunidade ativa
- Integração nativa com Maven

### 2. Padrão Listener para Análise Semântica

**Justificativa:**

- Separação clara entre sintaxe e semântica
- Facilita manutenção e extensão
- Permite múltiplas passadas sobre a árvore sintática

### 3. Estrutura de Escopo com Stack

**Implementação:**

- `Stack<Set<String>>` para controle de escopo
- Cada bloco cria um novo escopo
- Facilita verificações de variáveis locais/globais

### 4. Maven como Sistema de Build

**Benefícios:**

- Gerenciamento automático de dependências
- Integração com ANTLR plugin
- Geração de JAR executável
- Padronização da estrutura do projeto

---

## Desafios Encontrados

### 1. Precedência de Operadores

**Problema:** Garantir que `2 + 3 * 4` seja interpretado como `2 + (3 * 4)`
**Solução:** Estruturação hierárquica das regras na gramática

### 2. Gerenciamento de Escopo

**Problema:** Controlar visibilidade de variáveis em diferentes escopos
**Solução:** Stack de conjuntos para rastrear variáveis por escopo

### 3. Tratamento de Erros

**Problema:** Fornecer mensagens de erro úteis
**Solução:** ErrorListener customizado com localização precisa de erros

### 4. Visualização da Árvore Sintática

**Problema:** Apresentar estrutura da árvore de forma legível
**Solução:** Algoritmo recursivo com formatação ASCII

---

## Tecnologias Utilizadas

### Principais

- **Java 11**: Linguagem de implementação
- **ANTLR 4.13.1**: Gerador de parser
- **Maven 3.6+**: Sistema de build e gerenciamento de dependências
- **FernFlower**: Ferramenta de descompilação Java (integração IntelliJ IDEA)

### Dependências

```xml
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-runtime</artifactId>
    <version>4.13.1</version>
</dependency>
```

### Plugins Maven

- **antlr4-maven-plugin**: Geração automática de código
- **maven-compiler-plugin**: Compilação Java
- **maven-shade-plugin**: Empacotamento JAR

---

## Estrutura Final do Projeto

```
compilador/
├── MiniJS.g4                           # Gramática ANTLR
├── pom.xml                            # Configuração Maven
├── exemplo.minijs                     # Arquivo de teste
├── compile.sh                         # Script de compilação
├── run.sh                            # Script de execução
├── README.md                         # Documentação básica
├── PROCESSO_CRIACAO_LINGUAGEM_MINIJS.md # Este documento
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── minijs/
│                   ├── MiniJSCompiler.java         # [155 linhas]
│                   └── MiniJSSemanticAnalyzer.java # [77 linhas]
│
└── target/                            # Gerado pelo Maven
    ├── classes/                       # Classes compiladas
    ├── generated-sources/
    │   └── antlr4/                   # Código gerado pelo ANTLR
    │       ├── MiniJSLexer.java      # Analisador léxico
    │       ├── MiniJSParser.java     # Analisador sintático
    │       ├── MiniJSBaseListener.java
    │       ├── MiniJSListener.java
    │       ├── MiniJSBaseVisitor.java
    │       ├── MiniJSVisitor.java
    │       └── *.tokens              # Arquivos de tokens
    └── minijs-compiler-1.0.jar      # JAR executável final
```

### Métricas do Projeto

- **Linhas de código Java**: ~232 linhas (classes principais)
- **Linhas de gramática ANTLR**: 216 linhas
- **Arquivos gerados automaticamente**: 10+ classes Java
- **Dependências**: 1 principal (ANTLR Runtime)

---

## Conclusão

O projeto MiniJS demonstra com sucesso o processo completo de criação de uma linguagem de programação, desde a especificação inicial até um compilador funcional. A implementação abrange:

1. **Análise Léxica Completa**: Identificação e classificação de todos os tokens
2. **Análise Sintática Robusta**: Construção de árvore sintática abstrata
3. **Análise Semântica Básica**: Verificações de escopo e declarações
4. **Ferramentas Modernas**: Uso do ANTLR para geração automática de código
5. **Automação**: Scripts e configuração Maven para facilitar uso

O compilador MiniJS serve como uma excelente base educacional para entender os princípios fundamentais de linguagens de programação e construção de compiladores, proporcionando uma experiência prática completa com ferramentas da indústria.

---

**Desenvolvido para:** Disciplina de Compiladores - CESUPA 2025
**Tecnologia Principal:** ANTLR 4 + Java 11 + Maven + FernFlower
**Padrões Implementados:** Visitor, Listener, Error Handling
**Total de Funcionalidades:** 20+ características da linguagem JavaScript
