class Tv {
	//Tv�� �Ӽ�(�������)
	String color;
	boolean power;
	int channel;
	
	//Tv�� ���(�޼���)
	void power() {power = !power;}
	void channelUp() { ++channel;}
	void channelDown() {--channel;}
	
}

class TvTest3 {
	public static void main(String[] args) {
		Tv t1 = new Tv(); //Tv t1; t1 = new Tv();�� �� �������� ����
		Tv t2 = new Tv();
		System.out.println("t1�� channel���� " + t1.channel + "�Դϴ�.");
		System.out.println("t2�� channel���� " + t2.channel + "�Դϴ�.");
		
		t2 = t1;
		t1.channel = 7;
		System.out.println("t1�� channel���� 7�� �����Ͽ����ϴ�.");
		
		System.out.println("t1�� channel���� " + t1.channel + "�Դϴ�.");
		System.out.println("t2�� channel���� " + t2.channel + "�Դϴ�.");
	}
}