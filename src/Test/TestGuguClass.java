package Test;

class TestGuguClass {

	public static void main(String[] args) {
		Gugu a = new Gugu();
		a.guguMethod();
		

	}
	
	class Gugu{
	
	void guguMethod() {
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				guguOutput(i, j);
			}
		}
	}

	void guguOutput(int i, int j) {
		System.out.printf("%d x %d = %d%n", i, j, i*j);
	}
	}
}
