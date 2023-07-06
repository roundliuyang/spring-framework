package org.springframework.test.yly.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * CGLIB 代理创建者
 */
public class CglibProxyCreator implements ProxyCreator {

	private Object target;

	private MethodInterceptor methodInterceptor;

	public CglibProxyCreator(Object target, MethodInterceptor methodInterceptor) {
		assert (target != null && methodInterceptor != null);
		this.target = target;
		this.methodInterceptor = methodInterceptor;
	}


	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		// 设置代理类的父类
		enhancer.setSuperclass(target.getClass());
		// 设置代理逻辑
		enhancer.setCallback(methodInterceptor);
		// 创建代理对象
		return enhancer.create();
	}
}
