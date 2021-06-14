package ch02;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		
		int num1 = 0 ;
		int num2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 :");
		num1 = sc.nextInt();
		System.out.print("두번째 정수 :");
		num2 = sc.nextInt();
		
		System.out.println("첫번째 정수 :" + num1);
		System.out.println("두번째 정수 :"+ num2);
		System.out.print("두수의 합 :");
		System.out.println(num1+num2);
	}
}