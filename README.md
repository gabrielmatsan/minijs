# MiniJS Compiler

Compilador para a linguagem MiniJS, uma linguagem baseada em JavaScript desenvolvida como projeto acadêmico.

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6 ou superior
- ANTLR 4.13.1 (instalado automaticamente pelo Maven)

## Instalação do Maven (se necessário)

### macOS:
```bash
brew install maven
```

### Linux (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install maven
```

### Windows:
Baixe de: https://maven.apache.org/download.cgi

## Estrutura do Projeto

```
compilador/
├── MiniJS.g4              # Gramática ANTLR (léxico e sintático)
├── pom.xml                # Configuração Maven
├── exemplo.minijs         # Código de exemplo em MiniJS
├── compile.sh             # Script de compilação
├── run.sh                 # Script de execução
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── minijs/
│                   ├── MiniJSCompiler.java         # Programa principal
│                   └── MiniJSSemanticAnalyzer.java # Analisador semântico
└── target/                # Arquivos compilados (gerado após compilação)
```

## Como Compilar

### Método 1: Usando o script
```bash
chmod +x compile.sh
./compile.sh
```

### Método 2: Usando Maven diretamente
```bash
mvn clean compile
```

## Como Executar

### Método 1: Usando o script
```bash
chmod +x run.sh
./run.sh exemplo.minijs
```

### Método 2: Usando Maven diretamente
```bash
mvn exec:java -Dexec.mainClass="com.minijs.MiniJSCompiler" -Dexec.args="exemplo.minijs"
```

## Funcionalidades Implementadas

### Análise Léxica
- Identificação de tokens (palavras-chave, identificadores, números, strings)
- Tabela de tokens com linha, tipo e lexema
- Estatísticas de tokens
- Suporte a comentários (linha e bloco)

### Análise Sintática
- Declaração de variáveis (let, const, var)
- Declaração de funções
- Estruturas condicionais (if/else)
- Loops (while, for, do-while)
- Expressões matemáticas e lógicas
- Arrays e objetos
- Chamadas de função

### Análise Semântica Básica
- Registro de variáveis declaradas
- Registro de funções declaradas
- Controle de escopo

## Exemplo de Saída

O compilador produz:
1. Tabela de tokens identificados
2. Estatísticas dos tokens
3. Árvore sintática abstrata
4. Lista de variáveis e funções declaradas

## Recursos da Linguagem MiniJS

- **Variáveis**: `let`, `const`, `var`
- **Tipos**: números, strings, booleanos, arrays, objetos
- **Operadores**: aritméticos, lógicos, comparação
- **Controle de fluxo**: if/else, while, for, do-while
- **Funções**: declaração e chamada com parâmetros
- **Comentários**: linha (`//`) e bloco (`/* */`)

## Autores

Projeto desenvolvido para a disciplina de Compiladores - CESUPA 2025