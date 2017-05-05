package nyf2;

public class InvoiceItem {
	private String id = "qyt";
	private String desc = "shijiazhuang";
	private int qty = 400;
	private double unitPrice = 2000;
	
	public InvoiceItem() {
		
	}
	
	public InvoiceItem(String id,String desc,int qty,double unitPrice) {
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	
	public String getID() {
		return id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getUitePrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getToal() {
		return unitPrice * qty;
	}
	
	public String toString() {
		return "InvoiceItem[id=" + id + ',' + "desc=" + desc + ',' + "qty=" + qty + ',' + "unitPrice=" + unitPrice + ']';
	}
	
	
	

}
