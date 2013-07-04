package com.gimslab.entityComp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new Main().test1();
		//new Main().test2();
		new Main().test3();
	}

	private void test3() {
		List<User> list1 = new MyArrayList<User>();
		List<User> list2 = new MyArrayList<User>();
		list1.add(new User("가나다", "", 10));
		list2.add(new User("가나다라", "", 11));
		print("list1.hashcode() = " + list1.hashCode());
		print("list2.hashcode() = " + list2.hashCode());
		print("HashCodeBuilder.ref...(list1) = " + HashCodeBuilder.reflectionHashCode(list1, false));
		print("HashCodeBuilder.ref...(list2) = " + HashCodeBuilder.reflectionHashCode(list2, false));
	}

	public class MyArrayList<T> extends ArrayList<T> {

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this, false);
		}

	}

	private void test2() {
		List<User> list1 = new ArrayList<User>();
		List<User> list2 = new ArrayList<User>();
		list1.add(new User("가나다", null, 10));
		list2.add(new User("가나다라", null, 11));
		print("list1.hashcode() = " + list1.hashCode());
		print("list2.hashcode() = " + list2.hashCode());
		print("HashCodeBuilder.ref...(list1) = " + HashCodeBuilder.reflectionHashCode(list1, false));
		print("HashCodeBuilder.ref...(list2) = " + HashCodeBuilder.reflectionHashCode(list2, false));
	}

	private void test1() {
		User user1 = new User("홍길동", null, 33);
		//User user2 = new User("이순신", 44);
		User user2 = new User("홍길동", null, 33);
		print(user1.getName() + ", hashcode = " + user1.hashCode());
		print(user2.getName() + ", hashcode = " + user2.hashCode());
		print("user1 == user2 : " + (user1 == user2));
		print("user1.equals(user2) = " + user1.equals(user2));
	}

	private void print(String string) {
		System.out.println(string);
	}

	private void print(boolean b) {
		System.out.println(b);
	}

	private void print(User user) {
		System.out.println(user);
	}

}
