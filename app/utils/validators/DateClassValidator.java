package utils.validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;

import play.libs.F.Tuple;
import utils.DateUtils;


public class DateClassValidator extends play.data.validation.Constraints.Validator<Object> implements ConstraintValidator<DateValidator, Object> {
	final static public String message = "Error fecha";

	public void initialize(DateClassValidator o) {
		System.out.println(o.getClass());
	}

	@Override
	public Tuple<String, Object[]> getErrorMessageKey() { return null; }

	@Override
	public boolean isValid(Object date) {
        if(date == null)
            return false;
        
        System.out.println(date.getClass());
        
        return true;
	}



	@Override
	public void initialize(DateValidator arg0) {}

}
