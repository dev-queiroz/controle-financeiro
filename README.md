# Controle Financeiro - API Backend

API REST para controle de lançamentos financeiros pessoais. Desenvolvida com Java, Spring Boot 3.4.4, MongoDB e documentada via OpenAPI (Swagger).

---

## 📊 Funcionalidades

- CRUD completo de lançamentos financeiros
- Classificação por tipo (RECEITA / DESPESA)
- Filtro por mês e ano
- Cálculo de saldo mensal
- Validação de dados de entrada
- Documentação Swagger integrada (SpringDoc)

---

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.4.4
- Spring Web
- Spring Data MongoDB
- MongoDB
- Docker & Docker Compose
- SpringDoc OpenAPI

---

## ⚙️ Executando com Docker

### 1. Compile o projeto:

```bash
mvn clean package -DskipTests
```

### 2. Suba os containers:

```bash
docker-compose up -d --build
```

### 3. Acesse a documentação da API:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔍 Exemplos de uso (Swagger)

### POST /lancamentos

Cria um lançamento financeiro.

```json
{
  "descricao": "Salário",
  "valor": 5000.00,
  "tipo": "RECEITA",
  "data": "2025-04-10"
}
```

### GET /lancamentos?mes=4&ano=2025

Retorna todos os lançamentos do mês/ano.

### GET /lancamentos/saldo?mes=4&ano=2025

Calcula o saldo (receitas - despesas) no período.

---

## 🌐 Variáveis de ambiente

O `application.properties` está preparado para Docker:

```properties
spring.data.mongodb.uri=${SPRING_DATA_MONGODB_URI:mongodb://localhost:27017/financeirodb}
```

O `docker-compose.yml` define a URI corretamente.

---

## 📁 Estrutura de pastas

```
controle-financeiro/
├── src/main/java/
│   ├── com.exemplo.financeiro/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── model/
│   │   └── dto/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🌟 Autor

Desenvolvido por Douglas Vinícios dos Santos Queiroz – Projeto de portfólio focado em backend Java com Spring Boot.

---

## 🚫 Licença

Este projeto está sob a [licença MIT](https://github.com/dev-queiroz/controle-financeiro/blob/master/LICENSE).

