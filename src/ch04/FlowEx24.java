package ch04;

class FlowEx24 {
	public static void main(String[] args) {
//		int i = 11;
//		
//		System.out.println("카운트다운을 시작합니다.");
//		
//		while(--i>=0) {
//			System.out.printf("%d%n", i);
//		}
//		System.out.print("Game over");
		
		int i = 11;
		
		System.out.println("카운트 다운을 시작합니다.");
		
		while(i--!=0) {
			System.out.println(i);
			for(int j=0; j<2_000_000_000; j++) { //시간지연을 위한 의미없는 빈 문장
				;
			}
		} System.out.println("Game over");
	}
}