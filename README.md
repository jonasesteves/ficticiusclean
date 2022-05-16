# ficticiusclean
Projeto para avaliação do melhor veículo disponível para fazer entregas.

Autor: Jonas Esteves

E-mail: contato@jonasesteves.com

Este projeto foi desenvolvido utilizando a IDE Intellij Community.
O banco de dados utilizado é o H2 Database, com informações armazenadas em memória.

Para rodar o projeto, basta executá-lo normalmente na IDE.
Entretanto, também foram disponibilizados os arquivos JAR e WAR nos seguintes endereços:

JAR: https://drive.google.com/file/d/1HZ38uciXIPEy6Ll0aPkFtfAPWu4EWx5u/view?usp=sharing

WAR: https://drive.google.com/file/d/1izQt963AMS8hQpW0l9z809mxDKmxOBGu/view?usp=sharing

Para executar o arquivo JAR, certifique-se de ter o Java instalado em seu computador. 
Em seguida, abra uma janela do Prompt ou Shell, navegue até a pasta onde baixou o arquivo jar
e execute o seguinte comando:

java -jar ficticius-1.0-SNAPSHOT.jar

Após a inicialização do arquivo jar, será possível acessar a documentação do projeto através
do navegador utilizando o seguinte endereço:
http://localhost:8080/ficticius-clean/swagger-ui.html

No endereço acima, além da documentação, também é possível executar chamadas à API. Também foi 
disponibilizado neste repositório um arquivo json "Ficticius Clean.postman_collection.json" 
contendo todas as chamadas à API via Postman.

O projeto possui 3 veículos pré-cadastrados para os testes, mas também é possível consultar um veículo, cadastrar novos veículos, atualizar um veículo existente, consultar veículos por características e apagar um veículo cadastrado. Para consultar uma previsão de gastos na API, deve-se fazer um POST no endereço http://localhost:8080/ficticius-clean/api/previsao-gastos passando um body com os seguintes parâmetros: 

precoCombustivel

kmCidade

kmRodovia
