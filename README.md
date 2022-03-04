<h1>ApiRest de gerenciamento de pessoas com SpringBoot </h1>
<p>Neste projeto foi desenvolvidas uma ApiRest de gerenciamento de pessoas com persistência realizada em banco de dados
de teste H2. São armazenados os seguintes atributos:</p>
<ul>
    <li>Nome Completo</li>
    <li>CPF</li>
    <li>Data de aniversário</li>
    <li>Telefone: </li>
    <ul>
    <li>Tipo</li>
    <li>Número</li>
    </ul>
</ul>

<p>Para executar o projeto no terminal, digite o seguinte comando:</p><br>

```
mvn spring-boot:run
```
<p>Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:</p><br>

```
http://localhost:8080/personapi
```
<p>Link do projeto no Heroku:<br>

```
https://peopleeapi.herokuapp.com/personapi
```
<h1>Teste dos métodos com Postman</h1>
<p><b>Post</b><p>


```
Tipo de requisição: POST
{
    "firstName": "Samuel",
    "lastName": "Nascimento Fávero",
    "cpf": "13515900646",
    "birthDate": "01-07-1996",
    "phones": [
        {
        "type": "MOBILE",
        "number": "(32) 98401-1855"
    }
    ]
}

```

<p><b>ListAll</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/personapi
```

<p><b>FindById</b></p>

```
Tipo de requisição: GET

URL: localhost:8080/personapi/1
```

<p><b>Delete</b></p>

```
Tipo de requisição: DELETE

URL: localhost:8080/personapi/1
```
<p><b>Update</b></p>

Tipo de requisição: `PUT`

URL: `localhost:8080/personapi`

Body:

```
{
    "id": 1,
    "firstName": "Samuel",
    "lastName": "Nascimento Fávero",
    "cpf": "23422211221112222",
    "birthDate": "01-07-1996",
    "phones": [
        {
            "id": 1,
            "type": "MOBILE",
            "number": "(32) 98401-1852"
        }
    ]
}
```
<h1>
<a href="https://www.linkedin.com/in/samuelfavero/">Linkedin<a>
</h1>