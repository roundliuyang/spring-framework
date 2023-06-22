package org.springframework.test.yly.aware;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
	/**
	 * 从该运行结果可以看出，这里只执行了三个 Aware 接口的 set 方法，原因就是通过 #getBean(...) 方法调用时，
	 * 在激活 Aware 接口时只检测了 BeanNameAware、BeanClassLoaderAware、BeanFactoryAware 三个 Aware 接口。
	 */
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		applicationAware.display();
	}

	/**
	 * 如果将测试方法调整为下面,则发现执行了四个 Aware 接口的 set 方法
	 */
	public static void main2(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		MyApplicationAware applicationAware = (MyApplicationAware) applicationContext.getBean("myApplicationAware");
		applicationAware.display();
	}
}
