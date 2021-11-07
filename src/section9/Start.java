package section9;

import java.util.List;

public class Start {

	public static void main(String[] args) {
		//StringEx s = new StringEx();
		//StringSpeed ss = new StringSpeed();
		//ss.speedTest();
		
		// WrapperEx��  getList()����� ���
		//WrapperEx wex = new WrapperEx();
		//List<Integer> a = wex.getList();
		//System.out.println(a);
		
		String[] data = {"123","123.5", "abc", "abc123", "123abc",
				       "ȫ�浿", "ȫ�浿abc", "ȫ�浿abc123"};
		
		PatternEx p = new PatternEx();
		for(String d : data) {
			p.numCheck(d);
		}
		System.out.println("--------------------");
		for(String d : data) {
			p.alphaCheck(d);
		}
		
		System.out.println("------------------------");
		String id="abcdef12";
		String pwd = "123456";
		p.idCheck(id, pwd); //���̵� ������ 8�ڸ��̸� pass, ��ȣ�� ����6�ڸ��̸� pass
		
		System.out.println("-------------------------");
		String phone = "10-6351-3491";
		boolean b = p.phoneCheck(phone);
		if(b) System.out.println(phone + " �������� ����ó�Դϴ�.");
		else  System.out.println(phone + " ���������� ����ó�Դϴ�.");
		
		System.out.println("--------------------------------");
		String email = "a123@naver.co.kr.a.b";
		b = p.emailCheck(email);
		if(b) System.out.println(email + " ����.");
		else  System.out.println(email + " ������.");
		
		System.out.println("---------------------------");
		String hangul = "ȫ�浿123";
		b = p.hangulCheck(hangul);
		if(b) System.out.println(hangul + "��(��) �ѱ۷� �̷����.");
		else System.out.println(hangul + "��(��) ��� �ѱ۷� �̷������� ����.");
		
	}

}





