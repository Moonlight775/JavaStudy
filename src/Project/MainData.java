package Project;

import java.util.ArrayList;
import java.util.List;

public class MainData { // ���� ������ ��ü
	private static List<Customer> customers = new ArrayList<Customer>(); // ������ ����Ʈ
	private static List<Book> books = new ArrayList<Book>(); // �������� ����Ʈ
	private static List<CheckOut> checkOutInfo = new ArrayList<CheckOut>(); // �뿩���� ����Ʈ
	static CustomerController customerC = new CustomerController(); // ������ ��Ʈ�ѷ�
	static BookController bookC = new BookController(); // �������� ��Ʈ�ѷ�
	static CheckOutController checkOutCtrl = new CheckOutController(); // �뿩���� ��Ʈ�ѷ�
	static CheckInController checkInC = new CheckInController(); // �ݳ����� ��Ʈ�ѷ�
	
	// �׽�Ʈ�� �����͸� ���� �����ڷ� �Է���
	MainData(){
		//Customer(String id, String irum, String address)
		Customer customer1 = new Customer("01011110000","������","������1");
		Customer customer2 = new Customer("01022220000","�󸶹�","�󸶹�2");
		Customer customer3 = new Customer("01033330000","�����","�����2");
		customers.add(customer1); customers.add(customer2); customers.add(customer3);
		
		//Book(String name, String author,String br,String date)
		Book book1 = new Book("���� 1","����1","�з�1","�뿩�Ⱓ1");
		Book book2 = new Book("���� 2","����1","�з�1","�뿩�Ⱓ1");
		Book book3 = new Book("����","����2","�з�2","�뿩�Ⱓ2");
		Book book4 = new Book("�ٴ�","����3","�з�2","�뿩�Ⱓ2");
		books.add(book1); books.add(book2); books.add(book3); books.add(book4);
		
		//(String bookNo, String title,String irum,String phone,String coDate,String ciDate)
		CheckOut checkOut1 = new CheckOut (book1.getBookNo(), book1.getTitle(), customer1.getIrum(), customer1.getPhoneNum(),
				"2021-03-23", "2021-03-26" ); // ��¥ �����ϴ� �޼ҵ� �����ؾ���
		CheckOut checkOut2 = new CheckOut (book2.getBookNo(), book2.getTitle(), customer2.getIrum(), customer2.getPhoneNum(),
				"2021-03-23", "2021-03-26" );
		CheckOut checkOut3 = new CheckOut (book3.getBookNo(), book3.getTitle(), customer3.getIrum(), customer3.getPhoneNum(),
				"2021-03-23", "2021-03-29" );
		checkOutInfo.add(checkOut1); checkOutInfo.add(checkOut2); checkOutInfo.add(checkOut3);
	}


	public static List<Customer> getCustomers() { // ������ ����Ʈ ��ȯ
		return customers;
	}


	public static void addCustomer(Customer customer) { // ������ ����Ʈ�� ������ �߰�
		customers.add(customer);
	}


	public static List<Book> getBooks() { // �������� ����Ʈ ��ȯ
		return books;
	}


	public static void addBook(Book book) { // �������� ����Ʈ�� �������� �߰�
		books.add(book);
	}


	public static List<CheckOut> getCheckOutInfo() { // �뿩���� ����Ʈ ��ȯ
		return checkOutInfo;
	}


	public static void addCheckOutInfo(CheckOut checkOut) { // �뿩���� ����Ʈ�� �뿩���� �߰�
		checkOutInfo.add(checkOut);
	}
}
