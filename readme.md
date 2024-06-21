<p align="center" width="100%">
    <img width="30%" src="imagens\picpay-logo.jpg"> 
</p>


<h3 align="center">
  Desafio Backend do PicPay
</h3>

<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">

</p>

Resolução do desafio proposto pelo repositorio Picpay, confira detalhes [neste link](https://github.com/PicPay/picpay-desafio-backend/blob/main/readme.md).


# Sumário

+ [1 - Como interagir com o banco de dados?](#como-interagir-com-o-banco-de-dados)
+ [2 - Como interagir com a API?](#como-interagir-com-a-api)
+ [3 - Tecnologias utilizadas](#tecnologias-utilizadas)
+ [4 - Desenvolvimento](#desenvolvimento)
+ [5 - Construção](#construção)
+ [6 - Contribuições](#contribuições)
+ [7 - Links](#links)
+ [8 - Exemplos](#exemplos)




## Como interagir com o banco de dados?
- Utilizamos o [H2 DATABASE](https://h2database.com/html/main.html)

O banco já com dois dados na tabela  tb_wallet_type:

![image](imagens\banco-dados-01.png)


## Como interagir com a API?
- Utilizamos o [Postman](https://www.postman.com/)

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* H2 - Database
* Spring Cloud Open Feign
* ControllerAdvice & Problem Details
* Hibernate Validator
* Lombok

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/erichiroshi/picpay-desafio-backend.git
```

## Construção

Para construir o projeto com o Maven, executar os comando abaixo:

```shell
mvn clean install
ou
.\mvnw clean install 
```

O comando irá baixar todas as dependências do projeto e criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

## Contribuições

Contribuições são sempre bem-vindas! Para contribuir lembre-se sempre de adicionar testes unitários para as novas classes com a devida documentação.

## Links
Projeto desenvolvido seguindo o canal [Build & Run](https://www.youtube.com/watch?v=dttXo48oXt4&list=PLxCh3SsamNs7y1Y-QaVdWx0MUh0wvo7TV)

## Exemplos

### 1 - POST /wallets
![alt text](imagens\postman-01.png)

e como resposta:

![alt text](imagens\postman-02.png)

### 2 - POST /transfer

![alt text](imagens\postman-03.png)

## Developed by Eric Hiroshi