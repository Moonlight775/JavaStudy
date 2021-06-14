package Test;

public class array {
	public static void main(String[] args) {
	int[] su = {1,2,3,4,5,6,10};
	
	double avg = 0;
	int sum =0;

	
	for(int i : su) {
		sum += i;
	}
	
	avg = sum / su.length;
	
	System.out.println("합계 : " + sum);
	System.out.println("평균 : " + avg);
}
}
