import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamDemo {
	public static void main(String[] args) {//�ı����������ʾ��������һ���ı�д���ֽڣ��ڴ���һ���ļ������������ȡ������̨
		Byte[] bytes= {97,98,99};//Byte�������ͣ�һ���ֽ��ɰ�λ��������ɣ���Χ-128~127
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
