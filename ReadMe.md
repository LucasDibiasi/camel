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
 
Then you'll see in log the Spring starting, looks like bellow:

   .   ____          _            __ _ _
  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \ 
 ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \ 
  \\/  ___)| |_)| | | | | || (_| |  ) ) ) ) 
   '  |____| .__|_| |_|_| |_\__, | / / / / 
  =========|_|==============|___/=/_/_/_/ 
 
 :: Spring Boot ::       (v1.5.10.RELEASE)

2018-03-05 15:25:45.519  INFO 22054 --- [           main] com.biasi.route.ApplicationRun           : Starting ApplicationRun on lucasbiasi.redhat with PID 22054 (/home/lbiasi/workspace/runingcamel-springboot/target/classes started by lbiasi in /home/lbiasi/workspace/runingcamel-springboot)
2018-03-05 15:25:45.522  INFO 22054 --- [           main] com.biasi.route.ApplicationRun           : No active profile set, falling back to default profiles: default
2018-03-05 15:25:45.601  INFO 22054 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6e54d66f: startup date [Mon Mar 05 15:25:45 BRT 2018]; root of context hierarchy
2018-03-05 15:25:47.171  INFO 22054 --- [           main] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
2018-03-05 15:25:47.260  INFO 22054 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.apache.camel.spring.boot.CamelAutoConfiguration' of type [org.apache.camel.spring.boot.CamelAutoConfiguration$$EnhancerBySpringCGLIB$$d0bfbc87] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-03-05 15:25:47.685  INFO 22054 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2018-03-05 15:25:47.700  INFO 22054 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2018-03-05 15:25:47.701  INFO 22054 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.27
2018-03-05 15:25:47.782  INFO 22054 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2018-03-05 15:25:47.782  INFO 22054 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2187 ms.


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