package section9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternEx {
	
	public void numCheck(String data) {
		String reg = "[0-9]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if( m.matches() ) {
			System.out.println(data + "´Â " + reg + " ¿¡ ÇÔ´çÇÔ.");
		}else {
			System.out.println(data + " ºÎÀûÀıÇÑ µ¥ÀÌÅÍÀÓ.");
		}
	}
	
	// ¸Å°³º¯¼ö·Î Àü´ŞµÈ data °¡ ¿µ¹®ÀÚÀÎÁö ÆÇº°ÇÏ¿© Ãâ·Â(´ë¼ö¹®ÀÚ±¸ºĞ¾øÀÌ)
	public void alphaCheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		boolean b = m.matches();
		if(b) {
			System.out.println(data + "´Â " + reg + " ¿¡ ÇÔ´çÇÔ.");
		}else {
			System.out.println(data + " ºÎÀûÀıÇÑ µ¥ÀÌÅÍÀÓ.");
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
		
		if(idB)	System.out.println(id + "´Â Á¤»óÀÓ.");
		else    System.out.println(id + "´Â ºñÁ¤»óÀÓ.");
		
		if(pwdB) System.out.println(pwd + "´Â Á¤»óÀÓ.");
		else     System.out.println(pwd + "´Â ºñÁ¤»óÀÓ.");
		
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
		String reg = "^[°¡-ÆR]*$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(hangul);
		b = m.matches();
		return b;
	}
}










