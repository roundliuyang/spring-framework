package org.springframework.test.yly.aop.jdk;

public class UserServiceImpl implements UserService {
	@Override
	public void saveUser(String username) {
		System.out.println("Saving user: " + username);
	}
}