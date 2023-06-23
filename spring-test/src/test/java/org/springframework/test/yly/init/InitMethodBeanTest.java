package org.springframework.test.yly.init;


public class InitMethodBeanTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOtherName() {
		System.out.println("InitializingBeanTest setOtherName...");
		this.name = "chenssy 3 号";
	}
}
