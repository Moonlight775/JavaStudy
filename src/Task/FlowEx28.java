package task;

import java.util.*;

class FlowEx28 {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		int trapNum1, trapNum2, trapNum3 = 0;
		answer = (int)(Math.random() * 100) +1;
		trapNum1 = (int)(Math.random() * 100) +1;
		trapNum2 = (int)(Math.random() * 100) +1;
		trapNum3 = (int)(Math.random() * 100) +1;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("1과 100사이의 정수를 입력하세요.>");
			input = scanner.nextInt();
			
			if(input==trapNum1 || input==trapNum2 || input ==trapNum3)
				System.out.println("함정에 빠지셨습니다.");
			System.out.print("계속하시겠습니까? (y/n)");
			input = scanner.nextInt();
			
		} while(input !=answer);
			
		}
		
	}


