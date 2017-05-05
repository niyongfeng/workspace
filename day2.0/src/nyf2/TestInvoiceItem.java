package nyf2;

public class TestInvoiceItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InvoiceItem item = new InvoiceItem("nyf","hangzhou",100,300.0);
		InvoiceItem item1 = new InvoiceItem();
		System.out.println(item.getID());	
		System.out.println(item.getDesc());
		System.out.println(item.getQty());
		System.out.println(item.getToal());
		System.out.println(item.toString());
		System.out.println("");
		
		System.out.println(item1.toString());
		item1.setQty(20);
		item1.setUnitPrice(6000);
		System.out.println(item1.toString());
		
		

	}

}
