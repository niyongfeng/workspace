
public class Fruits extends Food{
	
	private String color;
	private String taste;
	private String name;
	
	public Fruits() {
		
	}
	
	public Fruits(String color, String taste, String name) {
		this.color = color;
		this.taste = taste;
		this.name = name;
	} 
	
	public Fruits(String color, String taste,String name, double price, double amount) {
		super(price, amount);
		this.color = color;
		this.price = price;
		this.name = name;
	}
	
	public double getTotalPrice() {
		return this.price * this.amount;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getTaste() {
		return taste;
	}
	
	public String getName() {
		return name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return super.toString() + "\n" +"Fruits [ name = " + name + ", color = " + color + 
				", taste = " + taste + " ]" + "\n" + "TotalPrice = " + getTotalPrice(); 
	}

}
