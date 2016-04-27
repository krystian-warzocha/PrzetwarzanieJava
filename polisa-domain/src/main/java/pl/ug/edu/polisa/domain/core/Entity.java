package pl.ug.edu.polisa.domain.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // also used in runtime
@Target(ElementType.TYPE) // used on class
public @interface Entity {
	/**
	 * Nazwa tabeli
	 * 
	 * @return
	 */
	String tableName() default "";
}
