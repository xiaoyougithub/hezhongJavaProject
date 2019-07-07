import java.io.File;
public class FileDemo {
	public static void main(String[] args) {
		File file=new File("test");//file的mkdir（）只能创建一个文件夹，而mkdirs（）能创建多级文件夹。
		System.out.println(file.mkdirs());
		//file.list()显示文件夹的所有文件夹或者文件。
		//file。isDirectory()判断当前文件对象是文件夹还是文件
		//file.delete()可以删除文件
	}
}
