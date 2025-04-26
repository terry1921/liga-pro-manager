#!/bin/bash

echo "🚀 Starting project setup..."

# Install pre-commit if not installed
if ! command -v pre-commit &> /dev/null
then
    echo "🔧 pre-commit not found. Installing via pip..."
    pip install pre-commit
fi

# Install pre-commit hooks
echo "🔗 Installing pre-commit hooks..."
pre-commit install

echo "✅ Setup completed successfully!"
