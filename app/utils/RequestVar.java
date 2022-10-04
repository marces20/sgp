package utils;

import play.Logger;
import play.mvc.Controller;

public class RequestVar {	   
	   public static String get(String key) {	      
		  String valor = Controller.request().getQueryString(key);
	      return (valor == null)?"":valor;
	   }
	   
	   public static String getValueOrNull(String key) {	      
			  String valor = Controller.request().getQueryString(key);
		      return (valor == null)?null:valor;
	   }
	   
	   public static String[] getArray(String key) {	      
		   String[] valor = new String[0];
		   if(Controller.request().queryString().containsKey(key)){
			   valor = Controller.request().queryString().get(key);
		   }
		  return valor;
	   }
	}