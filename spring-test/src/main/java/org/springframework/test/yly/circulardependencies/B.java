package org.springframework.test.yly.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	private A a;

	@Autowired
	public void setA(A a) {
		this.a = a;
	}

	public void doSomethingElse() {
		System.out.println("B is doing something else.");
		a.doSomething();
	}
}