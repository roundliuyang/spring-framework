package org.springframework.test.yly.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderAfterReturnAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void afterReturn(final Object returnValue) throws Throwable {
		System.out.println("value return was" + returnValue);
    }
}
