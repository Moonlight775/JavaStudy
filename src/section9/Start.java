package section9;

import java.util.List;

public class Start {

	public static void main(String[] args) {
		//StringEx s = new StringEx();
		//StringSpeed ss = new StringSpeed();
		//ss.speedTest();
		
		// WrapperEx의  getList()결과를 출력
		//WrapperEx wex = new WrapperEx();
		//List<Integer> a = wex.getList();
		//System.out.println(a);
		
		String[] data = {"123","123.5", "abc", "abc123", "123abc",
				       "홍길동", "홍길동abc", "홍길동abc123"};
		
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
		p.idCheck(id, pwd); //아이디가 영숫자 8자리이면 pass, 암호는 숫자6자리이면 pass
		
		System.out.println("-------------------------");
		String phone = "10-6351-3491";
		boolean b = p.phoneCheck(phone);
		if(b) System.out.println(phone + " 정상적인 연락처입니다.");
		else  System.out.println(phone + " 비정상적인 연락처입니다.");
		
		System.out.println("--------------------------------");
		String email = "a123@naver.co.kr.a.b";
		b = p.emailCheck(email);
		if(b) System.out.println(email + " 정상.");
		else  System.out.println(email + " 비정상.");
		
		System.out.println("---------------------------");
		String hangul = "홍길동123";
		b = p.hangulCheck(hangul);
		if(b) System.out.println(hangul + "은(는) 한글로 이루어짐.");
		else System.out.println(hangul + "은(는) 모두 한글로 이루이지진 않음.");
		
	}

}





