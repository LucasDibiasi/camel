Camel Project for Spring-Boot 
=========================================

Introduction

	This application is a sample for understand, how you can use the framework Apache Camel
	
	and start the application with Spring-Boot, also in this sample you can see a method using the cryptographi.
	
	Follow the steps bellow for know how you can use this API.
	
To build this project use

    Download the package and build with command:
    	-mvn clean install

To run the project you can execute the following Maven goal

    	-mvn spring-boot:run
 
Routes for the application

    -For generate the swagger
    METHOD: GET 
    - http://localhost:8080/rest/api-doc/swagger
    
    -For use the route with the Cryptographi
    METHOD: POST 
    - http://localhost:8080/rest/rotas/criptarSenha
    
    -For use the route for get the clientes (Mock)
    METHOD: GET 
    - http://localhost:8080/rest/rotas/cadastroClientes