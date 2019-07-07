package javaBefore;
public class Practice {
	public static void main(String[] args) {
		Point point=new Point();
		System.out.println(point.x);
		Point point1=new Point(3,4);
		Point point2=new Point(0, 2);
		double length;
		length=Math.sqrt(Math.pow(point1.x-point2.x, 2)+Math.pow(point1.y-point2.y,2));
		System.out.println(length);
		
		
		Circle circle=new Circle(5, 5, 5);
		System.out.println(circle.withinCircle(point2));
		
	}
}

class Point{
	
	public double x;
	public double y;
	public Point(){
		
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}

class Circle{
	public double x;
	public double y;
	public double radius;
	public Circle(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public boolean withinCircle(Point point){
		if(Math.sqrt(Math.pow(point.x-x, 2)+Math.pow(point.y-y,2))<radius)
			return true;
		else {
			return false;
		}
	
	}
	
}
