package study.hmj.binaryio;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class copyFileFromUrl {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://39.108.152.57:8080/privateHmjBlog/blog-list.jsp");
			InputStream inputStream=url.openStream();
			int size=inputStream.available();
			OutputStream outputStream=new FileOutputStream("urljsp.txt");
			for (int i = 0; i < size; i++) {
				outputStream.write(inputStream.read());
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
