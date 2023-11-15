package org.springframework.test.yly.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class DefineFactoryBean implements FactoryBean<IHelloService> {

	@Override
	public IHelloService getObject() {
		IHelloService helloService = (IHelloService) Proxy.newProxyInstance(IHelloService.class.getClassLoader(),
				new Class<?>[]{IHelloService.class}, (proxy, method, args) -> {
					System.out.println("begin execute");

					// 判断是否是 hashCode 方法(不写测试类报错，笑哭)
					if ("hashCode".equals(method.getName())) {
						// 如果是 hashCode 方法，返回 int 类型的结果
						return System.identityHashCode(proxy);
					} else {
						// 其他方法的逻辑
						return "Hello FactoryBean";
					}
				});
		return helloService;
	}

	@Override
	public Class<?> getObjectType() {
		return IHelloService.class;
	}
}