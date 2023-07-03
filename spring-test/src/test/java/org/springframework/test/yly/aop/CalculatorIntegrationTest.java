package org.springframework.test.yly.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorIntegrationTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("springAop-applicationContext.xml");

		SampleAdder sampleAdder = (SampleAdder) ac.getBean("sampleAdder");
		sampleAdder.add(12,12);
		System.out.println("-------------------------");
	}
}
