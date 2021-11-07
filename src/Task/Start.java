package Task;

import java.util.Scanner;

public class Start {
	public static void main(String[] k) {
	
	System.out.print("이름을 입력하시오.>");
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
		
	PatternEx p = new PatternEx();	
	String hangul = name;
	boolean b = p.hangulCheck(hangul);
	if(b) System.out.println(hangul + "은(는) 한글로 이루어짐.");
	else System.out.println(hangul + "은(는) 모두 한글은 아님.");
	
	}
}
