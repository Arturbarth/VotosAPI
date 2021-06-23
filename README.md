# VotosAPI

- [JDK 11: Necessário para executar o projeto Java](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
- [Postman - Para execução e validação do projeto](https://www.postman.com/downloads/)
- [Apache JMetter para teste de performance](https://jmeter.apache.org/download_jmeter.cgi)
- [Git - Para realizar o clone do projeto](https://git-scm.com/downloads)
- [Docker - Para o container do banco de dados do Projeto](https://docs.docker.com/docker-for-windows/install/)
- [PostgreSQL - Banco de Dados do Projeto](https://www.postgresql.org/download/)



## PostgreSQL Docker

Pode ser utilizado o PostgreSQL no Docker. Para isso execute os seguintes comandos via shell:
Certifique-se de que a porta 5432 esteja disponível.

```shell
docker pull postgres
docker pull dpage/pgadmin4
docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

## Desenvolvimento

Para iniciar, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretório de sua preferencia"
git clone https://github.com/Arturbarth/VotosAPI.git
```
### Construção

Para construir o projeto com o Maven, no diretório raiz executar os comando abaixo:

```shell
.\mvnw clean install
```

### Execução

Para executar o projeto com o Maven, no diretório raiz executar os comando abaixo:

```shell
.\mvnw spring-boot:run
```
O projeto está configurado para executar na porta 8080, certifique-se de que a mesma esteja disponível ou altere o arquivo application.properties e informe a porta.

### Documentação Swagger

Acesse a documentação da API na seguinte URL:

- [Documentação](http://localhost:8080/swagger-ui.html)

### Postman

Você pode utilizar o Swagger para testar a API mas se preferir pode testar a API utilizando Postman. Para isso, importe o seguinte arquivo no seu postman:
- [Postman](https://github.com/Arturbarth/VotosAPI/blob/main/southsystem%20VotoAPI.postman_collection.json)

## Funcionalidades

A API foi desenvolvida com as seguintes funcionalidades:
1. Cadastrar um Associado
* http://localhost:8080/associado
* Get
* Post
* Get{id}


2. Cadastrar uma Pauta
* http://localhost:8080/pauta
* Get
* Post
* Get{id}


3. Abrir uma sessão de votação
* http://localhost:8080/sessao
* Get
* Post
* Get{id}

4. Votar
* http://localhost:8080/voto
* Get
* Post
* Get{id}
