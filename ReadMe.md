Camel Project for Spring-Boot 
=========================================

##Introduction
	**This application is a sample for understand, how you can use the framework apache camel
	and run the application with Spring-boot, also in this sample you can see a method using the cryptographi. Follow bellow how can you use this API.
	
##To build this project use

    **Download the package and build with command:
    	-mvn clean install

To run the project you can execute the following Maven goal

    mvn spring-boot:run
    
##Routes for the application
    -For generate the swagger
    **GET - http://localhost:8080/rest/api-doc/swagger
    
    -For use the route with the Cryptographi
    **POST - http://localhost:8080/rest/rotas/criptarSenha
    
    -For use the route for get the clientes (Mock)
    **GET - http://localhost:8080/rest/rotas/cadastroClientes