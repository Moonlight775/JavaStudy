package section11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetEx {
	
	//������
	public SetEx() {
		//�ߺ� x, ����x
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		set.add(10);
		set.add(20);
		
		//����ϱ� ���ؼ��� Iterator�� �����ؾ� �Ѵ�. , set�� �������̹Ƿ� �������ִ� Iterator�� ������Ѵ�.
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// set������ ����� �ߺ����� �ʴ� ��ȣ 6�� ����
		Set<Integer> lotto = new HashSet<Integer>();
		Random r = new Random();
		while(lotto.size()<6) {
			lotto.add(r.nextInt(45)+1);
		}
		System.out.println(lotto);
		
		//��ü����(Member)
		Member m1 = new Member("hong","gil dong", "010", "busan");
		Member m2 = new Member("kim","gil dong", "010", "busan");
		Member m3 = new Member("lee","gil dong", "010", "busan");
		Member m4 = new Member("park","gil dong", "010", "busan");
		
		Set<Member> setMember = new HashSet<Member>();
		setMember.add(m1);
		setMember.add(m2);
		setMember.add(m3);
		setMember.add(m4);
		
		//����� ��ü ���
		Iterator<Member> mIter = setMember.iterator();
		while(mIter.hasNext()) {
			Member m = mIter.next();
			String str = String.format("%s[%s] Phone:%s Address:%s", 
					m.getId(), m.getIrum(), m.getPhone(), m.getAddress());
			System.out.println(str);
		}
		

	}
	//main + SetExŬ���� �����ڵ�
	public static void main(String[] args) {
		SetEx ex = new SetEx();
	}

}
