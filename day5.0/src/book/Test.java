package book;

public class Test {
	public static void main(String[] arges) {
		Author author = new Author("nyf","495970749@qq.com",'m');
		Book book = new Book("MacBookPro",author,99999999,99999999);
		
		System.out.println(book.getAuthor());
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		System.out.println(book.getQty());
		System.out.println(book.toString());
		
		book.setPrice(10000000000.0);
		book.setQty(100000000);
		System.out.println(book.toString());
		System.out.println("AuthorName = " + book.getAuthor().getName() + ", AthuorEmail = " + book.getAuthor().getEmail());

		System.out.println("AuthorName = " + book.getAuthorName() + ", AuthorEmail = " + book.getAuthorEmail());
	}

}
