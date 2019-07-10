package com.hmj.webcrawler;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
/**
 * 
 * @author Hmj
 * @Date 2019-07-10
 * 	通过一个URL获取文本文件并计算大小
 */
public class ReadFileFromURL {
	public static void main(String[] args) {
		System.out.println("input url:");
		String urlString=new Scanner(System.in).nextLine();
		//定义URL对象,并且打开文本的InputStream,在通过inputstream对象参数创建scanner对象，依次显示文本各行数据并且累加文本字符，最后显示文件大小
		try {
			URL url=new URL(urlString);
			InputStream inputStream=url.openStream();
			Scanner scanner=new Scanner(inputStream);
			long count=0;
			String line=null;
			while(scanner.hasNext()) {
				System.out.println(line=scanner.nextLine());
				count+=line.length();
			}
			System.out.println("文件大小："+count+"character.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
