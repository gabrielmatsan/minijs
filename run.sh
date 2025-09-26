#!/bin/bash

echo "🚀 MiniJS Compiler"
echo "=================="

if [ $# -eq 0 ]; then
    echo ""
    echo "❗ Uso: ./run.sh <arquivo.minijs>"
    echo ""
    echo "📋 Exemplos disponíveis:"
    echo "   ./run.sh exemplo.minijs         # Exemplo básico"
    echo "   ./run.sh teste_completo.minijs  # Teste abrangente"
    echo "   ./run.sh teste_simples.minijs   # Teste mínimo"
    echo ""
    echo "📝 Para criar seu próprio arquivo:"
    echo "   # Criar arquivo com extensão .minijs"
    echo "   ./run.sh meu_programa.minijs"
    echo ""
    echo "📚 Documentação: cat TUTORIAL.md"
    exit 1
fi

# Verifica se o arquivo existe
if [ ! -f "$1" ]; then
    echo ""
    echo "❌ Arquivo não encontrado: $1"
    echo ""
    echo "📁 Arquivos .minijs disponíveis:"
    ls -1 *.minijs 2>/dev/null || echo "   Nenhum arquivo .minijs encontrado"
    echo ""
    exit 1
fi

echo ""
echo "📄 Processando arquivo: $1"
echo "⏳ Executando análise..."
echo ""

# Executa o compilador
if [ -f "target/minijs-compiler-1.0.jar" ]; then
    java -jar target/minijs-compiler-1.0.jar "$1"
else
    echo "❌ JAR não encontrado! Execute primeiro:"
    echo "   ./compile.sh"
    echo "ou:"
    echo "   mvn clean package"
    exit 1
fi