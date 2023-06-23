package org.springframework.test.yly.lifecyclebean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.yly.init.InitMethodBeanTest;
import org.springframework.test.yly.init.InitializingBeanTest;

public class Test {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		// BeanFactory 容器一定要调用该方法进行 BeanPostProcessor 注册
		factory.addBeanPostProcessor(new LifeCycleBean());

		LifeCycleBean lifeCycleBean = (LifeCycleBean) factory.getBean("lifeCycle");
		lifeCycleBean.display();

		System.out.println("方法调用完成，容器开始关闭....");
		// 关闭容器
		factory.destroySingletons();
	}


}
