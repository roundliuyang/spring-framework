package org.springframework.test.yly.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderBeforeAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void beforeAdvice() throws Throwable {
		System.out.println("I would be executed just before method starts");
    }
}
