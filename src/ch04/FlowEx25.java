package ch04;

import java.util.*;

class FlowEx25 {
	public static void main(String[] args) {
		int sum, num = 0;
		System.out.println("���ڸ� �Է��ϼ���. (��:12345)>");
		
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();
		num = Integer.parseInt(tmp);
		
		while(num!=0) {
			sum += num%10;
			
					
		}
		
	}
}