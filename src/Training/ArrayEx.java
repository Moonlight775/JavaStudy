package Training;

class ArrayEx {

	public static void main(String[] args) {
		
//		int[] score; // 1. 배열 score를 선언(참조변수)
//		score = new int[5]; // 2. 배열의 생성(int저장공간 x5)
		
//		int[] score = new int[5]; // 배열의 선언과 생성을 동시에 진행
//		score[3] = 100;
//		
//		System.out.println(score[3]);
		
		int[] score = new int[6];
		
//		for (int i=0; i<6; i++)
//			System.out.println(score[i]);
		
		for(int i=0; i<score.length; i++) //인덱스 범위를 잘못 쓸 위험이 사라짐 (조건식을 변경하지 않아도 됨)
			System.out.println(score[i]);
		
				
		

	}

}
