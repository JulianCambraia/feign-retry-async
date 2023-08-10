# feign-retry-async

### Comunicação assíncrona com Feign
* Como fazer chamadas REST assíncronas com Feign e com retry e agendamento
* https://programadev.com.br/spring-feign-assincrono/
Uso da API 
*
## Postmon
The Mongo Postman API

O que é?

Uma API para consultar CEP e encomendas de maneira fácil, rápida e gratuita.
Como utilizar?

A versão atual da API é a 1.x.x

Como é uma API baseada em REST, basta fazer a seguinte chamada para consultar um CEP:
https://api.postmon.com.br/v1/cep/*cep_a_consultar*

Onde *cep_a_consultar* é o número do CEP que deseja consultar as informações. O resultado é retornado em formato JSON

Para obter o retorno em formato XML, basta acrescentar ?format=xml no final da requisição.

Para uma encomenda:
https://api.postmon.com.br/v1/rastreio/*provider*/*codigo_rastreio*

Onde *provider* é a empresa de logistica responsável pela entrega e *codigo_rastreio* é o código de rastreio do produto que deseja informações. O resultado é retornado em formato JSON

Para obter o retorno em formato XML, basta acrescentar ?format=xml no final da requisição.

Providers aceitos:
