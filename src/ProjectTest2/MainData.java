package ProjectTest2;

import java.util.ArrayList;
import java.util.List;

public class MainData { // 메인 데이터 객체

	private static List<Book> books = new ArrayList<Book>(); // 도서정보 리스트
	static BookController bookC = new BookController(); // 도서관리 컨트롤러
	// 테스트용 데이터를 위해 생성자로 입력함
	MainData(){
	}


	public static List<Book> getBooks() { // 도서정보 리스트 반환
		return books;
	}


	public static void addBook(Book book) { // 도서정보 리스트에 도서정보 추가
		books.add(book);
	}

}
