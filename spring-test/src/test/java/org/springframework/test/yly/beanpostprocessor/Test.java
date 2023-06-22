package org.springframework.test.yly.beanpostprocessor;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.yly.aware.MyApplicationAware;

public class Test {
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		BeanPostProcessorTest beanPostProcessorTest = new BeanPostProcessorTest();
		factory.addBeanPostProcessor(beanPostProcessorTest);

		BeanPostProcessorTest test = (BeanPostProcessorTest) factory.getBean("beanPostProcessorTest");
		MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		test.display();
	}
}
