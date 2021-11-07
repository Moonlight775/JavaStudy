package ch2;

class VarEx3 {
	public static void main(String[] args) {
		
		String url = "www.codechobo.com" ;
		
//		System.out.printf("[%.10s]%n", url) ;
//		
//		System.out.printf("%d%n", 15);
//		System.out.printf("%o%n", 15);
//		System.out.printf("%x%n", 15);
//		System.out.printf("%s", Integer.toBinaryString(15));
		
		System.out.printf("%#X%n", 15);
		
		Double f = 123.456789;
		System.out.printf("%f%n", f);
		System.out.printf("%e%n", f);
		
		System.out.printf("[%5d]%n", 10);
		System.out.printf("[%-5d]%n", 10);
		
		System.out.printf("[%20s]%n", url) ;
	}
	
}