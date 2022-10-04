package utils.validation;

import play.data.Form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Verifica que la fecha es válida
 */
public class DateValidation extends Validation {

	private String format = "dd/MM/yyyy";
	
    public DateValidation(String field, String errorMessage)  {
        super(field, errorMessage);
    }

    public boolean isValid(Form form)  {
    	if(form.data().containsKey(field)){
        	String date = form.field(field).value();
        	
            if(!date.trim().isEmpty())  {
            	 DateFormat df = new SimpleDateFormat(format);
                 df.setLenient(false);
                 try {
					df.parse(date);
				} catch (ParseException e) {
	            	addFieldError();
	                return false;
				}
                return true;
            }
            return true;
    	}
        return true;
    }
}
