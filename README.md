![dotnet core](https://github.com/osvaldsoza/ApiFuncional/assets/9426175/d88bdc8e-7cc1-4bd3-bb81-d6e80e7a0c74)

# Resumo do projeto
A empresa XPTO Systems precisa construir um sistema web para leitura e manutenção de uma lista de states que hoje está em um arquivo CSV.
Como a empresa está antenada com as novas tecnologias ela precisa de um sistema web, pois os usuários irão acessar os dados do sistema via smartphone.
A empresa contratou uma agência e a agência decidiu separar o trabalho em duas partes: uma equipe irá fazer a interface e equipe a integração com a base de dados.
Para a integração com a base de dados foi sugerida a criação de uma API rest para fazer o controle das states cadastradas. Todos o tráfego de dados do serviço deve ser feito no formato JSON.
Foi definido que a API terá serviços para atender os seguintes requisitos:
1. Ler o arquivo CSV das states para a base de dados;
2. Retornar somente as states que são capitais ordenadas por nome;
3. Retornar o nome do state com a maior e menor quantidade de states e a
quantidade de states;
4. Retornar a quantidade de states por state;
5. Obter os dados da state informando o id do IBGE;
6. Retornar o nome das states baseado em um state selecionado;
7. Permitir adicionar uma nova Cidade;
8. Permitir deletar uma state;
9. Permitir selecionar uma coluna (do CSV) e através dela entrar com uma string para
filtrar. retornar assim todos os objetos que contenham tal string;
10. Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens
iguais;
11. Retornar a quantidade de registros total;
12. Dentre todas as states, obter as duas states mais distantes uma da outra com base
na localização (distância em KM em linha reta);

## ✔️ Tecnologias utilizadas
* ``SpringBoot``
* ``Spring Data JPA``
* ``Postgres``
* ``Model Mapper``
* ``Docker Compose``
* ``JDK 8``

# 🛠️ Rodar o projeto
1. Execute o comnado: ``docker compose up -d`` para levantar o banco de dados. Com isso, a base de dados será iniciada já com alguns registros na tabela ``pet``.
1. Execute o comnado: ``./mvnw clean install`` para buildar o projeto.
1. Execute o comnado: ``./mvnw spring-boot:run`` para ``"subir"`` o projeto.
1. Sugestão de IDE's ``Spring Tool Suite | Eclipse | VS Code``. Na implementação foi utilizado o ``Intellij``.

# ✔️ Documentação
``http://localhost:8080/swagger-ui.html#/``

# ✔️ Postman
``./Builder.postman_collection.json``

# Autor

| [<img loading="lazy" src="https://github.com/osvaldsoza/ApiFuncional/assets/9426175/cba31f2b-3b5d-4a6d-ab6d-39583efe752b" width=115><br><sub>Osvaldo de Souza Ferreira</sub>](https://github.com/camilafernanda) 
| :---:

![Badge Finalizado](http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=GREEN&style=for-the-badge)


