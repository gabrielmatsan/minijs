# Documentação Técnica - MiniJS Compiler

## 1. Visão Geral do Projeto

O **MiniJS Compiler** é um compilador educacional desenvolvido para a disciplina de Compiladores, implementando um analisador léxico e sintático para uma linguagem de programação inspirada em JavaScript. O projeto demonstra os conceitos fundamentais de análise de linguagens formais e construção de compiladores.

## 2. Arquitetura do Sistema

### 2.1 Arquitetura em Camadas

```
┌─────────────────────────────────────┐
│         Código Fonte (.minijs)      │
└─────────────────┬───────────────────┘
                  ▼
┌─────────────────────────────────────┐
│      ANÁLISE LÉXICA (Scanner)       │
│         MiniJSLexer (ANTLR)         │
└─────────────────┬───────────────────┘
                  ▼
┌─────────────────────────────────────┐
│     ANÁLISE SINTÁTICA (Parser)      │
│        MiniJSParser (ANTLR)         │
└─────────────────┬───────────────────┘
                  ▼
┌─────────────────────────────────────┐
│    ANÁLISE SEMÂNTICA (Básica)       │
│     MiniJSSemanticAnalyzer          │
└─────────────────┬───────────────────┘
                  ▼
┌─────────────────────────────────────┐
│      Árvore Sintática (AST)         │
│    + Relatório de Compilação        │
└─────────────────────────────────────┘
```

### 2.2 Componentes Principais

#### **MiniJS.g4** - Gramática ANTLR
- Define as regras léxicas (tokens)
- Define as regras sintáticas (parser)
- Especifica a estrutura da linguagem

#### **MiniJSCompiler.java** - Orquestrador
- Coordena todo o processo de compilação
- Gerencia as fases de análise
- Produz relatórios detalhados

#### **MiniJSSemanticAnalyzer.java** - Analisador Semântico
- Valida declarações de variáveis
- Registra funções e seus parâmetros
- Controla escopos

## 3. Tecnologias Utilizadas

### 3.1 ANTLR 4.13.1
**Motivo da escolha:**
- **Geração automática de analisadores**: ANTLR gera automaticamente o código Java para lexer e parser
- **Gramáticas unificadas**: Permite definir regras léxicas e sintáticas no mesmo arquivo
- **Árvore sintática automática**: Constrói automaticamente a AST
- **Suporte a listeners e visitors**: Facilita a travessia da árvore
- **Amplamente usado na indústria**: Utilizado em projetos como Hibernate, Groovy, e Twitter

### 3.2 Java 11
**Motivo da escolha:**
- **Estabilidade e maturidade**: Versão LTS com suporte de longo prazo
- **Integração perfeita com ANTLR**: ANTLR gera código Java nativo
- **Orientação a objetos**: Facilita a organização do código em classes
- **Portabilidade**: Funciona em qualquer sistema com JVM
- **Ferramentas de desenvolvimento**: Rico ecossistema de IDEs e ferramentas

### 3.3 Maven 3.6+
**Motivo da escolha:**
- **Gestão de dependências**: Automatiza download do ANTLR
- **Build automatizado**: Compila gramática e código Java
- **Plugin ANTLR integrado**: Suporte nativo para compilação de gramáticas
- **Padrão da indústria**: Amplamente adotado em projetos Java

## 4. Funcionamento Detalhado

### 4.1 Fase 1: Análise Léxica (Scanner)

O analisador léxico transforma o código fonte em uma sequência de tokens.

**Processo:**
1. Lê o arquivo caractere por caractere
2. Agrupa caracteres em lexemas
3. Classifica lexemas em tokens
4. Ignora espaços em branco e comentários

**Tokens Reconhecidos:**

| Categoria | Tokens | Expressão Regular |
|-----------|--------|-------------------|
| Palavras-chave | let, const, var, function, if, else, while, for, do, return | Correspondência exata |
| Identificadores | Nomes de variáveis e funções | `[a-zA-Z_$][a-zA-Z0-9_$]*` |
| Números | Inteiros e decimais | `[0-9]+(\.[0-9]+)?([eE][+-]?[0-9]+)?` |
| Strings | Texto entre aspas | `"([^"\\]|\\.)*"` ou `'([^'\\]|\\.)*'` |
| Operadores | +, -, *, /, %, ==, !=, <, >, &&, \|\|, ! | Símbolos específicos |
| Delimitadores | (, ), {, }, [, ], ;, , | Caracteres únicos |

**Exemplo de tokenização:**
```javascript
let x = 10;
```
Produz:
```
[LET] [IDENTIFIER:x] [ASSIGN] [NUMBER:10] [SEMICOLON]
```

### 4.2 Fase 2: Análise Sintática (Parser)

O parser verifica se a sequência de tokens obedece à gramática da linguagem.

**Gramática Livre de Contexto (BNF simplificado):**

```bnf
program ::= statement* EOF

statement ::= variableDeclaration
           | functionDeclaration
           | ifStatement
           | whileStatement
           | forStatement
           | doWhileStatement
           | returnStatement
           | expressionStatement
           | block

variableDeclaration ::= ('let' | 'const' | 'var') IDENTIFIER ('=' expression)? ';'

functionDeclaration ::= 'function' IDENTIFIER '(' parameterList? ')' block

ifStatement ::= 'if' '(' expression ')' statement ('else' statement)?

expression ::= assignmentExpression

assignmentExpression ::= logicalOrExpression ('=' assignmentExpression)?

// ... demais regras de precedência de operadores
```

**Árvore Sintática Abstrata (AST):**
Para o código `let x = 10;`, a AST seria:
```
program
└── variableDeclaration
    ├── 'let'
    ├── IDENTIFIER:x
    ├── '='
    └── expression
        └── NUMBER:10
```

### 4.3 Fase 3: Análise Semântica

Valida aspectos contextuais do código.

**Verificações implementadas:**
- Registro de variáveis declaradas
- Registro de funções e seus parâmetros
- Controle básico de escopo (blocos aninhados)

**Processo:**
1. Percorre a AST usando o padrão Visitor
2. Mantém tabelas de símbolos por escopo
3. Registra declarações encontradas
4. Produz relatório de elementos declarados

## 5. Características da Linguagem MiniJS

### 5.1 Declaração de Variáveis
```javascript
let x = 10;        // Variável mutável
const PI = 3.14;   // Constante
var name = "João"; // Variável (escopo de função)
```

### 5.2 Tipos de Dados
- **Números**: Inteiros e decimais
- **Strings**: Texto entre aspas simples ou duplas
- **Booleanos**: true, false
- **Null/Undefined**: null, undefined
- **Arrays**: `[1, 2, 3]`
- **Objetos**: `{nome: "João", idade: 25}`

### 5.3 Estruturas de Controle
```javascript
// Condicional
if (x > 5) {
    // código
} else {
    // código alternativo
}

// Loops
while (condition) { }
for (let i = 0; i < 10; i++) { }
do { } while (condition);
```

### 5.4 Funções
```javascript
function calcular(a, b) {
    return a + b;
}
```

### 5.5 Operadores

| Tipo | Operadores |
|------|------------|
| Aritméticos | +, -, *, /, % |
| Comparação | ==, !=, ===, !==, <, >, <=, >= |
| Lógicos | &&, \|\|, ! |
| Incremento | ++, -- |
| Atribuição | = |

## 6. Estrutura de Arquivos

```
compilador/
├── MiniJS.g4                  # Gramática ANTLR
├── pom.xml                    # Configuração Maven
├── compile.sh                 # Script de compilação
├── run.sh                     # Script de execução
├── exemplo.minijs            # Código de exemplo
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── minijs/
│                   ├── MiniJSCompiler.java
│                   └── MiniJSSemanticAnalyzer.java
└── target/                   # Arquivos gerados
    ├── classes/              # Classes compiladas
    └── generated-sources/    # Código ANTLR gerado
        └── antlr4/
            ├── MiniJSLexer.java
            ├── MiniJSParser.java
            ├── MiniJSListener.java
            ├── MiniJSBaseListener.java
            ├── MiniJSVisitor.java
            └── MiniJSBaseVisitor.java
```

## 7. Como Compilar e Executar

### 7.1 Pré-requisitos
- Java 11 ou superior
- Maven 3.6 ou superior

### 7.2 Compilação
```bash
# Método 1: Script
chmod +x compile.sh
./compile.sh

# Método 2: Maven direto
mvn clean compile
```

### 7.3 Execução
```bash
# Método 1: Script
chmod +x run.sh
./run.sh exemplo.minijs

# Método 2: Maven direto
mvn exec:java -Dexec.mainClass="com.minijs.MiniJSCompiler" -Dexec.args="exemplo.minijs"
```

## 8. Saída do Compilador

O compilador produz:

### 8.1 Tabela de Tokens
Lista todos os tokens identificados com:
- Número da linha
- Tipo do token
- Lexema
- Código numérico do tipo

### 8.2 Estatísticas de Tokens
Contagem de cada tipo de token encontrado

### 8.3 Resultado da Análise Sintática
- Confirmação de sucesso ou lista de erros
- Árvore sintática em formato texto

### 8.4 Análise Semântica
- Lista de variáveis declaradas
- Lista de funções com parâmetros
- Informações de escopo

## 9. Decisões de Design

### 9.1 Por que ANTLR ao invés de implementação manual?

**Vantagens do ANTLR:**
- **Produtividade**: Reduz drasticamente o tempo de desenvolvimento
- **Manutenibilidade**: Gramática declarativa é mais fácil de manter
- **Menos erros**: Geração automática elimina bugs manuais
- **Recursos avançados**: Recuperação de erros, predicados semânticos
- **Documentação**: A gramática serve como documentação formal

**Quando usar implementação manual:**
- Requisitos de performance extremos
- Controle total sobre o processo
- Fins puramente educacionais sobre algoritmos

### 9.2 Por que Java?

**Alternativas consideradas:**
- **Python**: Mais simples, mas menos performático
- **C/C++**: Mais rápido, mas desenvolvimento mais complexo
- **JavaScript**: Interessante por ser a linguagem alvo, mas menos estruturado

**Java foi escolhido por:**
- Equilíbrio entre performance e produtividade
- Forte tipagem ajuda na manutenção
- Excelente suporte do ANTLR
- Familiaridade acadêmica

### 9.3 Limitações Atuais e Melhorias Futuras

**Limitações:**
- Não gera código executável
- Análise semântica básica (sem verificação de tipos completa)
- Sem otimizações
- Sem verificação de variáveis não declaradas

**Melhorias possíveis:**
1. **Geração de código**: Transpilação para JavaScript real
2. **Sistema de tipos**: Inferência e verificação de tipos
3. **Otimizações**: Eliminação de código morto, constant folding
4. **Análise de fluxo**: Detecção de variáveis não utilizadas
5. **Melhor recuperação de erros**: Continuar análise após erros

## 10. Exemplos de Uso

### 10.1 Código Válido
```javascript
function fibonacci(n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

let resultado = fibonacci(10);
```

### 10.2 Detecção de Erros Sintáticos
```javascript
// Erro: falta fechar parêntese
if (x > 5 {  // ❌ Erro sintático detectado
    console.log("maior");
}
```

## 11. Conclusão

O MiniJS Compiler demonstra com sucesso os conceitos fundamentais de compilação:
- **Análise léxica** eficiente com expressões regulares
- **Análise sintática** robusta com gramática livre de contexto
- **Análise semântica** básica com tabela de símbolos
- **Geração de AST** para processamento posterior

O uso do ANTLR permitiu focar nos conceitos de compilação ao invés dos detalhes de implementação, resultando em um projeto educacional completo e funcional que pode servir como base para extensões futuras.

## 12. Referências

- Aho, A. V., Lam, M. S., Sethi, R., & Ullman, J. D. (2006). *Compilers: Principles, Techniques, and Tools* (2nd ed.)
- Parr, T. (2013). *The Definitive ANTLR 4 Reference*
- ANTLR Documentation: https://www.antlr.org/
- ECMAScript Specification: https://tc39.es/ecma262/