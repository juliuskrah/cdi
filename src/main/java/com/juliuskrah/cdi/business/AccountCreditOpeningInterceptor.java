package com.juliuskrah.cdi.business;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.juliuskrah.cdi.business.dto.CustomerBean;

/**
 * Interceptor class that intercepts annotated methods and initializes customer
 * accounts with 10 USD
 * 
 * @author Julius Krah
 * @see AccountOpeningInterceptor
 */
@Priority(1)
@Interceptor
@AccountOpeningInterceptor
public class AccountCreditOpeningInterceptor {

	@AroundInvoke
	public Object initializeAccount(InvocationContext ctx) throws Exception {
		CustomerBean customer = (CustomerBean) ctx.getParameters()[0];
		if (customer.getBalance() == 0) customer.setBalance(10);
		ctx.setParameters(new Object[] { customer });
		return ctx.proceed();
	}
}
