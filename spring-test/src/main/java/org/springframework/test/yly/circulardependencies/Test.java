package org.springframework.test.yly.circulardependencies;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		A bean = ctx.getBean(A.class);
		System.out.println(bean);
		ctx.start();
    }
}
