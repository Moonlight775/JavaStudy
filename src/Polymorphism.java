public class Polymorphism{
	public static void main(String[] args) {
		A a = new A(); //�ڽ��� �ν��Ͻ� �ִ�
		A aa = new B(); //B�ν��Ͻ��� A�ν��Ͻ� �ִ�.
		//a = (B)a;//a�� A �ν��Ͻ� �ִ�. B�� ����. ->�������
		//B b = new A(); //A�ν��Ͻ��� B�ν��Ͻ��� ����.
		B bb = new B(); //�ڽ��� �ν��Ͻ� �ִ�.
		a = aa; //���� Ÿ���� �ּ� ����
		a = (B)aa; //a�� A�ν��Ͻ��� �ʿ�, (B)aa�� B�ν��Ͻ� -> A�� �ִ� -> �ڵ� �� ��ȯ
		a = bb;//B�ν��Ͻ��� A�ν��Ͻ� �ִ�.
		//bb = a; //B�ν��Ͻ��� ����.
		//bb = aa;//B�ν��Ͻ��� ����.
		bb = (B)aa;//B�ν��Ͻ� �ִ�.
	}
}

class A{
	A() {
		System.out.println("A������");
	}
	void A1() {System.out.println("A1()");}
	void A2() {System.out.println("A2()");}
}

class B extends A{
	B(){
		System.out.println("B������");
	}
	void B1() {System.out.println("B1()");}
	void B2() {System.out.println("B2()");}
}
