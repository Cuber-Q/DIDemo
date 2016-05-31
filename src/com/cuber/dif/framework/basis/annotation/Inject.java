package com.cuber.dif.framework.basis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Declare that this class could be auto injected into
 * gloable bean factory, so that user will get the instance
 * of this class without using new operation.
 * @author Cuber_Q
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inject {
}
