# Gerenciador de Sermões

## Visão Geral

O Gerenciador de Sermões é uma aplicação Spring Boot projetada para gerenciar sermões. Ele fornece funcionalidades para criar, recuperar, atualizar, deletar e filtrar sermões. A aplicação utiliza uma API RESTful e integra-se com um banco de dados usando Spring Data JPA.

## Funcionalidades

- Criar um novo sermão
- Recuperar todos os sermões
- Recuperar um sermão por ID
- Deletar um sermão por ID
- Atualizar um sermão por ID
- Filtrar sermões por igreja, tema e data

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Springdoc OpenAPI (Swagger)
- Maven
- Lombok
- JUnit 5
- Mockito
- PostgreSQL

## Começando

### Pré-requisitos

- Java 17 ou Superior
- Maven 4.0.0 ou Superior
- PostgreSQLa
- Docker

### Instalação

1. Clone o Repositório:
    ```sh
   git clone https://github.com/Brian5m1th/desafio-madisson.git
    cd desafio-madisson
    ```

2. Configure o banco de dados PostgreSQL:

    - Cheque Se O Docker Engine Esta Ativo
   
    - Defina as Variaveis de Ambiente Presentes do `application.yml` Com Suas Credenciais Do Banco De Dados:
        ```bash
DATASOURCE_URL=
POSTGRES_USER=
POSTGRES_PASSWORD=
POSTGRES_DB=
        ```



3. Execute a Aplicação:
    ```sh
    ./mvnw spring-boot:run
    ```
    
4. Acesse a Documentação da API Gerada pelo [Swagger](http://localhost:8080/sermao-manager/api/public/swagger) em:
   ```bash
   http://localhost:8080/sermao-manager/api/public/swagger
   ```
   
   
   ### Executando Testes

 Inicie os containers no Docker:
   ```bash
   docker compose up -d
   ```
   
Para executar os testes unitários, use o seguinte comando:
```sh
./mvnw test
  ```

by  BBB
