package org.springframework.test.yly.dynamicproxy.cglib;

public class CglibProxyCreatorTest {


	public static void main(String[] args) {
		ProxyCreator proxyCreator = new CglibProxyCreator(new Tank59(), new TankRemanufacture());
		Tank59 tank59 = (Tank59) proxyCreator.getProxy();

		System.out.println("proxy class = " + tank59.getClass() + "\n");
		tank59.run();
		System.out.println();
		System.out.print("射击测试：");
		tank59.shoot();
	}
}