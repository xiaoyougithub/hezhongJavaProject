import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);//����̨���������
		System.out.println("input:");
		do {
			String string=scanner.nextLine();
			System.out.println(string);
			System.out.println("input:");
		} while (scanner.hasNext());
	}
}
