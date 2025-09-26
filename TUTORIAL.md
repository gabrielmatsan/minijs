# 🚀 Tutorial MiniJS Compiler

## Guia Passo-a-Passo para Executar o Compilador

---

## 📋 1. Pré-requisitos

Antes de começar, certifique-se de ter instalado:

### ☕ Java 11 ou superior
```bash
# Verificar versão do Java
java -version

# Deve mostrar algo como:
# java version "11.0.x" ou superior
```

### 📦 Maven 3.6 ou superior
```bash
# Verificar versão do Maven
mvn -version

# Deve mostrar algo como:
# Apache Maven 3.6.x ou superior
```

### 💻 Instalação (se necessário)

#### macOS:
```bash
# Instalar Java
brew install openjdk@11

# Instalar Maven
brew install maven
```

#### Linux (Ubuntu/Debian):
```bash
# Instalar Java
sudo apt update
sudo apt install openjdk-11-jdk

# Instalar Maven
sudo apt install maven
```

#### Windows:
- Java: Baixe de [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://adoptium.net/)
- Maven: Baixe de [Apache Maven](https://maven.apache.org/download.cgi)

---

## 🛠️ 2. Compilação do Projeto

### Método 1: Script Automático (Recomendado)
```bash
# Tornar script executável
chmod +x compile.sh

# Executar compilação
./compile.sh
```

### Método 2: Maven Direto
```bash
# Limpar e compilar
mvn clean compile

# Criar JAR executável
mvn package
```

### ✅ Verificação da Compilação
Se tudo deu certo, você verá:
```
✅ Compilação concluída com sucesso!

Para executar o analisador, use:
  ./run.sh exemplo.minijs
```

---

## 🎯 3. Executando o Compilador

### Método 1: Script de Execução (Mais Fácil)
```bash
# Tornar script executável
chmod +x run.sh

# Executar com arquivo de exemplo
./run.sh exemplo.minijs

# Executar com teste completo
./run.sh teste_completo.minijs

# Executar com seu próprio arquivo
./run.sh meu_programa.minijs
```

### Método 2: JAR Executável
```bash
# Executar JAR diretamente
java -jar target/minijs-compiler-1.0.jar exemplo.minijs
```

### Método 3: Maven Exec
```bash
# Executar via Maven
mvn exec:java -Dexec.mainClass="com.minijs.MiniJSCompiler" -Dexec.args="exemplo.minijs"
```

---

## 📝 4. Criando Seu Próprio Código MiniJS

### Estrutura Básica
```javascript
// meu_primeiro_programa.minijs

// 1. Declarar variáveis
let nome = "Meu Nome";
const idade = 20;
var ativo = true;

// 2. Usar console.log
console.log("Olá, mundo!");
console.log("Meu nome é:", nome);
console.log("Tenho", idade, "anos");

// 3. Função simples
function saudacao(pessoa) {
    console.log("Olá,", pessoa);
    return "Saudação enviada";
}

// 4. Chamar função
let resultado = saudacao(nome);
console.log(resultado);
```

### Salvar e Executar
```bash
# Salvar como .minijs
# Executar
./run.sh meu_primeiro_programa.minijs
```

---

## 🔍 5. Entendendo a Saída do Compilador

### Exemplo de Saída Completa:
```
====================================
    MiniJS Compiler v1.0
====================================

Arquivo de entrada: exemplo.minijs

--- ANÁLISE LÉXICA ---

Tabela de Tokens:
Linha Token                Lexema                         Tipo
---------------------------------------------------------------
5     LET                  let                            1
5     IDENTIFIER           x                              14
5     ASSIGN               =                              35
5     NUMBER               10                             15
...

Estatísticas de Tokens:
  IDENTIFIER: 45
  SEMICOLON: 23
  LPAREN: 15
  ...

Total de tokens: 234

--- ANÁLISE SINTÁTICA ---

✓ Análise sintática concluída com sucesso!
  Nenhum erro sintático encontrado.

Árvore Sintática Abstrata:
└── program
    ├── statement
    │   └── variableDeclaration
    ...

--- ANÁLISE SEMÂNTICA BÁSICA ---

Variáveis declaradas:
  - x
  - nome
  - resultado

Funções declaradas:
  - main
  - calcular
  - saudacao

Chamadas console.log:
  Total: 8 chamada(s)

====================================
    Compilação Finalizada
====================================
```

### 📊 O que cada seção significa:

1. **ANÁLISE LÉXICA**: Lista todos os tokens identificados
2. **ANÁLISE SINTÁTICA**: Verifica se o código segue a gramática
3. **ANÁLISE SEMÂNTICA**: Identifica variáveis, funções e console.logs

---

## 🧪 6. Arquivos de Teste Inclusos

### `exemplo.minijs`
Demonstra funcionalidades básicas da linguagem
```bash
./run.sh exemplo.minijs
```

### `teste_completo.minijs`
Teste abrangente com TODAS as funcionalidades
```bash
./run.sh teste_completo.minijs
```

### `teste_simples.minijs`
Teste mínimo para verificação rápida
```bash
./run.sh teste_simples.minijs
```

---

## ⚠️ 7. Solução de Problemas

### Problema: "Maven não encontrado"
```bash
# Verificar se Maven está no PATH
echo $PATH
which mvn

# Reinstalar se necessário
brew install maven  # macOS
sudo apt install maven  # Linux
```

### Problema: "Java não encontrado"
```bash
# Verificar JAVA_HOME
echo $JAVA_HOME

# Definir se necessário (adicionar ao ~/.bashrc ou ~/.zshrc)
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64  # Linux
export JAVA_HOME=/usr/libexec/java_home -v 11        # macOS
```

### Problema: "Erro de compilação"
```bash
# Limpar tudo e recompilar
mvn clean
rm -rf target/
./compile.sh
```

### Problema: "Arquivo não encontrado"
```bash
# Verificar se arquivo existe
ls -la *.minijs

# Usar caminho completo se necessário
./run.sh /caminho/completo/para/arquivo.minijs
```

---

## 🎨 8. Recursos da Linguagem MiniJS

### ✅ Tipos de Dados Suportados
- **Números**: `10`, `3.14`, `2.5e-3`
- **Strings**: `"texto"`, `'texto'`
- **Booleanos**: `true`, `false`
- **Arrays**: `[1, 2, 3]`
- **Objetos**: `{nome: "João", idade: 25}`
- **Null/Undefined**: `null`, `undefined`

### ✅ Declarações de Variáveis
```javascript
let variavel = valor;        // Mutável
const constante = valor;     // Imutável
var varAntiga = valor;       // Escopo de função
```

### ✅ Estruturas de Controle
```javascript
// Condicional
if (condicao) {
    // código
} else {
    // código alternativo
}

// Loops
while (condicao) { }
for (let i = 0; i < 10; i++) { }
do { } while (condicao);
```

### ✅ Funções
```javascript
function nome(parametro1, parametro2) {
    // código
    return valor;
}
```

### ✅ Console.log
```javascript
console.log("mensagem");
console.log("valor:", variavel);
console.log(valor1, valor2, valor3);
```

---

## 📚 9. Exemplos Rápidos

### Exemplo 1: Calculadora
```javascript
// calculadora.minijs
function calcular(a, b, op) {
    if (op == "soma") {
        return a + b;
    } else if (op == "subtracao") {
        return a - b;
    } else if (op == "multiplicacao") {
        return a * b;
    } else if (op == "divisao") {
        return a / b;
    }
    return 0;
}

let resultado = calcular(10, 5, "soma");
console.log("Resultado:", resultado);
```

### Exemplo 2: Fibonacci
```javascript
// fibonacci.minijs
function fibonacci(n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

for (let i = 0; i < 10; i++) {
    console.log("fib(" + i + ") =", fibonacci(i));
}
```

### Exemplo 3: Arrays e Objetos
```javascript
// estruturas.minijs
let numeros = [1, 2, 3, 4, 5];
let pessoa = {
    nome: "Ana",
    idade: 25,
    ativa: true
};

console.log("Números:", numeros);
console.log("Pessoa:", pessoa);
console.log("Nome:", pessoa.nome);
console.log("Primeiro número:", numeros[0]);
```

---

## 🚀 10. Próximos Passos

1. **Experimente os exemplos** fornecidos
2. **Crie seus próprios programas** MiniJS
3. **Teste diferentes funcionalidades** da linguagem
4. **Analise a saída** do compilador para entender como funciona
5. **Explore o código fonte** para aprender sobre compiladores

---

## 📞 11. Ajuda e Suporte

### Documentação Adicional
- `README.md` - Visão geral do projeto
- `DOCUMENTACAO.md` - Documentação técnica completa
- `MiniJS.g4` - Gramática ANTLR da linguagem

### Estrutura do Projeto
```
compilador/
├── compile.sh           # Script de compilação
├── run.sh              # Script de execução
├── exemplo.minijs      # Código de exemplo
├── teste_completo.minijs  # Teste abrangente
├── MiniJS.g4           # Gramática da linguagem
├── pom.xml             # Configuração Maven
└── src/main/java/com/minijs/
    ├── MiniJSCompiler.java         # Programa principal
    └── MiniJSSemanticAnalyzer.java # Analisador semântico
```

---

## 🎉 Pronto para Começar!

Agora você tem tudo que precisa para usar o MiniJS Compiler. Comece com:

```bash
./compile.sh
./run.sh exemplo.minijs
```

**Boa compilação!** 🚀