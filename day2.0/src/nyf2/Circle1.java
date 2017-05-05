package nyf2;

public class Circle1 {
	
	private double radius = 1.0;
	private String color = "red";
	
	public Circle1() {
		
	}
	
	public Circle1(double radius) {
		this.radius = radius;
	}
	
	public Circle1(double radius,String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "Radius=" + radius + ',' + "color=" + color;
	}
	public String getArea() {
		return "Area=" + Math.PI * radius *radius;
	}
	
	

}
