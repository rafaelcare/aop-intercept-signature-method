package com.rafael.cr.aop.annotatios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface InterceptorBusiness.
 *
 * @author carpinteyror
 * @version 1.0
 * @since 18/04/2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface InterceptorBusiness {

}
