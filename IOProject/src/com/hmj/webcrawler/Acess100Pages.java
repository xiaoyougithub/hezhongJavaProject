package com.hmj.webcrawler;
/**
 * 
 * @author Hmj
 * @Date 2019-7-10
 *	从指定的url按照广度搜索策略访问100个网页，并且把网页链接显示出来
 */
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Acess100Pages {
	/*	程序过程：控制台输入url,初始化未遍历列表，循环判断未遍历列表是否不为空且已遍历列表的值未达到了100，如果这样就从未遍历
	 *	 列表中取出一个对象，如果该对象未被访问，就将其放入到已遍历列表中，显示对象，获取对象页面的所有链接
	 */
	public static void main(String[] args) {
		System.out.println("input start url:");
		Scanner scanner=new Scanner(System.in);
		String startUrl=scanner.nextLine();
		ArrayTool tool=new ArrayTool();
		tool.unTraversedList=getUrls(startUrl);
		CrawerThread[] threads=new CrawerThread[32];
		long startTime=System.currentTimeMillis();
		for(int i=0;i<32;i++) {
			threads[i]=new CrawerThread("thread "+i, tool);
			System.out.println(tool.unTraversedList.get(i));
			threads[i].start();
		}
		long endTime=System.currentTimeMillis();
		int seconds=(int) ((endTime-startTime)/1000);
		int second=(int) seconds%60;
		int minute=(int) seconds/60;
		int hour=(int)seconds/3600;
		System.out.println("用时："+hour+"时"+minute+"分"+second+"秒");
		System.out.println("crawed over!!!");
	}	
	/**
	 * 
	 * @param judgingUrl
	 * @return
	 * 	获取某个页面下的所有链接
	 */
	public static ArrayList<String> getUrls(String judgingUrl){
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
