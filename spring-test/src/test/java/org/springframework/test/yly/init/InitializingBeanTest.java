package org.springframework.test.yly.init;


import org.springframework.beans.factory.InitializingBean;

public class InitializingBeanTest implements InitializingBean {

	private String name;

	/**
	 * 具有侵入性，因为 Spring 容器与业务类直接强耦合了
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBeanTest initializing...");
		this.name = "chenssy 2 号";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
