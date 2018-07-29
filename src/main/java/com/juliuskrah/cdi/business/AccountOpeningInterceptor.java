package com.juliuskrah.cdi.business;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Interceptor binding which when applied to a Type or Method allows the method
 * to be interceptored. In the case of a Type, all methods in the class are
 * eligible for intercepting.
 * 
 * @author Julius Krah
 * @see AccountCreditOpeningInterceptor
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface AccountOpeningInterceptor {

}
