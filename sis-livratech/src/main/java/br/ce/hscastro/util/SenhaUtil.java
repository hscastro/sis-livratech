package br.ce.hscastro.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SenhaUtil {

	
	public static String md5(String senha) {
		try {
			MessageDigest msg = MessageDigest.getInstance("MD5");
			BigInteger code = new BigInteger(1, msg.digest(senha.getBytes()));
			return code.toString(16);
			
		} catch (Exception e) {
			return "";
		}
	}

}
