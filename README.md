# Java Basic API

## 🛠 Packages and Tools:

* Java JDK 11.0
* Intellij Community Edition 2022.1
* DBeaver
* Postman 9.19
* Spring Boot 2.7.0 (and Maven and Dependencies)
    * Spring Web (Web)
    * Spring Data JPA (SQL)
      * Spring Data
      * Hibernate
    * Postgres Driver (SQL)
    * Lombok

## 💻 Run project:

>`
Run class JavaApiBasicaApplication
`
## 🚀 Requests API:

User (POST)

**Request URL:**

```
http://localhost:8080/api/livraria
```

**Body content (type raw-JSON):**

```
{
"name": "Irineu",
"login": "irineu",
"password": "123"
}
```

*code/id = auto increment*

status (GET)

```
http://localhost:8080/api/livraria
```

## Regra de Negócios:

--> Livro [X]
* String       Titulo 
* String       Descrição
* BigDecimal   Preço
* LocalDate    DataLancamento
* BookStore    Livraria (many to one com livraria)
* List<Author> autores (many to many com livro) 

--> Livraria [X]
* String                                       Nome
* String || Localização(pra que quiser tentar) Localizacao
* String                                       Email
* String                                       numero Telefone
* String                                       Cnpj
* List<Book>                                   livros (one to many com livros)

--> Autor [X]
* String     Nome
* String     Sexo
* List<Book> livros (many to many com livro)

Requisitos:

Separar o projeto por entidades, ou seja, tudo que for de uma entidade como service ou dto fica no pacote dela []
CRUD [X]
previnir NullPointer [x]
divisão completa do projeto [x]
  * service [x]
  * Entidade [x]
  * DTO [x]
  * mapper [x]
  * repository [x]
  * Controler [x]
  
Extras:

* Efetuar trocas de livros []
* filtrar livro por autores[], titulo[x], preço[x], DataLancamento[x], Livraria []
* Solicitar um livro para outra livraria, procurar em qual livraria esta o livro e solicitar o livro para ela

## Padrão de Projeto:

* Facilita o desenvolvimento entre a equipe;
* Facilita a compreensão do sistema;
* É possível o reuso de soluções em outros sistemas;



