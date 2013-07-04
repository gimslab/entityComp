package com.gimslab.entityComp;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().test1();
	}

	private void test1() {
		User user1 = new User("홍길동", 33);
		User user2 = new User("이순신", 44);
		print(user1);
		print(user2);
		print(user1 == user2);
	}

	private void print(boolean b) {
		System.out.println(b);
	}

	private void print(User user) {
		System.out.println(user);
	}

}
