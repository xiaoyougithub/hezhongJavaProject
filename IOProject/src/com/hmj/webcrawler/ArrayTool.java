package com.hmj.webcrawler;

import java.util.ArrayList;

public class ArrayTool {
	
	ArrayList<String> unTraversedList=null;
	ArrayList<String> traversedList=new ArrayList<>();
	Integer count=new Integer(0);
	public ArrayList<String> getUnTraversedList() {
		return unTraversedList;
	}
	public void setUnTraversedList(ArrayList<String> unTraversedList) {
		this.unTraversedList = unTraversedList;
	}
	public ArrayList<String> getTraversedList() {
		return traversedList;
	}
	public void setTraversedList(ArrayList<String> traversedList) {
		this.traversedList = traversedList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
