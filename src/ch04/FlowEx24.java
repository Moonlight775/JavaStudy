package ch04;

class FlowEx24 {
	public static void main(String[] args) {
//		int i = 11;
//		
//		System.out.println("ī��Ʈ�ٿ��� �����մϴ�.");
//		
//		while(--i>=0) {
//			System.out.printf("%d%n", i);
//		}
//		System.out.print("Game over");
		
		int i = 11;
		
		System.out.println("ī��Ʈ �ٿ��� �����մϴ�.");
		
		while(i--!=0) {
			System.out.println(i);
			for(int j=0; j<2_000_000_000; j++) { //�ð������� ���� �ǹ̾��� �� ����
				;
			}
		} System.out.println("Game over");
	}
}