package task;

class Onetohundreadwithoutrepeat {
	public static void main(String[] args) {
		int count = 1;
		int sum = 0;
		sums(count, sum);		
}

	public static void sums(int b, int c) {
		c += b;
		b++;
		if(b < 101) {
			sums(b,c);
		}else {
			System.out.println(c);
		}
	}
}