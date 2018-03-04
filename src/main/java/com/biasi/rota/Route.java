package com.biasi.rota;

import java.io.Serializable;
import java.security.MessageDigest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Route extends RouteBuilder implements Serializable {

	private static final long serialVersionUID = -8120193751949383285L;

	@Override
	public void configure() throws Exception {

		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.off)
			.dataFormatProperty("prettyPrint", "true");

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
			.process(exchange -> {
				//Settando os dados de retorno do .bean(MockCliente no endpoint de saida da rota
				exchange.getOut().setBody(exchange.getIn().getBody(String.class));
			})
		.end();
		
		//Rota para criptografia
		from("direct:cripto").routeId("Rota02")
			.process(exchange -> {
				//Recuperando dados de entrada via method=POST
				String body = exchange.getIn().getBody(String.class);
				
				//Criando objeto cryptografia
				Clientes cli = new Clientes();
				cli.setSenha(Criptograf.getEncrypt(body));
				
				//Montando o objeto JSON com o valor retornado do metodo getEncypt
				JSONObject jbon = new JSONObject(cli);
				
				exchange.getOut().setBody(jbon);
			})
		.end();
	}
}