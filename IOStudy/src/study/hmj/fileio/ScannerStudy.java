package study.hmj.fileio;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author Admin
 *	@Date 2019-07-10
 *	手动创建文本文件，通过scanner对象读取数据；再通过printWriter对象向文件写入数据
 */
public class ScannerStudy {
	public static void main(String[] args) {
//		File file=new File("D://eclipse201809/eclipse-workspace201906/IOStudy/src/study/hmj/fileio/source。txt");//绝对路径创建文件对象
		File file=new File("source.txt");//相对路径创建文件对象，注意的是相对路径是JVM启动的路径，即项目根路径
		try {
			Scanner scanner=new Scanner(file);
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());//***eclipse统一编码下scanner不能从文本对象读取中文而GBK编码下却可以
			}
			scanner.close();
			PrintWriter writer=new PrintWriter(file);
			//writer通过file对象创建，write方法覆写原来文件，append方法追加到原来文本的后面，写入\n为换行
			writer.write("hello");//
			writer.append("ytt:hi~mj");
			writer.append("\n");
			writer.append("hmj:hello,ytt");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());//获取文件对象的绝对路径
	}
}
