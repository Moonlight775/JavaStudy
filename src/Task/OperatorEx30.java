package task;

class OperatorEx30 {
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
}
	public static void main(String[] args) {
		int dec = 7;
		
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaryString(dec >> 1)); //2���� 1�ڸ��� ���������� �̵��ϸ� 11�� 3�� �ȴ�.
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 2, dec >> 2, toBinaryString(dec >> 2)); //2���� 2�ڸ��� ���������� �̵��Ͽ� 1�� 1�� �ȴ�.
		
		System.out.printf("%d << %d = %4d \t%s%n", dec, 0, dec << 0, toBinaryString(dec << 0));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaryString(dec << 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 2, dec << 2, toBinaryString(dec << 2));
		System.out.println();
		
		dec = -7;
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 1, dec >> 1, toBinaryString(dec >> 1));
		System.out.printf("%d >> %d = %4d \t%s%n", dec, 2, dec >> 2, toBinaryString(dec >> 2));
		
		System.out.printf("%d << %d = %4d \t%s%n", dec, 0, dec << 0, toBinaryString(dec << 0));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 1, dec << 1, toBinaryString(dec << 1));
		System.out.printf("%d << %d = %4d \t%s%n", dec, 2, dec << 2, toBinaryString(dec << 2));
		System.out.println();
		
		dec = 7;
		System.out.printf("%d >> %2d = %4d \t%s%n", dec, 0, dec >> 0, toBinaryString(dec >> 0));
		System.out.printf("%d >> %2d = %4d \t%s%n", dec, 32, dec >> 32, toBinaryString(dec >> 32));
	}
}
