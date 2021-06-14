public class Polymorphism{
	public static void main(String[] args) {
		A a = new A(); //자신의 인스턴스 있다
		A aa = new B(); //B인스턴스에 A인스턴스 있다.
		//a = (B)a;//a는 A 인스턴스 있다. B가 없다. ->실행오류
		//B b = new A(); //A인스턴스에 B인스턴스가 없다.
		B bb = new B(); //자신의 인스턴스 있다.
		a = aa; //같은 타입의 주소 대입
		a = (B)aa; //a는 A인스턴스만 필요, (B)aa는 B인스턴스 -> A가 있다 -> 자동 형 변환
		a = bb;//B인스턴스에 A인스턴스 있다.
		//bb = a; //B인스턴스가 없다.
		//bb = aa;//B인스턴스가 없다.
		bb = (B)aa;//B인스턴스 있다.
	}
}

class A{
	A() {
		System.out.println("A생성자");
	}
	void A1() {System.out.println("A1()");}
	void A2() {System.out.println("A2()");}
}

class B extends A{
	B(){
		System.out.println("B생성자");
	}
	void B1() {System.out.println("B1()");}
	void B2() {System.out.println("B2()");}
}
