package com.biasi.cripto;
/**
 * @data 05/03/2018
 * @author lbiasi
 *
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.camel.Exchange;

import com.biasi.model.Clientes;

public class Criptografia {

	private static MessageDigest md = null;
	
	public static void context(Exchange exchange) {
		//Recuperando dados de entrada via method=POST
		String body = exchange.getIn().getBody(String.class);
		
		//Criando objeto cryptografia
		Clientes cli = new Clientes();
		cli.setSenha(Criptografia.getEncrypt(body));
		
		exchange.getOut().setBody(cli);
	}
	
	public static String getEncrypt(String param) {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		
		if (md != null) {
			return new String(hexCodes(md.digest(param.getBytes())));
		}
		return null;
	}

	private static char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;

		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}
}