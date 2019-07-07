import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamDemo {
	public static void main(String[] args) {//文本输入输出流示例：创建一个文本写入字节，在创建一个文件输入流对象读取到控制台
		Byte[] bytes= {97,98,99};//Byte数据类型，一个字节由八位二进制组成，范围-128~127
		try {
			OutputStream fileOutputStream=new FileOutputStream("test1.txt");
			for(int i=0;i<bytes.length;i++) {
				fileOutputStream.write(bytes[i]);
			}
			fileOutputStream.close();
			InputStream inputStream=new FileInputStream("test1.txt");
			int size=inputStream.available();
			for(int i=0;i<size;i++) {
				System.out.println(inputStream.read()+" ");
			}
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
