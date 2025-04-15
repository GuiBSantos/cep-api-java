# 📦 ViaCEP Java API

Este é um projeto simples desenvolvido em Java para realizar buscas de endereços a partir de CEPs utilizando a [API ViaCEP](https://viacep.com.br/). Ele consome a API, trata possíveis erros e salva os dados retornados em um arquivo `.json`.

## 🚀 Tecnologias e Ferramentas

- Java 17+
- API HTTP nativa (`HttpClient`)
- GSON (serialização/deserialização JSON)
- Organização em pacotes: `api`, `model`, `service`, `exceptions`, `utils`
- IntelliJ IDEA (opcional)

## 📁 Estrutura de Pacotes

```plaintext
cepapi/
├── api/           # Comunicação com a API ViaCEP
├── exceptions/    # Exceções customizadas
├── model/         # Classe Cep (record)
├── service/       # Lógica principal de busca
├── utils/         # Escrita de arquivos JSON
└── App.java       # Classe principal (ponto de entrada)
```

## ✅ Funcionalidades

- Busca de CEPs via terminal
- Validação de formato de CEP
- Tratamento de CEPs não encontrados ou com resposta inválida
- Geração de arquivo `ceps.json` com os dados retornados

## 📌 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/GuiBSantos/cep-api-java.git
   ```
2. Compile e execute o projeto:
   - Pelo IntelliJ: Rode a classe `App.java`
   - Ou pelo terminal:
     ```bash
     javac -d out src/cepapi/**/*.java
     java -cp out cepapi.App
     ```

## 💡 Exemplo de Uso

```plaintext
Digite um CEP: 01001000
Resultado salvo em ceps.json!
```

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

> Projeto criado com fins educacionais para treino de consumo de API e manipulação de arquivos em Java.
