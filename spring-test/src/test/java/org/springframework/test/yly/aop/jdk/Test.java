package org.springframework.test.yly.aop.jdk;

import org.springframework.aop.framework.ProxyFactory;

public class Test {
	public static void main(String[] args) {
		UserService target = new UserServiceImpl();

		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.addAdvice(new LoggingAspect());

		UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.saveUser("John");
	}
}
