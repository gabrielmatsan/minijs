#!/bin/bash

echo "🚀 MiniJS Compiler - Início Rápido"
echo "=================================="
echo ""

# Verificar Java
if ! command -v java &> /dev/null; then
    echo "❌ Java não encontrado!"
    echo "Por favor, instale Java 11 ou superior:"
    echo "  macOS: brew install openjdk@11"
    echo "  Linux: sudo apt install openjdk-11-jdk"
    exit 1
else
    echo "✅ Java encontrado: $(java -version 2>&1 | head -1)"
fi

# Verificar Maven
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven não encontrado!"
    echo "Por favor, instale Maven:"
    echo "  macOS: brew install maven"
    echo "  Linux: sudo apt install maven"
    exit 1
else
    echo "✅ Maven encontrado: $(mvn -version | head -1)"
fi

echo ""
echo "🔨 Compilando projeto..."
mvn clean compile package -q

if [ $? -eq 0 ]; then
    echo "✅ Compilação bem-sucedida!"
else
    echo "❌ Erro na compilação!"
    exit 1
fi

echo ""
echo "🧪 Executando teste básico..."
java -jar target/minijs-compiler-1.0.jar exemplo.minijs > /dev/null 2>&1

if [ $? -eq 0 ]; then
    echo "✅ Teste básico passou!"
else
    echo "❌ Erro no teste básico!"
    exit 1
fi

echo ""
echo "🎉 Tudo pronto! Agora você pode:"
echo ""
echo "📝 Testar exemplos:"
echo "   ./run.sh exemplo.minijs"
echo "   ./run.sh teste_completo.minijs"
echo ""
echo "🛠️ Criar seu próprio código:"
echo "   # Criar arquivo .minijs"
echo "   ./run.sh meu_arquivo.minijs"
echo ""
echo "📚 Ler documentação:"
echo "   cat TUTORIAL.md"
echo "   cat DOCUMENTACAO.md"
echo ""
echo "Happy coding! 🚀"