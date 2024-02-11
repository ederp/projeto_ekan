# projeto_ekan
Aplicação utilizando Java e Spring Boot que fornece uma API REST para manter o cadastro de beneficiários de um plano de saúde. Ela contém os seguintes endpoints:  
- Cadastra um beneficiário junto com seus documentos;
- Lista todos os beneficiários cadastrados;
- Lista todos os documentos de um beneficiário a partir de seu id;
- Atualiza os dados cadastrais de um beneficiário;
- Remove um beneficiário.

A pasta src/main/java contém as classes onde os endpoints foram desenvolvidos. Algumas das principais são:  
- [Beneficiario](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/model/Beneficiario.java) e [Documento](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/model/Documento.java), na pasta io.swagger.model, contendo a modelagem básica
- [BeneficiarioService](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/service/BeneficiarioService.java), na pasta io.swagger.service, que faz o crud usando JPA
- [BeneficiariosApi](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/api/BeneficiariosApi.java) e [BeneficiariosApiController](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/api/BeneficiariosApiController.java), na pasta io.swagger.api que fazem as requisições REST da aplicação
- [BeneficiarioControllerTest](https://github.com/ederp/projeto_ekan/blob/main/src/test/java/io/swagger/test/BeneficiarioControllerTest.java), na pasta src/test/java. Esta classe testa algumas das respostas dos endpoints desenvolvidos.

Além de Java e Spring Boot, as tecnologias e frameworks utilizados neste projeto foram os seguintes:  
MySQL para o banco de dados, JPA e Hibernate para a persistência dos dados, JUnit para a elaboração de testes, Swagger para documentar a API e Docker para gerar uma imagem do banco de dados.

Para rodar a aplicação, é necessário seguir estes passos:  
- Baixar o projeto e descompactar usando a IDE de preferência
- Caso o Docker esteja instalado na máquina, abrir a pasta do projeto e iniciar o container Docker usando o comando `docker-compose up -d`
- Ao executar pela primeira vez o projeto é interessante descomentar as últimas linhas do [application.properties](https://github.com/ederp/projeto_ekan/blob/main/src/main/resources/application.properties) para gerar as tabelas do banco
- Executar o projeto através da classe [Swagger2SpringBoot](https://github.com/ederp/projeto_ekan/blob/main/src/main/java/io/swagger/Swagger2SpringBoot.java)
- Verificar se o aplicativo está em execução através de uma ferramenta como Postman ou Insomnia

Ao rodar a aplicação, será possível verificar a documentação do Swagger através do endereço [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
