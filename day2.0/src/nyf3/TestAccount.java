package nyf3;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account acc = new Account("hangzhou","nyf");
		Account acc1 = new Account("shaoxing","qyt",88);
		System.out.println(acc.credit(66));
		System.out.println(acc.debit(66));
		System.out.println(acc.TransferTo(acc1, 66));
		System.out.println(acc.toString());
		
		System.out.println(acc1.credit(66));
		System.out.println(acc1.debit(66));
		System.out.println(acc1.TransferTo(acc, 66));
		System.out.println(acc1.toString());
		
		
		
		

	}

}
