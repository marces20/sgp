package utils.validators;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import play.libs.F.Tuple;


public class MoneyCustomValidator extends play.data.validation.Constraints.Validator<Object> implements ConstraintValidator<MoneyCustomValidatorInterface, Object> {
	final static public String message = "Error moneda";
	


	@Override
	public Tuple<String, Object[]> getErrorMessageKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(Object object) {
        if(object == null)
            return false;
        
		Pattern pattern = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
		Matcher m = pattern.matcher(String.valueOf(object));
		System.out.println("invalido " + m.matches());
		return m.matches();
	}

	@Override
	public void initialize(MoneyCustomValidatorInterface arg0) {
		// TODO Auto-generated method stub
		
	}

}
