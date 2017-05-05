package homework;

public class Invoice {
	
	private int id;
	private Customer customer;
	private double amount = 1000;
	
	

	
	public Invoice(int id, Customer customer, double amount) {
		this.id = id;
		this.amount = amount;
		this.customer = customer;
		
	}
	
	public int getID() {
		return id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getAmount() {
		return "" +amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getCustomerName() {
		return customer.getName();
	}
	
	public double getAmountAfterDiscount() {
		return amount * this.customer.getDiscount() / 100;
	}
	
	
	
	

}
