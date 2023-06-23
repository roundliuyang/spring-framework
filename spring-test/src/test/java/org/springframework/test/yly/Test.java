package org.springframework.test.yly;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.yly.aware.MyApplicationAware;
import org.springframework.test.yly.beanpostprocessor.BeanPostProcessorTest;
import org.springframework.test.yly.init.InitMethodBeanTest;
import org.springframework.test.yly.init.InitializingBeanTest;

public class Test {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		// 测试 BeanPostProcessor 接口
		BeanPostProcessorTest beanPostProcessorTest = new BeanPostProcessorTest();
		factory.addBeanPostProcessor(beanPostProcessorTest);
		BeanPostProcessorTest beanPostProcessor = (BeanPostProcessorTest) factory.getBean("beanPostProcessorTest");
		beanPostProcessor.display();
		System.out.println("-------------------------------------------------------------------------------------");

		// 测试 Aware 接口
		MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		applicationAware.display();
		System.out.println("-------------------------------------------------------------------------------------");

		// 测试 InitializingBean 接口
		InitializingBeanTest initializingBeanTest = (InitializingBeanTest) factory.getBean("initializingBeanTest");
		System.out.println("name ：" + initializingBeanTest.getName());
		System.out.println("-------------------------------------------------------------------------------------");

		// 测试 init-method
		InitMethodBeanTest initMethodBeanTest = (InitMethodBeanTest) factory.getBean("initMethodBeanTest");
		System.out.println("name ：" + initMethodBeanTest.getName());

		// 测试 LifeCycleBean ,可以在 lifecyclebean 包中测试。
	}
}
