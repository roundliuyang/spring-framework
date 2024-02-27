package org.springframework.test.yly.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAopTest.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.test();
    }
}
