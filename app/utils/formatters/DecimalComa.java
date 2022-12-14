package utils.formatters;

import play.data.Form;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Form.Display(name = "constraint.money")
public @interface DecimalComa {
  String value();
}