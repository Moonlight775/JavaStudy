package section9;

import java.util.List;

public class Start {

	public static void main(String[] args) {
		//StringEx s = new StringEx();
		//StringSpeed ss = new StringSpeed();
		//ss.speedTest();
		
		
		//WrapperEx의 getList()결과를 출력
//		WrapperEx wex = new WrapperEx();
//		List a = wex.getList();
//		System.out.println(a);
		/*
		String[] data = {"123", "123.5", "abc", "abc123", "123abc", "홍길동","홍길동abc", "홍길동abc123"};
		
		PatternEx p = new PatternEx();
		for(String d : data) {
			p.numCheck(d);
		}
		System.out.println("-----------------------");	
		for(String d : data) {
			p.alphaCheck(d);
		}
		System.out.println("-----------------------");	
		String id="abcdef";
		String pwd = "1234";
		p.idcheck(id, pwd); // 아이디가 영숫자 8자리이면 pass, 암호는 숫자 6자리이면 pass
		*/
		
		
		System.out.println("---------tokens---------");
		String source = "a,,6,,b.c.d,.e";
		String delim = ",|.";
		TokenEx ex = new TokenEx(source, delim, false);
		List<String>list = ex.getToken();
		System.out.println("return values ...");
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("-----------split-----------");
		ex.split(source,  delim, 4);
		
		System.out.println("--------- split regex ----------");
		delim = "[ab]";
		ex.split(source, delim, 10);;
		
//		Boolean returnDelims = true;
//		TokenEx ex = new TokenEx(source, delim, returnDelims);
//		ex.getToken();
		
	}

}
