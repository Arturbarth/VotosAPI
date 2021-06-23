# VotosAPI

- [JDK 11: Necessário para executar o projeto Java](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
- [Postman - Para execução e validação do projeto](https://www.postman.com/downloads/)
- [Apache JMetter para teste de performance](https://jmeter.apache.org/download_jmeter.cgi)
- [Git - Para realizar o clone do projeto](https://git-scm.com/downloads)
- [Docker - Para o container do banco de dados do Projeto](https://docs.docker.com/docker-for-windows/install/)
- [PostgreSQL - Banco de Dados do Projeto](https://www.postgresql.org/download/)
- [Desenvolvido por Artur Barth - Linkedin](https://www.linkedin.com/in/artur-barth/)



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
- [Documentação Swagger neste link http://45.160.148.172:42000/swagger-ui.html](http://45.160.148.172:42000/swagger-ui.html)
- [Documentação Swagger API Online neste link http://45.160.148.172:42000/swagger-ui.html](http://45.160.148.172:42000/swagger-ui.html)

### Postman

Você pode utilizar o Swagger para testar a API mas se preferir pode testar a API utilizando Postman. Para isso, importe o seguinte arquivo no seu postman:
- [Download arquivo Postman neste link](https://github.com/Arturbarth/VotosAPI/blob/main/southsystem%20VotoAPI.postman_collection.json)

### Dependências

1. **spring-boot-starter-data-jpa**
- Dependência de acesso à dados, ex JpaRepository, abstraindo toda a camada de acesso.

2. **spring-boot-starter-web**
- Dependência utilizada na API para trabalhar com REST e requisições HTTP

3. **spring-boot-starter-validation**
- Necessária para anotações de validações. Ex: @NotNull

4. **spring-boot-devtools**
- Para facilitar o desenvolvimento, dar auto-refresh no servidor

5. **postgresql**
- Banco de dados utilizado no projeto

6. **spring-boot-starter-test**
- Utilizada para testes no JUnit por exemplo mas não implementei ainda por falta de prazo.

7. **lombok** (utilizei no inicio mas resolvi remover e utilizar somente starter-validation )

8. **jakarta.validation-api**
- BeanValidation utilizada na API

9. **springdoc-openapi-ui**
- Utilizado para gerar a documentação Swagger da API automáticamente.

10. **spring-boot-starter-actuator**
- Utilizado para monitoramento do projeto, utilizado principalmente quando "containerizar" a aplicação para rodar via Docker e Kubernetes. Fornece monitoramento de falhas da API.

11. **spring-boot-starter-cache**
- Utilizado para gerar uma camada de cache nas requisições, dessa forma reduz drásticamente o acesso ao banco de dados trazendo mais performance para a aplicação.


## Funcionalidades

A API foi desenvolvida com as seguintes funcionalidades:
1. Cadastrar um Associado
* http://localhost:8080/associado
* http://45.160.148.172:42000/associado
* Get
* Post
* Get{id}

2. Cadastrar uma Pauta
* http://localhost:8080/pauta
* http://45.160.148.172:42000/pauta
* Get
* Post
* Get{id}


3. Abrir uma sessão de votação
* http://localhost:8080/sessao
* http://45.160.148.172:42000/sessao
* Get
* Post
* Get{id}

4. Votar
* http://localhost:8080/voto
* http://45.160.148.172:42000/voto
* Get
* Post
* Get{id}

Abaixo imagem da documentação Swagger gerada.

<img width="1608" alt="Documentação Swagger" src="https://user-images.githubusercontent.com/3423282/123038584-13daef80-d3c7-11eb-8055-3a931672f8ae.png">

## Decisões técnicas
Primeiramente quero demonstrar minha imensa gratidão ao ***[Elton Marai Moreira (Linkedin)](https://www.linkedin.com/in/elton-macari-moreira-31009762/), especialista Java no Itaú Unibanco*** que me auxiliou sanando algumas dúvidas ténicas, dando dicas de arquiteturada API e etc.
Inicialmente pensei em fazer a API muito semelhante ao que é demonstrado nos cursos da ALURA. Ao conversar com o Elton, especialista Java citado logo acima, resolvi mudar um pouco a arquitetura inicialmente proposta onde não haveriam as classes Service e decidi pela implementação das mesmas para separar a lógica e tratamentos de excessão Controller. Isso tem como objetivo aumentar a manutenabilidade e manter a API dentro dos padrões e convenções de desenvolvimento Java.
Optei pelo banco de dados PostgreSQL por ser um banco de fácil configuração e que se integra super bem com APIs Java, além de ser performático e escalável. Inicialmente ia utilizar Oracle. A decisão de utilizar Oracle não foi levada adiante visto que dificulta configuração, deploy da aplicação e N outros motivos.
Decidi pelo Apache JMetter para realizar testes de performance da API pois já estou utilizando o mesmo em outro teste de performance que estou implementando há algumas semanas e o mesmo funciona muito bem! Apesar de ter verificado que existem plugins para utilizar na API resolvi não utilizar os mesmos. Pausei o desenvolvimento do teste de performance para focar nessa API. O teste descrito abaixo também utilizará Postgres rsrs
[Teste de performance Linguagems Programação https://github.com/Arturbarth/TestePerformanceLinguagens](https://github.com/Arturbarth/TestePerformanceLinguagens)
Tomei a decisão de utilizar o pacote de monitoramento na API para estudar e aprender sobre o seu funcionamento. Além disso, o pacote deixa a API preparada para executar em ambiente containerizado (Docker + Kubernetes por exemplo). 


#### Tarefa Bônus 1 - Integração com sistemas externos
Realizado a implementação da validação de CPF em API externa conforme solicitado.

#### Tarefa Bônus 2 - Mensageria e filas
Nunca trabalhei com messageria e fila em Java, somente trabalhei com messageria em Delphi. 
Vi alguns tutoriais na internet e verificado que é super fácil implementar com RabbitMQ e com ActiveMQ, ambos possuem plugins do Mavem mas resolvi não implementar por falta de prazo.

#### Tarefa Bônus 3 - Performance
Utilizei JMetter para aferir alguns testes na API sem cache.
Após verificar os resultados resolvi pesquisar sobre como melhorar e resolvi implementar o sistema de cache que é super simples e de rápida implementação.
Aumentei também o pool de conexões do Postgres visto que estou executando 100 Threads.

Testes realizados em um Intel Core i9 10850k @4.9Ghz:

##### Teste de vazão da API sem Cache:
Resultado para 1 milhão de requisições GET em Associado com 10 associados cadastrados:
Tempo: 1:35 = 1 minuto e 35 segundos.
Vazão: 10.525,7 requests por segundo.
Uso de CPU Médio: 91%

<img width="1526" alt="Resultado Vazão sem Cache" src="https://user-images.githubusercontent.com/3423282/123037508-29e7b080-d3c5-11eb-9265-0efc05ef5d32.png">

##### Teste de vazão da API com Cache:

Resultado para 1 milhão de requisições GET em Associado com 10 associados cadastrados:
Tempo: 1:03 = 1 minuto e 03 segundos
Vazão: 15.660,0 requests por segundo.
Uso de CPU Médio: 99%

<img width="1526" alt="Resultado Vazão com Cache" src="https://user-images.githubusercontent.com/3423282/123037563-3d931700-d3c5-11eb-99a4-97cc3f233038.png">

#### Tarefa Bônus 4 - Versionamento da API
Por falta de prazo resolvi não implementar versionamento na API mas implementei Swagger que facilita a implementação de versionamento na API.
É possível veriricar também que já deixei a plicação preparada para versionamento, separando os controllers em uma pasta chamda V1. Dessa forma, caso surja a necessidade de desenvolver uma nova versão é possível faze-lo com facilidade seguindo entre várias estratégias disponíveis.


## Publicar API
Resolvi deixar a API rodando via Docker em um servidor, dessa forma vocês podem testar a API diretamente do meu servidor na seguinte URL:
Os arquivos acima também estão apontando para essa URL que ficará online por tempo limitado.

##### http://45.160.148.172:42000/swagger-ui.html





-------------------

# Desafio Técnico
## Objetivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação. Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:
- Cadastrar uma nova pauta;
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default);
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);
- Contabilizar os votos e dar o resultado da votação na pauta.

Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A escolha da linguagem, frameworks e bibliotecas é livre (desde que não infrinja direitos de uso).

É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

### Tarefas bônus
As tarefas bônus não são obrigatórias, mas nos permitem avaliar outros conhecimentos que você possa ter.

A gente sempre sugere que o candidato pondere e apresente até onde consegue fazer, considerando o seu
nível de conhecimento e a qualidade da entrega.
#### Tarefa Bônus 1 - Integração com sistemas externos
Integrar com um sistema que verifique, a partir do CPF do associado, se ele pode votar
- GET https://user-info.herokuapp.com/users/{cpf}
- Caso o CPF seja inválido, a API retornará o HTTP Status 404 (Not found). Você pode usar geradores de CPF para gerar CPFs válidos;
- Caso o CPF seja válido, a API retornará se o usuário pode (ABLE_TO_VOTE) ou não pode (UNABLE_TO_VOTE) executar a operação
Exemplos de retorno do serviço

#### Tarefa Bônus 2 - Mensageria e filas
Classificação da informação: Uso Interno
O resultado da votação precisa ser informado para o restante da plataforma, isso deve ser feito preferencialmente através de mensageria. Quando a sessão de votação fechar, poste uma mensagem com o resultado da votação.

#### Tarefa Bônus 3 - Performance
Imagine que sua aplicação possa ser usada em cenários que existam centenas de milhares de votos. Ela deve se comportar de maneira performática nesses cenários;
- Testes de performance são uma boa maneira de garantir e observar como sua aplicação se comporta.

#### Tarefa Bônus 4 - Versionamento da API
Como você versionaria a API da sua aplicação? Que estratégia usar?

### O que será analisado
- Simplicidade no design da solução (evitar over engineering)
- Organização do código
- Arquitetura do projeto
- Boas práticas de programação (manutenibilidade, legibilidade etc)
- Possíveis bugs
- Tratamento de erros e exceções
- Explicação breve do porquê das escolhas tomadas durante o desenvolvimento da solução
- Uso de testes automatizados e ferramentas de qualidade
- Limpeza do código
- Documentação do código e da API
- Logs da aplicação
- Mensagens e organização dos commits

### Observações importantes
- Não inicie o teste sem sanar todas as dúvidas
- Iremos executar a aplicação para testá-la, cuide com qualquer dependência externa e deixe claro caso haja instruções especiais para execução do mesmo
- Teste bem sua solução, evite bugs

