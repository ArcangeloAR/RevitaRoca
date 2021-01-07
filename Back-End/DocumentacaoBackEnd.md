# Documentação Back-End

## Tema

 ### Model

| Atributo | Tipo |
|----------|------|
| id | [PK] Long |
| descricao | String |
| postagem | List < PostagemModel > |

A tabela possuirá os atributos **ID** referente ao código de cada tema e **descrição** onde iremos inserir a nomenclatura do tema: experiências, fazendas, restaurantes, hotéis, depoimentos, etc. Mais a lista de postagens com a definição de relacionamento @OneToMany.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /tema | Listar todos os temas existentes
| Get | /tema/{id} | Listar tema específico pelo ID
| Get | /tema/descricao/{descricao} | Listar um tema específico pela descrição
| Post | /tema | Inserir os dados
| Put | /tema | Editar algum dado específico
| Delete | /tema/{id} | Excluir algum dado pelo ID

A tabela possui os end-points básicos (get, post, put e delete) e mais dois métodos específicos, que buscam pelo id e pela descrição.

### Json

```json
{   
    "id": 1,
    "descricao": "Experiência",
    "postagem": [
        {
            "id": 1,
            "titulo": "Dicas de experiências em Turismo Rural (Cotia)",
            "texto": "Represento através desta, a cidade de Cotia como um todo...",
            "date": "2020-09-01T13:47:44.663+00:00"
        }
    ]
}
{
    "id": 2,
    "descricao": "Fazenda",
    "postagem": [
        {
            "id": 2,
            "titulo": "Proposta de acomodação - Fazenda Recanto Azul (Jequiá)",
            "texto": "Dispomos de 5 vagas para Turistas interessados pelo turismo...",
            "date": "2020-09-01T13:47:44.663+00:00"
        }
    ]
}
```

## Postagem

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----|
| id | [PK] Long |
| titulo | String | min = 2, max = 255
| texto | String | min = 2, max = 1000
| data | Date |
| tema | [FK] TemaModel
| usuario | [FK] TemaModel

A tabela possui os atributos **ID**, **título**, **texto** e **data** referente a cada postagem, mais as chaves estrangeiras **usuario**  e **tema** que fazem o link com a classe.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /postagem | Listar todas as postagens existentes
| Get | /postagem/{id} | Listar postagem específica pelo ID
| Get | /postagem/titulo/{titulo} | Listar uma postagem específica pelo Título
| Post | /postagem | Inserir dados
| Put | /postagem | Editar algum dado específico
| Delete | /postagem/{id} | Excluir algum dado pelo ID

A tabela possui os end-points básicos (get, post, put e delete) e mais dois métodos específicos, que buscam pelo id e pelo título.


### Json

```json
{
    "id": 1,
    "titulo": "Dicas de experiências em Turismo Rural (Cotia)",
    "texto": "Represento através desta, a cidade de Cotia como um todo...",
    "date": "2020-09-01T13:47:44.663+00:00",
    "usuario": 1,
    "tema": {
            "id": 1,
            "descricao": "Experiência"
    }
}

{
    "id": 2,
    "titulo": "Proposta de acomodação - Fazenda Recanto Azul (Jequiá)",
    "texto": "Dispomos de 5 vagas para Turistas interessados pelo turismo...",
    "date": "2020-09-01T13:36:18.538+00:00",
    "usuario": 1,
    "tema": {
        "id": 2,
        "descricao": "Fazenda"
    }
}
```

## Usuário

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----------------|
| id | [PK] Long 
| nome | String | min = 2, max = 100
| usuario | String | min = 5, max = 100
| senha | String |  min = 5, max = 100

A tabela possui os atributos **ID** referente ao código de cada usuário, **nome**, **usuario** e **senha**.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Post | /usuario/logar | Logar um usuário existente
| Post | /usuario/cadastrar | Cadastrar um novo usuário

Os caminhos para cadastrar e logar não precisam de autenticação por token.

### Model UserLogin (apenas para Login)
| Atributo | Tipo | 
|----------|------|
| nome | String |
| usuario | String | 
| senha | String |  
| token | String |

Criada a model ```UserLoginModel```, que devolve os dados do usuário logado com o token de autenticação.

```UsuarioRepository``` com busca específica para determinado usuário.

Criada a package ```Segurança``` com as classes ```BasicSecurityConfig```, ```UserDetailsImpl``` e ```UserDetailsServiceImpl```, aplicando as regras de negócio que foram determinadas na interface e restringindo a interação sem autenticação para os caminhos ```"/usuario/cadastrar"``` e ```"/usuario/logar"```.

Criada a package ```Service``` com a classe ```UsuarioService``` que encripta a senha escolhida pelo usuário e guarda no banco de dados.


### Json

#### Enviando dados para cadastrar

```json
{
    "nome": "Revita Roça",
    "usuario": "revita@roca.com",
    "senha": "123456"
}
```

#### Recebendo dados para logar

```json
{
    "nome": "Revita Roça",
    "usuario": "revita@roca.com",
    "senha": "123456",
    "token": "Basic ZmxhbWluZ28xMjM6ZmxhbWluZ28xMjM="
}
``` 

## Descrição Deploy Back-End
 
| Implementações | 
|----------|
| docker-compose.yml | 
| Dockerfile (na pasta de deploy) |
| Dockerfile (na pasta da api) |

Realizamos o deploy do back-end da nossa aplicação através do Docker, inserindo as informações referentes ao banco de dados e o uso da api em outra máquina.

