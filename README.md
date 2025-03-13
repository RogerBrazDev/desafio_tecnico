# DummyJSON Client

## 🚀 Sobre o Projeto
Este projeto é um microsserviço desenvolvido em **Java 17** e **Spring Boot 3.2.5** que interage com a API pública **DummyJSON** para realizar operações de busca de produtos.

✨ **Principais Características:**
- ✅ **Migrado para Java 17 e Spring Boot 3.2.5**
- ✅ **Estruturado para execução via Docker**
- ✅ **Documentação via OpenAPI / Swagger**

---

## 🛠️ Tecnologias Utilizadas
- ☕ **Java 17**
- 🚀 **Spring Boot 3.2.5**
- 🐳 **Docker & Docker Compose**
- 📖 **OpenAPI / Swagger**

---

## ▶️ Como Executar o Projeto com Docker

### 📌 Pré-requisitos
Certifique-se de ter os seguintes requisitos instalados:
- 🔹 [Docker](https://www.docker.com/get-started)
- 🔹 [Docker Compose](https://docs.docker.com/compose/install/)

### 📌 Passos para Execução

1️⃣ **Clone o repositório:**
```bash
 git clone https://github.com/WendellTufano/code-challenge-migration.git
 cd dummyjson-client
```

2️⃣ **Construa e execute o contêiner:**
```bash
 docker-compose up --build -d
```

3️⃣ **Acesse o serviço:**
- O serviço estará disponível em: **[http://localhost:8080](http://localhost:8080)**

---

## 📜 Documentação da API
- 📌 **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- 📌 **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🔧 Comandos Adicionais

🔍 **Verificar Logs do Contêiner**
```bash
 docker-compose logs -f
```

🛑 **Parar o Contêiner**
```bash
 docker-compose down
```

---

## 📞 Contato
💡 Desenvolvido por **Roger Braz**.

📧 **Email:** [seuemail@email.com](mailto:seuemail@email.com)  
🔗 **LinkedIn:** [linkedin.com/in/rogerbraz](https://www.linkedin.com/in/rogerbraz)

---

📝 **Licença**
Este projeto está sob a licença **MIT**. Consulte o arquivo **LICENSE** para mais detalhes.

