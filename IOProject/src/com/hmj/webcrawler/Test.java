package com.hmj.webcrawler;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		Test2 test2=new Test2(list);
		test2.add();
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}
