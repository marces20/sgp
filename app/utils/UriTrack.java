package utils;

import play.mvc.Controller;
import biz.source_code.base64Coder.Base64Coder;


public class UriTrack {	
	private static String key = "searchIndex";

	public static String getKey() {
		return key;
	}
	
	/**
	 * Si no existe la pista devuelve el controlador pasado
	 */
	public static String getOnNull(String url){
		String track = decode();
		return (track != null) ? track : url;
	}
	
	/**
	 * Genera el par clave/valor para agregar a la url
	 * @return String
	 */	
	public static String get(String separador){
		String c = code();
		return c != null ? separador + key + "=" + c : "";
	}	
	
	/**
	 * Devuelve el valor de la variable searchIndex
	 * @return String valor de la variable
	 */
	public static String code(){
		String value = getValue();
		return (value != null && value != "") ? value : null;
	}
	
	/**
	 * Obtiene el valor de la clave searchIndex enviada en método GET O POST
	 * @return String
	 */
	private static String getValue() {
		String metodo = Controller.request().method();
		if (metodo.equals("GET"))
			return Controller.request().getQueryString(key);
		
		String s = "";
		try {
			s = Controller.request().body().asFormUrlEncoded().get(key)[0];
		} catch (Exception e) {}
		
		return s;
	}
	
	/**
	 * Codifica la uri y devuelve el par clave/valor
	 * @return String
	 */
    public static String encode(){
    	return key+"="+encodeUri();
    } 
    
    public static String encodeUri() {
    	return Base64Coder.encodeString(Controller.request().uri());
    }
    
    
	/**
	 * Deuelve la uri decodificada
	 * @return String
	 */
    public static String decode(){  
    	String c = code();
    	return (c != null) ? new String(Base64Coder.decode(c)) : null;
    }
    
}
