package ch04;

class FlowEx13 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1; i<=10; i++) { //i = 1~10까지
			sum += i; // sum = sum + i;
			System.out.printf("1부터 %2d 까지의 합: %2d%n", i, sum);
		}
	}
}
