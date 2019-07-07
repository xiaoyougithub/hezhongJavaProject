import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyDemo {
	public static void main(String[] args) {
		File img=new java.io.File("E://Pictures//Camera Roll/sf.jpg");
		try {
			InputStream inputStream=new FileInputStream(img);
			int size=inputStream.available();
			OutputStream outputStream=new FileOutputStream("sf.jpg");
			for (int i = 0; i < size; i++) {
				outputStream.write(inputStream.read());
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
