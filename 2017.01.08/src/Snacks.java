
public class Snacks extends Food{
	
	private String variety;
	private int discount;

	public Snacks() {
		
	}
	
	public Snacks(String variety, int discount) {
		this.variety = variety;
		this.discount = discount;
	}
	
	public Snacks(String variety,int discount, double price, double amount) {
		super(price, amount);
		this.variety = variety;
		this.discount = discount;
	}
	
	public String getVariety() {
		return variety;
	}
	
	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public double getTotalPrice() {
		return this.price * this.amount * discount / 100;
	}
	
	public String toString() {
		return super.toString() + "\n" + "Snacks [ variety = " + variety + " ]\n" + "TotalPrice = " + getTotalPrice();
	}
}
