package com.salon.beauty.modelos.beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class CodificacionImpl implements Codificacion{

	private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        
            IntStream.range(0, hash.length)
                     .forEach(indice -> {
                        String hex = Integer.toHexString(0xff & hash[indice]); 
                        if(hex.length() == 1) hexString.append('0');
                        hexString.append(hex);
                     });
         
       return hexString.toString();
    }
	
	
	public String codificar(String texto) {
		MessageDigest codificacion;
		byte[] encodedhash = null;
		
		try {
			codificacion = MessageDigest.getInstance("SHA-512");
			encodedhash = codificacion.digest(texto.getBytes("UTF-8"));
			
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bytesToHex(encodedhash);
	}
	
	 
	
	
}
