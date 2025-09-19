## API Rest - Análise de Clientes com IA
>>DESCRIÇÃO

 * Esta API REST foi desenvolvida em Java 21 com Spring Boot 3.x e permite analisar e classificar clientes utilizando Inteligência Artificial (OpenAI).

 
* Ela oferece endpoints para:


➤ Buscar todos os clientes cadastrados.

➤ Classificar clientes individualmente com base em seus dados.

>> TECNOLOGIAS UTILIZADAS

➤   Java 21

➤ Spring Boot 3.x

➤ Spring WebFlux

➤ WebClient

➤ OpenAI API

➤ DB: PostGreSQL

>> PRÉ REQUISITOS

### Antes de rodar o projeto, você precisa ter:

➤ Java 21 instalado

➤ Maven instalado

➤ Uma chave de API do OpenAI válida

➤ Créditos disponives na sua conta OPENAI, (OBS: vai receber o erro 429 caso não tenha saldo válido)

>>CONFIGURAÇÃO

### Clone o repositório:

➤ git clone https://github.com/Deuslleyw/apiRestAnaliseDeClienteComIA.git

➤ Configure a chave da OpenAI no application.properties:

➤ spring.ai.openai.api-key=YOUR_OPENAI_API_KEY

➤ Substitua YOUR_OPENAI_API_KEY pela sua chave pessoal da OpenAI (sk-...).

>> EXECUTANDO   

 * Para rodar a aplicação localmente:

➤  ./mvnw spring-boot:run


A API estará disponível em: http://localhost:8080

>> ENDPOINTS 

1️⃣ Buscar todos os clientes:

 * URL: /api/v1/clientes

 * Método: GET

Descrição: Retorna a lista de todos os clientes cadastrados.



>>Postman:

Abra o Postman.

Crie uma nova requisição GET.

Coloque a URL: http://localhost:8080/api/v1/clientes

Clique em Send para receber a lista de clientes.

 * Ex:
````json
{
  "nome" : "DEUSLEYDEV",
  "classificacao" : "Ouro"
}
````
2️⃣ Classificar um cliente

 * URL: http://localhost:8080/api/v1/clientes/classificar

Método: POST

Descrição: Recebe os dados de um cliente e retorna a classificação baseada em IA.

Exemplo de corpo da requisição (JSON):
````json
{
"nome": "DEUSLEYDEV",
"idade": 34,
"compras": 10,
"ticketMedio": 380.50
}
````
----
>>>DeusleyDev
