DummyJSON Client - Java 17 e Spring Boot 3.2.5
Descrição do Projeto
Este projeto é um microsserviço Java que interage com a API pública DummyJSON para realizar operações de busca de produtos. O projeto foi migrado para Java 17 e Spring Boot 3.2.5.

Desenvolvido por Roger Braz.

Como Executar o Projeto com Docker
Pré-requisitos
Docker instalado.

Docker Compose instalado.

Passos para Executar
Clone o repositório:

bash
Copy
git clone https://github.com/WendellTufano/code-challenge-migration.git
cd dummyjson-client
Construa e execute o contêiner:

bash
Copy
docker-compose up -d
Acesse o serviço:

O serviço estará disponível em http://localhost:8080.

Links Úteis
Swagger UI: Acesse a documentação da API em http://localhost:8080/swagger-ui.html.

OpenAPI JSON: Acesse o JSON da API em http://localhost:8080/v3/api-docs.

Comandos Adicionais
Verificar Logs do Contêiner
bash
Copy
docker-compose logs -f
Parar o Contêiner
bash
Copy
docker-compose down
Contato
Desenvolvido por Roger Braz.