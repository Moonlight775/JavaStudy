package section9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternEx {
	
	public void numCheck(String data) {
		String reg = "[0-9]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if( m.matches() ) {
			System.out.println(data + "는 " + reg + " 에 함당함.");
		}else {
			System.out.println(data + " 부적절한 데이터임.");
		}
	}
	
	// 매개변수로 전달된 data 가 영문자인지 판별하여 출력(대수문자구분없이)
	public void alphaCheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		boolean b = m.matches();
		if(b) {
			System.out.println(data + "는 " + reg + " 에 함당함.");
		}else {
			System.out.println(data + " 부적절한 데이터임.");
		}
	}
	
	public void idCheck(String id, String pwd) {
		String idReg = "[a-zA-Z0-9]{8}";
		String pwdReg = "[0-9]{6}";
		
		Pattern idP = Pattern.compile(idReg);
		Matcher idM = idP.matcher(id);
		boolean idB = idM.matches();
		
		Pattern pwdP = Pattern.compile(pwdReg);
		Matcher pwdM = pwdP.matcher(pwd);
		boolean pwdB = pwdM.matches();
		
		if(idB)	System.out.println(id + "는 정상임.");
		else    System.out.println(id + "는 비정상임.");
		
		if(pwdB) System.out.println(pwd + "는 정상임.");
		else     System.out.println(pwd + "는 비정상임.");
		
	}
	
	public boolean phoneCheck(String phone) {
		boolean b = false;
		String reg = "0[\\d]{1,2}-\\d{3,4}-\\d{4}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phone);
		b = m.matches();
		return b;
	}
	public boolean emailCheck(String email) {
		boolean b = false;
		String reg="^[a-zA-Z]+[\\w]+@[a-zA-Z]+(\\.[a-zA-Z_]+){1,3}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(email);
		b = m.matches();
		return b;
	}
	
	public boolean hangulCheck(String hangul) {
		boolean b = false;
		String reg = "^[가-힣]*$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(hangul);
		b = m.matches();
		return b;
	}
}










