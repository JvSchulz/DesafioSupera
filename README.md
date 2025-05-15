# DesafioSupera
Esse projeto foi usado como base para um processo seletivo a onde tive 4 dias para pesquisar, implementar e publicar este repositório com o protótipo de API REST.

## Descrição do projeto
O projeto consiste em construir a camada de serviço de um pseudo ecommerce de games mobile utilizando Java.
A API REST foi desenvolvida usando SpringBoot na versão JDK 11. A escolha do framework se deve a sua gama de ferramentas e usuários que desenvolvem com Spring facilitando o desenvolvimento de aplicações e consulta de documentações. 

## Tabela de conteúdos
=================
<!--ts-->
* [Sobre](#descrição-do-projeto)
* [Como Realizar Testes](#como-executar-os-testes)
* [Metodos](#métodos)
* [Tecnologias](#tecnologias)
<!--te-->
=================
## Como executar os testes
Para subir a API e executar os metodos basta executar o comando abaixo, na pasta do projeto:
```sh
  java -jar gamestore-api-0.0.1-SNAPSHOT.jar
  ```
  
  Será também necessário o uso do PostMan para fazer as requisições na API
  `localhost:8080`

# Métodos
Lista de funcionalidades disponíveis na API

## Get lista de Produtos

### Request

`GET /product`

### Response

+ Body
```
{
    "id": 1,
    "name": "nome do produto",
    "price": "preço",
    "score": "poupularidade",
    "image": "url"
}
```
## Adicionar um novo Produto

### Request
`POST /product/add`

### Response
+ Body
```
{
    "name":"Tetris",
    "score":10,
    "price":20.00,
    "image":"Url"
}
```
## Adicionar Ordens de Compra
### Request

`POST /order/add/{id}`
(id =  id do produto que se deseja adicionar a ordem de compra)
### Response

+ Body
```
   {
    "id": 1,
    "quantity": 1,
    "unitPrice": 20.00,
    "totalPrice": 20.00,
    "product": {
        "id": 1,
        "name": "Tetris",
        "price": 20.00,
        "score": 10,
        "image": "Url"
    }
}

```
## Get Lista de Ordens de Compra
### Request

`GET /order`

### Response

+ Body
```[
    {
        "id": 1,
        "quantity": 1,
        "unitPrice": 20.00,
        "totalPrice": 20.00,
        "product": {
            "id": 1,
            "name": "Tetris",
            "price": 20.00,
            "score": 10,
            "image": "url"
        }
    },
    {
        "id": 2,
        "quantity": 1,
        "unitPrice": 30.00,
        "totalPrice": 30.00,
        "product": {
            "id": 2,
            "name": "Sonic",
            "price": 30.00,
            "score": 11,
            "image": "Url"
        }
    }
]
```
## Deletar ordem de compra
### Request

`DELETE /order/remove/{id}`
(id = id da ordem de compra a ser removida)

## Adicionar Carrinho
### Request

`GET /cart/add`

## Mostrar Carrinho
### Request

`GET /cart`

### Response

+ Body
```
{
    "id": 1,
    "subTotal": 30.00,
    "shippingFee": 10,
    "totalValue": 40.00,
    "orderList": [
        {
            "id": 3,
            "quantity": 1,
            "unitPrice": 30.00,
            "totalPrice": 30.00,
            "product": {
                "id": 2,
                "name": "Sonic",
                "price": 30.00,
                "score": 11,
                "image": "Url"
            }
        }
    ]
}
```
## Tecnologias
- [Spring](https://spring.io/)
- [Postman](https://www.postman.com/)
- [H2database](https://www.h2database.com/html/main.html)
