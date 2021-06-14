package section9;

import java.text.DecimalFormat;

public class FormatEx {
	public FormatEx() {
		String s1 = String.format("%d 는 %c 학점입니다.\n", 100, 'A');
		String temp = 100 + " 는 " + 'A' + "학점입니다.\n";
		
		System.out.println(s1);
		System.out.println(temp);
		
		String s2 = String.format("%10.2f", 123.12345678);
		System.out.println("[" + s2 + "]");
		
		String name = "문관영";
		String nicName = "홍길동";
		//'문관영'의 별명은 '홍길동'입니다.
		String fmt = "'%s'의 별명은 '%s'입니다.\n";
		String rst = String.format(fmt, "문관영", "홍길동");
		System.out.println(rst);
		System.out.printf(fmt , "일지매", "의적");
		
		// format문자열을 사용하여 구구단을 출력
		int dan = 2;
		String frm2 = "%d * %d = %d";
		for(int i=1 ; i<10; i++) {
			rst = String.format(frm2, dan, i, (dan*i));
			System.out.println(rst);
		}
		
		//숫자에 천단위 분리기호르 붙여 출력하기
		double value = 1234567.899423;
		String pattern="0,000,000,000,000.000";
		DecimalFormat df = new DecimalFormat(pattern);
		System.out.println(df.format(value));
		
	}
	
	public static void main(String[] args) {
		new FormatEx();
	}

}
