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
			System.out.print("1�� 100������ ������ �Է��ϼ���.>");
			input = scanner.nextInt();
			
			if(input==trapNum1 || input==trapNum2 || input ==trapNum3)
				System.out.println("������ �����̽��ϴ�.");
			System.out.print("����Ͻðڽ��ϱ�? (y/n)");
			input = scanner.nextInt();
			
		} while(input !=answer);
			
		}
		
	}


