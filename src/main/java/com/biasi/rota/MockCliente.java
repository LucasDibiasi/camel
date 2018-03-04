package com.biasi.rota;

import org.apache.camel.Exchange;
import org.json.JSONObject;

public class MockCliente {

	public static void cadastros(Exchange exchange) {
		//Senha para ser criptografada com metodo MD5
		String senha = "23141231232";
		
		//Criando estancia de clientes para gerar um cadastro
		Clientes cli = new Clientes();
		
		cli.setNome("Lucas Di Biasi");
		cli.setIdade("24");
		cli.setEmail("lucas.email@email.com");

		//Chamando o metodo para criptografar a senha
		cli.setSenha(Criptograf.getEncrypt(senha));
		
		//Montando o objeto Clientes em JSON
		JSONObject jsonObj = new JSONObject(cli);
		exchange.getIn().setBody(jsonObj);
	}
}