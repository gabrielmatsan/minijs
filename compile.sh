#!/bin/bash

echo "======================================"
echo "   Compilando MiniJS Compiler"
echo "======================================"
echo ""

# Verifica se Maven está instalado
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven não está instalado!"
    echo "Por favor, instale o Maven primeiro:"
    echo "  brew install maven  (no macOS)"
    echo "  ou baixe de: https://maven.apache.org/download.cgi"
    exit 1
fi

# Limpa compilação anterior
echo "🧹 Limpando compilação anterior..."
mvn clean

# Compila o projeto
echo "🔨 Compilando projeto..."
mvn compile

# Verifica se a compilação foi bem sucedida
if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Compilação concluída com sucesso!"
    echo ""
    echo "Para executar o analisador, use:"
    echo "  ./run.sh exemplo.minijs"
else
    echo ""
    echo "❌ Erro na compilação!"
    exit 1
fi