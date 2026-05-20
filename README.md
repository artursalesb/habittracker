# Habit Tracker API

Uma API REST desenvolvida com Spring Boot para gerenciamento de hábitos e cálculo de pontuação baseado em diferentes estratégias.

O projeto foi criado com foco em boas práticas de desenvolvimento backend, arquitetura em camadas e aplicação de Design Patterns clássicos do GoF utilizando o ecossistema Spring.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok
- Jakarta Validation
- Swagger / OpenAPI

---

## Funcionalidades

- Criar hábitos
- Listar hábitos
- Buscar hábito por ID
- Atualizar hábitos
- Deletar hábitos
- Calcular score de hábitos
- Validação de dados
- Documentação automática da API com Swagger

---

## Arquitetura do projeto

O projeto foi estruturado seguindo separação de responsabilidades:

```text
controller → rotas da API
service → regras de negócio
repository → acesso ao banco
entity → entidades JPA
dto → transferência de dados
strategy → estratégias de cálculo
factory → criação de objetos
Design Patterns utilizados
Strategy Pattern

O cálculo de score dos hábitos foi implementado utilizando o padrão Strategy.

Cada tipo de hábito possui sua própria estratégia de cálculo:

DAILY
WEEKLY
MONTHLY

Isso permite adicionar novos comportamentos sem alterar a lógica principal da aplicação.

## Factory Pattern

A criação de entidades Habit foi centralizada em uma Factory, desacoplando a lógica de construção dos objetos da camada de serviço.

Endpoints principais
Método	  Endpoint	          Descrição
GET  	    |habits	            |Lista todos os hábitos
GET	      |habits/{id}	      |Busca hábito por ID
POST	    |habits	            |Cria um novo hábito
PUT	      |habits/{id}	      |Atualiza um hábito
DELETE	  |habits/{id}	      |Remove um hábito
GET	      |habits/{id}/score	|Calcula score do hábito

Exemplo de requisição
POST /habits
{
  "name": "Workout",
  "description": "Train every day",
  "streak": 7,
  "type": "DAILY"
}

...

## Banco de dados H2

A aplicação utiliza H2 Database em memória para facilitar testes e desenvolvimento.

Acesso ao console H2
http://localhost:8080/h2-console
JDBC URL
jdbc:h2:mem:testdb
Swagger / OpenAPI

A documentação interativa da API pode ser acessada em:

http://localhost:8080/swagger-ui/index.html
Como executar o projeto
Clonar repositório
git clone <url-do-repositorio>
Entrar na pasta
cd habittracker
Executar aplicação
./mvnw spring-boot:run

Ou execute diretamente pela IDE.

...

## Objetivo do projeto

Este projeto foi desenvolvido como desafio prático com foco em:

Spring Boot
APIs REST
Design Patterns GoF
Arquitetura backend
Boas práticas em Java
Autor

Desenvolvido por Artur Sales.
