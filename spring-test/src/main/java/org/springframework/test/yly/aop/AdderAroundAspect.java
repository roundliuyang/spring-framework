package org.springframework.test.yly.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AdderAroundAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object aroundAdvice(final ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Arguments passed to method are: " + Arrays.toString(joinPoint.getArgs()));
        final Object result = joinPoint.proceed();
		System.out.println("Result from method is: " + result);
        return result;
    }
}
