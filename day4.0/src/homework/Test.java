package homework;

public class Test {
	public static void main(String[] arges) {
		Cylinder cylinder1 = new Cylinder();
		Cylinder cylinder2 = new Cylinder(2.0,2.0);
		Cylinder cylinder3 = new Cylinder(3.0,3.0,"blue");
		System.out.println("cylinder-area:" + cylinder1.getArea());
		System.out.println("cylinder-color:" + cylinder1.getColor());
		System.out.println("cyclinder-heigth:" + cylinder1.getHeigth());
		System.out.println("cylinder1-volume:" + cylinder1.getVolume());
		System.out.println("cyclinder1:" + cylinder1.toString());
		System.out.println("cylinder2-volume:" + cylinder2.getVolume());
		System.out.println("cylinder2:" + cylinder2.toString());
		System.out.println("cylinder3-volume:" + cylinder3.getVolume());
		System.out.println("cylinder3:" + cylinder3.toString());
		
		Customer customer = new Customer(110,"nyf",50);
		Invoice invoice = new Invoice(111111,customer,500);
		System.out.println(invoice.getCustomerName());
		System.out.println(invoice.getAmount());
		System.out.println(invoice.getAmountAfterDiscount());
		
		
	}

}
