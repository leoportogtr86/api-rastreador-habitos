# Rastreador de Hábitos

Este é um projeto de um Rastreador de Hábitos desenvolvido com Java e Spring Boot. A aplicação permite adicionar,
listar, atualizar e deletar hábitos diários, além de verificar o progresso ao longo do tempo.

## Funcionalidades

- Adicionar um novo hábito
- Listar todos os hábitos
- Atualizar um hábito existente
- Deletar um hábito

## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.6
- Spring Data JPA
- H2 Database

## Configuração do Projeto

### Pré-requisitos

- Java 11 ou superior instalado
- Maven instalado

### Passo a Passo

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/leoportogtr86/api-rastreador-habitos.git
   cd api-rastreador-habitos
   ```

2. **Configuração do banco de dados:**

   O projeto está configurado para usar o banco de dados H2 em memória. A configuração pode ser encontrada no
   arquivo `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Execute a aplicação:**

   ```bash
   mvn spring-boot:run
   ```

4. **Acesse o console do H2:**

   O console do H2 pode ser acessado em `http://localhost:8080/h2-console`. Use as seguintes credenciais:

    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **User Name:** `sa`
    - **Password:** `password`

## Endpoints da API

### Listar todos os hábitos

- **URL:** `/api/habits`
- **Método:** `GET`
- **Resposta:** Lista de hábitos

  ```json
  [
      {
          "id": 1,
          "name": "Exercitar",
          "startDate": "2024-07-01",
          "completed": false
      },
      ...
  ]
  ```

### Adicionar um novo hábito

- **URL:** `/api/habits`
- **Método:** `POST`
- **Corpo da Requisição:**

  ```json
  {
      "name": "Exercitar",
      "startDate": "2024-07-01",
      "completed": false
  }
  ```

- **Resposta:** Hábito criado

  ```json
  {
      "id": 1,
      "name": "Exercitar",
      "startDate": "2024-07-01",
      "completed": false
  }
  ```

### Atualizar um hábito existente

- **URL:** `/api/habits/{id}`
- **Método:** `PUT`
- **Corpo da Requisição:**

  ```json
  {
      "name": "Exercitar",
      "startDate": "2024-07-01",
      "completed": true
  }
  ```

- **Resposta:** Hábito atualizado

  ```json
  {
      "id": 1,
      "name": "Exercitar",
      "startDate": "2024-07-01",
      "completed": true
  }
  ```

### Deletar um hábito

- **URL:** `/api/habits/{id}`
- **Método:** `DELETE`
- **Resposta:** Código de status 204 (No Content)

## Estrutura do Projeto

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── habittracker
│   │               ├── HabitTrackerApplication.java
│   │               ├── controller
│   │               │   └── HabitController.java
│   │               ├── model
│   │               │   └── Habit.java
│   │               ├── repository
│   │               │   └── HabitRepository.java
│   │               └── service
│   │                   └── HabitService.java
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
    └── java
        └── com
            └── example
                └── habittracker
                    └── HabitTrackerApplicationTests.java
```
