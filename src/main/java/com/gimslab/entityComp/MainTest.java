package com.gimslab.entityComp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class MainTest {

	@Test
	public void test1() {
		int i = 3;
		Integer ii = new Integer(3);
		assertThat(i, equalTo(ii));
	}

	@Test
	public void test2() {
		String s1 = "abcd";
		String s2 = "abcd";
		System.out.println(s1.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s1 == s2);
		System.out.println(s1 == "abcd");
		System.out.println(s1.equals(s2));
		assertThat(s1, equalTo(s2));
	}

	@Test
	public void test3() {
		User user1 = new User("가나,다", ",", 10);
		User user2 = new User("가나,다,", "", 10);
		System.out.println(ToStringBuilder.reflectionToString(user1, ToStringStyle.SHORT_PREFIX_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(user2, ToStringStyle.SHORT_PREFIX_STYLE));
		System.out.println(HashCodeBuilder.reflectionHashCode(user1, false));
		System.out.println(HashCodeBuilder.reflectionHashCode(user2, false));
	}

	@Test
	public void test4() {
		List<String> list = new ArrayList<String>();
		list.add("c");
		list.add("a");
		list.add("b");
		assertThat(list, hasItem("b"));
		assertThat(list, hasItems("a", "b", "c"));
	}

	@Test
	public void test4_1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(33);
		list.add(44);
		assertThat(list, hasItem(11));
	}

	@Test
	public void test5() {
		List<User> list = new ArrayList<User>();
		list.add(new User("가나다", "abc", 10));
		list.add(new User("가나다", "abc", 20));

		List<Integer> hashList = makeHashList(list);
		int hash1 = HashCodeBuilder.reflectionHashCode(new User("가나다", "abc", 10), false);
		int hash2 = HashCodeBuilder.reflectionHashCode(new User("가나다", "abc", 20), false);
		int hash3 = HashCodeBuilder.reflectionHashCode(new User("가나다", "abx", 20), false);
		List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(hash1);
		expectedList.add(hash2);

		assertThat(hashList, hasItem(hash2));
		assertThat(hashList, hasItems(hash1, hash2));
	}

	private List<Integer> makeHashList(List<User> list) {
		List<Integer> resultList = new ArrayList<Integer>();
		for(User user:list){
			resultList.add(HashCodeBuilder.reflectionHashCode(user, false));
		}
		return resultList;
	}
}
