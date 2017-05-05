
public abstract class Food {
	
	private final boolean EAT = true;
	protected double price = 5.0;
	protected double amount = 2.0;
	
	public Food() {
		
	}
	
	public Food(double price, double amount) {
		this.price = price;
		this.amount = amount;
	}
	
	public double getPrice(double price) {
		return price;
	}
	
	public double getAmount(double amount) {
		return amount;
	}
	
	public abstract double getTotalPrice();
	
	public String toString() {
		return "This food can eat? " + EAT;
	}
	

}
