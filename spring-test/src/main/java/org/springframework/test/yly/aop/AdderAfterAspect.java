package org.springframework.test.yly.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderAfterAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void afterAdvice() throws Throwable {
		System.out.println("I'm done calling the method");
    }
}
