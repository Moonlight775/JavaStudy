package Project;

import java.util.ArrayList;
import java.util.List;

public class MainData { // 메인 데이터 객체
	private static List<Customer> customers = new ArrayList<Customer>(); // 고객정보 리스트
	private static List<Book> books = new ArrayList<Book>(); // 도서정보 리스트
	private static List<CheckOut> checkOutInfo = new ArrayList<CheckOut>(); // 대여정보 리스트
	static CustomerController customerC = new CustomerController(); // 고객관리 컨트롤러
	static BookController bookC = new BookController(); // 도서관리 컨트롤러
	static CheckOutController checkOutCtrl = new CheckOutController(); // 대여관리 컨트롤러
	static CheckInController checkInC = new CheckInController(); // 반납관리 컨트롤러
	
	// 테스트용 데이터를 위해 생성자로 입력함
	MainData(){
		//Customer(String id, String irum, String address)
		Customer customer1 = new Customer("01011110000","가나다","가나다1");
		Customer customer2 = new Customer("01022220000","라마바","라마바2");
		Customer customer3 = new Customer("01033330000","사아자","사아자2");
		customers.add(customer1); customers.add(customer2); customers.add(customer3);
		
		//Book(String name, String author,String br,String date)
		Book book1 = new Book("가가 1","저자1","분류1","대여기간1");
		Book book2 = new Book("가가 2","저자1","분류1","대여기간1");
		Book book3 = new Book("나나","저자2","분류2","대여기간2");
		Book book4 = new Book("다다","저자3","분류2","대여기간2");
		books.add(book1); books.add(book2); books.add(book3); books.add(book4);
		
		//(String bookNo, String title,String irum,String phone,String coDate,String ciDate)
		CheckOut checkOut1 = new CheckOut (book1.getBookNo(), book1.getTitle(), customer1.getIrum(), customer1.getPhoneNum(),
				"2021-03-23", "2021-03-26" ); // 날짜 설정하는 메소드 구현해야함
		CheckOut checkOut2 = new CheckOut (book2.getBookNo(), book2.getTitle(), customer2.getIrum(), customer2.getPhoneNum(),
				"2021-03-23", "2021-03-26" );
		CheckOut checkOut3 = new CheckOut (book3.getBookNo(), book3.getTitle(), customer3.getIrum(), customer3.getPhoneNum(),
				"2021-03-23", "2021-03-29" );
		checkOutInfo.add(checkOut1); checkOutInfo.add(checkOut2); checkOutInfo.add(checkOut3);
	}


	public static List<Customer> getCustomers() { // 고객정보 리스트 반환
		return customers;
	}


	public static void addCustomer(Customer customer) { // 고객정보 리스트에 고객정보 추가
		customers.add(customer);
	}


	public static List<Book> getBooks() { // 도서정보 리스트 반환
		return books;
	}


	public static void addBook(Book book) { // 도서정보 리스트에 도서정보 추가
		books.add(book);
	}


	public static List<CheckOut> getCheckOutInfo() { // 대여정보 리스트 반환
		return checkOutInfo;
	}


	public static void addCheckOutInfo(CheckOut checkOut) { // 대여정보 리스트에 대여정보 추가
		checkOutInfo.add(checkOut);
	}
}
