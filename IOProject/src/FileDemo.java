import java.io.File;
public class FileDemo {
	public static void main(String[] args) {
		File file=new File("test");//file��mkdir����ֻ�ܴ���һ���ļ��У���mkdirs�����ܴ����༶�ļ��С�
		System.out.println(file.mkdirs());
		//file.list()��ʾ�ļ��е������ļ��л����ļ���
		//file��isDirectory()�жϵ�ǰ�ļ��������ļ��л����ļ�
		//file.delete()����ɾ���ļ�
	}
}
