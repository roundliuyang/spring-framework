package org.springframework.test.yly.aop.jdk;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LoggingAspect implements MethodBeforeAdvice, AfterReturningAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Before method: " + method.getName());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After method: " + method.getName());
	}
}