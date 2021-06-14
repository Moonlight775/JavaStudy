package section11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
	public MapEx() {
		Map<String, Integer> map = new HashMap<String, Integer>(); //<key��,value��>
		//�߰�
		map.put("kim", 70);
		map.put("park", 89);
		map.put("lee", 60);
		//��ȸ
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
			
		}
		
		//����
		map.put("park", 80);
		System.out.println("park value : " + map.get("park"));
		
		//����
		map.remove("park");
		System.out.println("park value : " + map.get("park"));
		
		//��ü ����
		Map<String, Member> mMap = new HashMap<String, Member>();
		mMap.put("kim", new Member("kim ", "�达", "010-1111","������"));
		mMap.put("park", new Member("park", "�ھ�", "010-1111","������"));
		mMap.put("choi", new Member("choi", "�־�", "010-1111","������"));
		mMap.put("hong", new Member("hong", "ȫ��", "010-1111","������"));
		
		//��ü ���
		Set<String> mKey = mMap.keySet();
		Iterator<String> mIter = mKey.iterator();
		while(mIter.hasNext()) {
			String k = mIter.next();
			Member m = mMap.get(k);
			String str = String.format("%s[%s] Phone:%s Address:%s", 
					m.getId(), m.getIrum(), m.getPhone(), m.getAddress());
			System.out.println(str);
		}
		
		//ȫ���� �ּҸ� ����÷� ������ �� �� ����� ���
		Member m = mMap.get("hong");
		m.setAddress("���� ���α�");
		mMap.put("hong", m);
		System.out.println("-----------------------");
		m = mMap.get("hong");
		String str = String.format("%s[%s] Phone:%s Address:%s", 
				m.getId(), m.getIrum(), m.getPhone(), m.getAddress());
		System.out.println(str);
		
	}
	
	public static void main(String[] args) {
		new MapEx();
	}
}













