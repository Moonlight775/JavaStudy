package section11;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
	public static List<Member> members = new ArrayList<Member>();
	
	public String append(Member m) {
		String msg = "데이터가 정상적으로 저장되었습니다.";
		try {
			members.add(m);
		}catch(Exception ex) {
			ex.printStackTrace();//개발자를 위한 메시지
			msg = "데이터 저장중 오류 발생";
		}
		return msg;
	}
	
	public String update(Member m) {
		String msg = "데이터가 정상적으로 수정되었습니다.";
		try {
			for(int index=0 ; index<members.size() ; index++) {
				Member target = members.get(index);
				
				if(target.getId().equals(m.getId()) ) {
					members.set(index, m);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg="데이터 수정중 오류 발생.";
		}
		
		return msg;
	}
	
	public String delete(Member m) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
		try {
			for(int i=members.size()-1; i>=0; i--) {
				if(members.get(i).getId().equals(m.getId())) {
					members.remove(i);
					break;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			msg = "데이터 삭제 중 오류 발생";
		}
		return msg;
	}
	
	public List<Member> search(String findStr) {
		List<Member> returnList = new ArrayList<Member>();
		
		for(int index=0 ; index<members.size() ; index++) {
			Member target = members.get(index);
			if(target.getId().indexOf(findStr)>-1    || 
			   target.getIrum().indexOf(findStr)>-1  ||
			   target.getPhone().indexOf(findStr)>-1 ||
			   target.getAddress().indexOf(findStr)>-1 ) {
				returnList.add(target);
			}
		}
		
		return returnList;
	}
	public Member selectOne(String id) {
		Member m = null;
		for(int i=0 ;i<members.size() ; i++) {
			Member target = members.get(i);
			if(id.equals(target.getId())) {
				m= target;
				break;
			}
		}
		
		return m;
	}
	
}









