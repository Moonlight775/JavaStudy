package section8;

public class TryExam2 {
	int[] score = new int[5];
	
	TryExam2() {
		score = new int[5];	//score = new int[] {1,2,3,4,5};
	}
	void test() {
		try {
			score = new int[] {10,20,30,40,50,60};
//		score[0] = 10;
//		score[1] = 20;
//		score[2] = 30;
//		score[3] = 40;
//		score[4] = 50;
//		score[5] = 60;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void output() {
		int sum = 0;
		double avg = 0;
		for(int index=0; index<score.length; index++) {
			System.out.println(score[index]);
			sum += score[index];
		}
		avg = (double)sum / score.length; //������ ���� �������� ������ �ȴ�. �Ǽ������� �����ߴ��ص� �������� �ǹǷ� ����ȯ�� �ʿ��ϴ�.
		System.out.println("�հ�:" + sum);
		System.out.println("���:" + avg);
	}
	
	public static void main(String[] k) {
		TryExam2 t = new TryExam2();
		t.test();
		t.output();
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		new TryExam2();
//	}
//	
//	
//	TryExam2() {
//		System.out.println("TryExam.2().");
//		int[] score = new int[5];
//		test();
//	}
//	
//	void test() {
//		int num = (int)(Math.random()*6)+1;
//		for (int i=0; i<6; i++) {
//			
//		}
//		System.out.println("TryExam2.test().");
//	}
//	
//	void output() {
//		
//	}
}
