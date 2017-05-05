package homework;

public class Cylinder extends Circle{
	
	private double heigth = 1.0;
	
	public Cylinder() {
		
	}
	
	public Cylinder(double radius) {
		this.setRadius(radius);
	}

	public Cylinder(double radius, double heigth) {
		this.setRadius(radius);
		this.heigth = heigth;
	}
	
	public Cylinder(double radius, double heigth, String color) {
		super.setRadius(radius);
		this.heigth = heigth;
		this.setColor(color);
	}
	
	public double getHeigth() {
		return heigth;
	}
	
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	
	public double getVolume() {
		return getArea() * heigth;
	}
}
