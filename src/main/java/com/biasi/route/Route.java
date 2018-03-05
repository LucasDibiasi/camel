package com.biasi.route;
/**
 * @data 05/03/2018
 * @author lbiasi
 *
 */
import java.io.Serializable;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.biasi.cripto.Criptografia;
import com.biasi.mock.MockCliente;
import com.biasi.model.Clientes;

@Component
public class Route extends RouteBuilder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void configure() throws Exception {

		//Configuração da rota Rest
		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.off)
			.dataFormatProperty("prettyPrint", "true")
			
			//Aplicando a rota /api-doc/* para gerar Swagger da API
			.apiContextPath("/api-doc/swagger")
			.apiProperty("api.title", "Componentes API").apiProperty("api.version", "1.0.0")
			.apiProperty("cors", "true");
		
		
		//Definindo os paths das rotas e seus respectivos metodos
		rest("/rotas")
			.get("/cadastroClientes")
				.id("clientes")
				.consumes("application/json")
				.toD("direct:clientes")
			.post("/criptarSenha")
				.id("cripto")
				.consumes("application/json")
				.toD("direct:cripto");

		//Rota cadastro de clientes
		from("direct:clientes").routeId("Rota01")
			//Dados mockados de um cliente
			.bean(MockCliente.class, "cadastros")
			//serializando o objeto retornado do Mock em um JSON
			.marshal().json(JsonLibrary.Jackson, Clientes.class)
		.end();
		
		//Rota para criptografia
		from("direct:cripto").routeId("Rota02")
			.bean(Criptografia.class, "context")
			//Montando o objeto JSON com o valor retornado do metodo getEncypt
			.marshal().json(JsonLibrary.Jackson, Clientes.class)
		.end();
	}
}