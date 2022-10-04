package utils;

import java.io.IOException;

import biz.source_code.base64Coder.Base64Coder;


public class EncondeUriBase64 {
	
	public static String encode(String uri){
		String encodedBytes = Base64Coder.encodeString(uri);
		return encodedBytes;
	}
	
	public static String dencode(String encodedBytes) throws IOException{
		return new String(Base64Coder.decode(encodedBytes));
	}
	/*
	public static String encode(String cadena){
		String ret = "";
		try{
			ret = new String(Base64Coder.decode(cadena));
		}catch(Exception e){
			
		}
		
		if(ret.isEmpty()){
			try{
				ret = new String(Base64Coder.encodeString(cadena));
			}catch(Exception e){
				
			}
		}
		
		return ret;
	}*/
	
}
