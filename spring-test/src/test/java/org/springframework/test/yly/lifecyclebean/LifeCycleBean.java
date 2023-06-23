package org.springframework.test.yly.lifecyclebean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, BeanPostProcessor,
		InitializingBean, DisposableBean {

	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		System.out.println("Bean [LifeCycleBean] 属性注入....");
		this.test = test;
	}

	public LifeCycleBean() { // 构造方法
		System.out.println("Bean [LifeCycleBean] 构造函数调用...");
	}

	public void display() {
		System.out.println("方法调用...");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Bean [LifeCycleBean] BeanFactoryAware 被调用...");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean [LifeCycleBean] BeanNameAware 被调用...");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("Bean [LifeCycleBean] BeanClassLoaderAware 被调用...");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] BeanPostProcessor postProcessBeforeInitialization 被调用...");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] BeanPostProcessor postProcessAfterInitialization 被调用...");
		return bean;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy 被调动...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean [LifeCycleBean] InitializingBean afterPropertiesSet 被调动...");
	}

	public void initMethod() {
		System.out.println("Bean [LifeCycleBean] init-method 被调用...");
	}

	public void destroyMethdo() {
		System.out.println("Bean [LifeCycleBean] destroy-method 被调用...");
	}

}
