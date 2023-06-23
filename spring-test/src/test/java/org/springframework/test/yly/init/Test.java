package org.springframework.test.yly.init;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.yly.aware.MyApplicationAware;

public class Test {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		InitializingBeanTest test = (InitializingBeanTest) factory.getBean("initializingBeanTest");
		System.out.println("name ：" + test.getName());

		InitMethodBeanTest initMethodBeanTest = (InitMethodBeanTest) factory.getBean("initMethodBeanTest");
		System.out.println("name ：" + initMethodBeanTest.getName());
	}


}
