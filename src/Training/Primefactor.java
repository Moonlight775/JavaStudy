package Training;

import java.util.*;

class Primefactor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력해주세요.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		int tmp = num;
		
		while(num !=1) {
			for(int i=2; i<=num; i++) {
				if(num%i==0) {
					num = num/i;
					System.out.print(i);
					break;
				}
			}
		}
	
	}

}
