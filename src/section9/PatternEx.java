package section9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternEx {
	public void numCheck(String data) {
		String reg = "[0-9]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if(m.matches()) {
			System.out.println(data + "�� " + reg + " �� �մ���.");
		}else {
			System.out.println(data + " �������� ��������.");
		}
	}
	// �Ű������� ���޵� data�� ���������� �Ǻ��Ͽ� ���(��ҹ��� ���о���)
	public void alphaCheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		boolean b = m.matches();
		if(b) {
			System.out.println(data + "�� " + reg + " �� �մ���");
		}else {
			System.out.println(data + " �������� ��������.");
		}
		
	}
	
	public void idCheck(String id, String pwd) {
		String reg1 = "[a-z0-9]{8}";
		String reg2 = "[0-9]{6}";
		Pattern p = Pattern.compile(reg1);
		
				
		
	}
}
