import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) {
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�ڿ���̨�����ַ���'^'Ϊ�˳���");
		char c = 0;
		do {
			try {
				c=(char) bReader.read();
				System.out.println(c);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (c!='^');
	}
}