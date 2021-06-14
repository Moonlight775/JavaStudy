package section9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternEx {
	public void numCheck(String data) {
		String reg = "[0-9]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if(m.matches()) {
			System.out.println(data + "는 " + reg + " 에 합당함.");
		}else {
			System.out.println(data + " 부적절한 데이터임.");
		}
	}
	// 매개변수로 전달된 data가 영문자인지 판별하여 출력(대소문자 구분없이)
	public void alphaCheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		boolean b = m.matches();
		if(b) {
			System.out.println(data + "는 " + reg + " 에 합당함");
		}else {
			System.out.println(data + " 부적절한 데이터임.");
		}
		
	}
	
	public void idCheck(String id, String pwd) {
		String reg1 = "[a-z0-9]{8}";
		String reg2 = "[0-9]{6}";
		Pattern p = Pattern.compile(reg1);
		
				
		
	}
}
