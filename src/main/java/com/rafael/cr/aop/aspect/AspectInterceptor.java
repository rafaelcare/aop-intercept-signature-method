package com.rafael.cr.aop.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class AspectInterceptor.
 *
 * @author carpinteyror
 * @version 1.0
 * @since 18/04/2018
 */
@Aspect
@Component
public class AspectInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(AspectInterceptor.class);

	/**
	 * My method.
	 * 
	 * - This method intercept (mathod1) from class Controller
	 * - Take the MethodSignature for get contract from arguments that receives (@RequestHeader)
	 * @author carpinteyror
	 * @param joinPoint the join point
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("execution(* com.rafael.cr.aop.controller.Controller.method1(..))")
	public Object myMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("Executing around {}", joinPoint.getSignature().getName());
		long start = System.currentTimeMillis();

		Object[] args = joinPoint.getArgs();
		for (Object object : args) System.out.println(object);
		
		//Execute method call
		Object proceed = joinPoint.proceed();
		
		//Get contract signature from the request
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		//Get all definition from method to invoked
		Method method = signature.getMethod();

		boolean withHeader = false;
		
		//Get all annotations from arguments that receives per argument
		for(Annotation[] annotations : method.getParameterAnnotations()){
		  for(Annotation annotation : annotations){
			  if(annotation instanceof RequestHeader) {
				  System.out.println(((RequestHeader) annotation).value());
				  withHeader = true;			  }
		  }
		  if(withHeader) break;
		}
		
		System.out.println(new ObjectMapper().writeValueAsString(args));
		long executionTime = System.currentTimeMillis() - start;

		LOGGER.info("{} executed in {} Ms",joinPoint.getSignature(), executionTime);
		return proceed;
	}

	/**
	 * My method 1.
	 * 
	 * -This method intercept All methods from all clases into package ....controller.* 
	 * and match with @InterceptorBusiness
	 * - Take of method the signature for get contract from arguments that receives (@RequestHeader)
	 * @author carpinteyror
	 * @param joinPoint the join point
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("execution(* com.rafael.cr.aop.controller.*.*(..)) && @annotation(com.rafael.cr.aop.annotatios.InterceptorBusiness)")
//	@Around("@annotation(com.rafael.cr.aop.annotatios.InterceptorBusiness)")
	public Object myMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("Executing around {}", joinPoint.getSignature().getName());
		long start = System.currentTimeMillis();

		Object[] args = joinPoint.getArgs();
		for (Object object : args) System.out.println(object);
		
		//Execute method call
		Object proceed = joinPoint.proceed();
		
		System.out.println(new ObjectMapper().writeValueAsString(args));
		long executionTime = System.currentTimeMillis() - start;
		
		LOGGER.info("{} executed in {} Ms",joinPoint.getSignature(), executionTime);
		return proceed;
	}

}