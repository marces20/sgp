package utils.validation;

import play.data.Form;
import java.util.*;

/**
 * Validates for a null or empty field
 */
public class RequiredValidation extends Validation {

    public RequiredValidation(String field, String errorMessage)  {
        super(field, errorMessage);
    }

    public boolean isValid(Form form)  {
    	if(form.data().containsKey(field)){
        	String value = form.data().get(field).toString();
            if(value == null || value.trim().equals(""))  {
                addFieldError();
                return false;
            }
    	}
        return true;
    }
}
