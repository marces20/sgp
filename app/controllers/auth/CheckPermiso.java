package controllers.auth;

import play.mvc.With;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@With(CheckPermisoAction.class)
@Inherited
@Target({ElementType.METHOD, 
	 ElementType.CONSTRUCTOR, 
	 ElementType.TYPE, 
	 ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermiso {
	String key() default "";
}