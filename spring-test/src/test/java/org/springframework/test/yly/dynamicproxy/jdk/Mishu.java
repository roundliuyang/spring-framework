package org.springframework.test.yly.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mishu implements InvocationHandler {
	//要代理的真实对象
	private Laozong laozong = new Laozong();

	/**
	 * 该方法负责集中处理动态代理类上的所有方法调用。
	 * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
	 *
	 * @param proxy  代理类实例
	 * @param method 被调用的方法对象
	 * @param args   调用参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("预约时间");
		Object result = method.invoke(laozong, args);
		System.out.println("记录访客信息");
		return result;
	}

}