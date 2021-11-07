package ch07;

public class EX7_7 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();	// 실제 인스턴스가 무엇인지가 중요. NullPointerException 발생가능성 생김.
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;	// car = (car)fe;에서 형변환이 생략됨
	//	car.water();	// car type은 water()를 사용할 수 없다.
		fe2 = (FireEngine)car;	// 자손타입 <- 조상타입. 형변환 생략 불가
		fe2.water();
		//
	}
}

class Car {
	String color;
	int door;
	
	void drive() { // 운전하는 기능
		System.out.println("drive, Brrr~");
	}
	
	void stop() { // 멈추는 기능
		System.out.println("stop!!");
	}
}

class FireEngine extends Car {	// 소방차
	void water() {	// 물을 뿌리는 기능 
		System.out.println("water!!");
	}
}