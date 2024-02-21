package org.springframework.test.yly.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	private B b;

	@Autowired
	public void setA(B b) {
		this.b = b;
	}

	public void doSomething() {
		System.out.println("A is doing something.");
		b.doSomethingElse();
	}
}