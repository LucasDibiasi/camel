package com.biasi.teste;

import java.io.Serializable;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder implements Serializable {

	private static final long serialVersionUID = -8120193751949383285L;

	@Override
	public void configure() throws Exception {

		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.off)
			.dataFormatProperty("prettyPrint", "true");

		rest("/test")
			.post("/clientes")
			.id("clientes")
			.consumes("application/json")
			.toD("direct:clientes");

		from("direct:clientes").routeId("Rota01")
			.process(new Processor() {

				@Override
				public void process(Exchange exchange) throws Exception {
					JSONObject jsonObj = new JSONObject(exchange.getIn().getBody(String.class));
					System.out.println("tESTANDOOOOOOOOOOOOOOOOOOOOOOOO: " + jsonObj);
					exchange.getOut().setBody(jsonObj);
					// exchange.getOut().setHeaders(exchange.getIn().getHeaders());
				}
			}).end();
	}
}
