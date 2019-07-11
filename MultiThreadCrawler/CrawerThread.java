package com.hmj.webcrawler;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrawerThread implements Runnable{

	List<String> unTraversedList=null;
	List<String> traversedList=null;
	Integer count=null;
	String name;
	Thread thread;
	public  CrawerThread(String name,ArrayTool tool) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.count=tool.getCount();
		thread=new Thread(this, name);
		System.out.println(tool.getUnTraversedList());
		this.traversedList=tool.getTraversedList();
		this.unTraversedList=tool.getUnTraversedList();
		System.out.println("creating a Thread......");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+" is running!");
		System.out.println(unTraversedList);
		System.out.println(traversedList);
		while (!unTraversedList.isEmpty() && traversedList.size()<=10000) {
			String judgingUrl=unTraversedList.remove(0);
			if(!traversedList.contains(judgingUrl)) {
				System.out.println(name+" is crawing page"+traversedList.size()+":"+judgingUrl);
				traversedList.add(judgingUrl);
				ArrayList<String> urList=getUrls(judgingUrl);
				for (String string : urList) {
					unTraversedList.add(string);
				}
			}
		}
		System.out.println(name+" is over!!!");
	}
	public void start() {
		thread.start();
	}
	/**
	 * 
	 * @param judgingUrl
	 * @return
	 * 	获取某个页面下的所有链接
	 */
	public ArrayList<String> getUrls(String judgingUrl){
		ArrayList<String> urList=new ArrayList<>();
		try {
			URL url=new URL(judgingUrl);
			InputStream inputStream=url.openStream();
			Scanner scanner=new Scanner(inputStream);
			int currentIndex=0;
			while (scanner.hasNext()) {
				//对读取到的每一行匹配超链接
				String line=scanner.nextLine();
				currentIndex=line.indexOf("http:",currentIndex);
				while(currentIndex>0) {
					int endIndex=line.indexOf("\"",currentIndex);
					if(endIndex>0) {
						urList.add(line.substring(currentIndex,endIndex));
						currentIndex=line.indexOf("http:",endIndex);
					}else {
						currentIndex=-1;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urList;
	}
}
