import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);//控制台的输入输出
		System.out.println("input:");
		do {
			String string=scanner.nextLine();
			System.out.println(string);
			System.out.println("input:");
		} while (scanner.hasNext());
	}
}
