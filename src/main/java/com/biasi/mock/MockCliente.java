package com.biasi.mock;
/**
 * @data 05/03/2018
 * @author lbiasi
 *
 */
import org.apache.camel.Exchange;

import com.biasi.cripto.Criptografia;
import com.biasi.model.Clientes;

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
		cli.setSenha(Criptografia.getEncrypt(senha));
		
		//Settando o valor do objeto Clientes no corpo (body) da rota ou seja, retornando o valor para o endpoint Exchange
		exchange.getIn().setBody(cli);
	}
}