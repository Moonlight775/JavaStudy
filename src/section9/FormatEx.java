package section9;

import java.text.DecimalFormat;

public class FormatEx {
	public FormatEx() {
		String s1 = String.format("%d �� %c �����Դϴ�.\n", 100, 'A');
		String temp = 100 + " �� " + 'A' + "�����Դϴ�.\n";
		
		System.out.println(s1);
		System.out.println(temp);
		
		String s2 = String.format("%10.2f", 123.12345678);
		System.out.println("[" + s2 + "]");
		
		String name = "������";
		String nicName = "ȫ�浿";
		//'������'�� ������ 'ȫ�浿'�Դϴ�.
		String fmt = "'%s'�� ������ '%s'�Դϴ�.\n";
		String rst = String.format(fmt, "������", "ȫ�浿");
		System.out.println(rst);
		System.out.printf(fmt , "������", "����");
		
		// format���ڿ��� ����Ͽ� �������� ���
		int dan = 2;
		String frm2 = "%d * %d = %d";
		for(int i=1 ; i<10; i++) {
			rst = String.format(frm2, dan, i, (dan*i));
			System.out.println(rst);
		}
		
		//���ڿ� õ���� �и���ȣ�� �ٿ� ����ϱ�
		double value = 1234567.899423;
		String pattern="0,000,000,000,000.000";
		DecimalFormat df = new DecimalFormat(pattern);
		System.out.println(df.format(value));
		
	}
	
	public static void main(String[] args) {
		new FormatEx();
	}

}
