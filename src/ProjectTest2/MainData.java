package ProjectTest2;

import java.util.ArrayList;
import java.util.List;

public class MainData { // ���� ������ ��ü

	private static List<Book> books = new ArrayList<Book>(); // �������� ����Ʈ
	static BookController bookC = new BookController(); // �������� ��Ʈ�ѷ�
	// �׽�Ʈ�� �����͸� ���� �����ڷ� �Է���
	MainData(){
	}


	public static List<Book> getBooks() { // �������� ����Ʈ ��ȯ
		return books;
	}


	public static void addBook(Book book) { // �������� ����Ʈ�� �������� �߰�
		books.add(book);
	}

}
