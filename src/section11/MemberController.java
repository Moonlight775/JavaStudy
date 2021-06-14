package section11;

import java.util.ArrayList; //�ٸ� ��Ű���̱� ������ import�ϴ� ��
import java.util.List;

public class MemberController {
   //�������� ���(1.�ʱ�ȭ�� �ּ� 1ȸ, ��ü�� ���������ʰ� Ŭ�������� ���� ���ٰ���)
	public static List<Member> members = new ArrayList<Member>(); //���� package�̱� ������ member�� import�� �ʿ� ����.
							  //����3�� �����(DB~)
	public String append(Member m) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			members.add(m);		//List add(�߰�), set(����), get(�˻�), remove(����)
		}catch(Exception ex) {
			ex.printStackTrace(); //�����ڸ� ���� �޽���
			msg = "������ ������ ���� �߻�";
		}
		return msg;
	}
	
	public String update(Member m) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
		for(int index=0; index<members.size(); index++) {
			Member target = members.get(index);
			
			if(target.getId().equals(m.getId())) {
				members.set(index, m);
				break;
			}
		}
	}catch(Exception ex) {
		ex.printStackTrace();
		msg = "������ ������ ���� �߻�.";
		}
	return msg;
	}
	
	public String delete(Member m) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			for(int index=members.size()-1; index>=0; index--) {
				Member target = members.get(index);
				
				if(target.getId().equals(m.getId())) {
					members.remove(index);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = "������ ������ ���� �߻�.";
		}
		return msg;
	}
	
	public List<Member> search(String findStr) {
		List<Member> returnList = new ArrayList<Member>();
		
		for(int index=0; index<members.size(); index++) {
			Member target = members.get(index);
			if(target.getId().indexOf(findStr)>-1    ||
			   target.getIrum().indexOf(findStr)>-1  ||
			   target.getPhone().indexOf(findStr)>-1 ||
			   target.getAddress().indexOf(findStr)>-1	) {
				returnList.add(target);
			}
		}
		
		return returnList;
		
	}
	
	public Member selectOne(String id) {
		Member m = null;
		for(int i=0; i<members.size(); i++) { //�鵥���ͺ��̽����� ������.
			Member target = members.get(i);
			if(id.equals(target.getId())){
				m= target;
				break;   //for, while, switch �� �� 3���� break; ���
			}
		}								      //��
		
		
		return m;
	}
}



















