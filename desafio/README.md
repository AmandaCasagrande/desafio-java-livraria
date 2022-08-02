# Java API - Livraria

Amanda Casagrande, 2022

## 🛠️ Tecnologias e Ferramentas:

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
Run class DesafioApplication
`
## 🚀 Requests API:

>`
https://github.com/AmandaCasagrande/desafio-java-livraria/tree/main/collection-postman
`

## 🔨 Gerador de UUID
>`
https://www.uuidgenerator.net/
`

## 💼 Regra de Negócios:

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

## ⚙ Padrão de Projeto:

* Facilita o desenvolvimento entre a equipe;
* Facilita a compreensão do sistema;
* É possível o reuso de soluções em outros sistemas;



