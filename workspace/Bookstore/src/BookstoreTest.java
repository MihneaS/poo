import java.util.Scanner;

public class BookstoreTest {
	public static void main (String[] args){
		Book book = new Book();
		book.title = "Sad Life";
		book.author = "Manum";
		book.publisher = "Lord";
		book.pageCount = 42;
		System.out.println("title " + book.title);
		System.out.println("autor " + book.author);
		System.out.println("publisher " + book.publisher);
		System.out.println("pgs " + book.pageCount);
		Scanner s = new Scanner(System.in);
		book.title = s.nextLine();
		book.author = s.nextLine();
		book.publisher = s.nextLine();
		book.pageCount = s.nextInt();
		while (book.pageCount == 0) {
			System.out.println("numarul de pagini nu paote fi 0. reintroduceti");
			book.pageCount = s.nextInt();
		}
		System.out.println("title " + book.title);
		System.out.println("autor " + book.author);
		System.out.println("publisher " + book.publisher);
		System.out.println("pgs " + book.pageCount);
	}
	
}