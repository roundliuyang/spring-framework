package org.springframework.test.yly.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		System.out.println(Test.class.getClassLoader() == Laozong.class.getClassLoader());
		Mishu mishu = new Mishu();
		//第一个参数:反射时使用的类加载器
		//第二个参数:Proxy需要实现什么接口
		//第三个参数:通过接口对象调用方法时,需要调用哪个类的invoke方法
		Gongneng gongneng = (Gongneng) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Gongneng.class}, mishu);

		//Laozong laozong = (Laozong) gongneng;
		gongneng.chifan();
	}
}
