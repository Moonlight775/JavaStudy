package Task;

import java.util.Scanner;

public class Start {
	public static void main(String[] k) {
	
	System.out.print("�̸��� �Է��Ͻÿ�.>");
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
		
	PatternEx p = new PatternEx();	
	String hangul = name;
	boolean b = p.hangulCheck(hangul);
	if(b) System.out.println(hangul + "��(��) �ѱ۷� �̷����.");
	else System.out.println(hangul + "��(��) ��� �ѱ��� �ƴ�.");
	
	}
}
