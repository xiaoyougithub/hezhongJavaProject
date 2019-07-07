package consoleProgram;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantFee {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		ArrayList<Food> foods=new ArrayList<>();
		System.out.println("������ʾ��");
		System.out.println("purchase Porridge please press p");
		System.out.println("purchase rice please press r");
		System.out.println("------------------------------");
		System.out.println("��ѡ�������ͺͷ���");
		Scanner scanner=new Scanner(System.in);
		int over=0;
		do {
			System.out.println("��ѡ����ͣ�");
			String breakfast=scanner.nextLine();
			System.out.println("��ȷ��������");
			int num=scanner.nextInt();
			scanner.nextLine();
			Food food = null;
			if(breakfast.equalsIgnoreCase("r")) {
				food=new Rice(num);
			}else if(breakfast.equals("p")){
				food=new Porridge(num);
			}else {
				System.out.println("���Ķ�������ʾ������ͣ�����");
			}
			over++;
			foods.add(food);
		} while (over<2);
		System.out.println("------------------------------");
		System.out.println("�����˵�"+countTotalPrice(foods));		
	}
	public static float countTotalPrice(ArrayList<Food> foods) {//���㹺��ʳ����ܼ۸�
		float totalFee=0;
		for (Food food : foods) {
			System.out.println("��ͣ�"+food.getName()+" ���ۣ�"+food.getPrice()+" ������"+food.getNum());
			totalFee+=food.getPrice()*food.getNum();
		}
		return totalFee;
	}
}