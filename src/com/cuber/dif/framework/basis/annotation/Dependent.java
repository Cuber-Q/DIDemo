package com.cuber.dif.framework.basis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * When a class needs another class instance, 
 * use Dependent annotation.
 * @author Cuber_Q
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dependent {
	String value() default"";
}
