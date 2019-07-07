package consoleProgram;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantFee {
	public static void main(String[] args) {
		System.out.println("------------------------------");
		ArrayList<Food> foods=new ArrayList<>();
		System.out.println("操作提示：");
		System.out.println("purchase Porridge please press p");
		System.out.println("purchase rice please press r");
		System.out.println("------------------------------");
		System.out.println("请选择购买的早餐和份量");
		Scanner scanner=new Scanner(System.in);
		int over=0;
		do {
			System.out.println("请选择早餐：");
			String breakfast=scanner.nextLine();
			System.out.println("请确定份量：");
			int num=scanner.nextInt();
			scanner.nextLine();
			Food food = null;
			if(breakfast.equalsIgnoreCase("r")) {
				food=new Rice(num);
			}else if(breakfast.equals("p")){
				food=new Porridge(num);
			}else {
				System.out.println("请阅读操作提示购买早餐！！！");
			}
			over++;
			foods.add(food);
		} while (over<2);
		System.out.println("------------------------------");
		System.out.println("您的账单"+countTotalPrice(foods));		
	}
	public static float countTotalPrice(ArrayList<Food> foods) {//计算购买食物的总价格
		float totalFee=0;
		for (Food food : foods) {
			System.out.println("早餐："+food.getName()+" 单价："+food.getPrice()+" 份数："+food.getNum());
			totalFee+=food.getPrice()*food.getNum();
		}
		return totalFee;
	}
}