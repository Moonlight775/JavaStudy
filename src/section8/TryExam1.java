package section8;

public class TryExam1 {
	
	public static void main(String[] k) {
		new TryExam1(); //TryExam1() �����ڸ� �θ� ��, 1ȸ��
	}
	
	TryExam1(){
		System.out.println("TryExam.1().");
		test1(); // try~catch test
		try {
			test2(); // thorws test
		} catch (Exception e) {
			e.printStackTrace();
		} 
		test3(); // throw test
	}
	
	void test1() {
		System.out.println("TryExam1.test1().");
		int su1=100;
		int su2=0;
		double d=0;
		try {
			d = su1/su2;
		}catch(Exception ex) {
			System.out.println("�������...");
		}
		System.out.println("su1/su2=" + d);
	}
	
	void test2() throws Exception{
		System.out.println("TryExam1.test2().");	
	}
	
	void test3() {
		System.out.println("TryExam1.test3().");
		
		try {
			throw new Exception("���������~~~");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
