package utils.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = {DateClassValidator.class})
@Target( { METHOD, FIELD, ANNOTATION_TYPE, TYPE})
@Retention(RUNTIME)
public @interface DateValidator {
 String message() default "{error.invalid.date}";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}