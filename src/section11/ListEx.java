package section11;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	
	public void type1() {//�⺻�� ������
		List<String> list = new ArrayList<String>();
		
		//�߰�(Create), �Է�, ����
		list.add("��");
		list.add("���帧");
		list.add("����");
		list.add("�ܿ�");
		
		//R(Read, �б�, �˻�)
		System.out.println(list.get(0));//��
		
		//U(Update, ����)
		System.out.println("������ : " + list.get(1));
		list.set(1, "����");
		System.out.println("������ : " + list.get(1));
		
		//D(Delete, ����)
		list.remove(1);
		
		System.out.println(list);
		
	}
	public void type2() {// ��ü�� ������
		
	}
	
	public static void main(String[] args) {
		ListEx ex = new ListEx();
		ex.type1();
	}
}





