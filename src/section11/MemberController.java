package section11;

import java.util.ArrayList; //다른 패키지이기 때문에 import하는 것
import java.util.List;

public class MemberController {
   //↓정적형 멤버(1.초기화는 최소 1회, 객체를 생성하지않고 클래스명을 통해 접근가능)
	public static List<Member> members = new ArrayList<Member>(); //같은 package이기 때문에 member는 import할 필요 없다.
							  //↑제3의 저장소(DB~)
	public String append(Member m) {
		String msg = "데이터가 정상적으로 저장되었습니다.";
		try {
			members.add(m);		//List add(추가), set(수정), get(검색), remove(삭제)
		}catch(Exception ex) {
			ex.printStackTrace(); //개발자를 위한 메시지
			msg = "데이터 저장중 오류 발생";
		}
		return msg;
	}
	
	public String update(Member m) {
		String msg = "데이터가 정상적으로 수정되었습니다.";
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
		msg = "데이터 수정중 오류 발생.";
		}
	return msg;
	}
	
	public String delete(Member m) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
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
			msg = "데이터 삭제중 오류 발생.";
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
		for(int i=0; i<members.size(); i++) { //↓데이터베이스에서 뒤진다.
			Member target = members.get(i);
			if(id.equals(target.getId())){
				m= target;
				break;   //for, while, switch → 이 3개가 break; 사용
			}
		}								      //↑
		
		
		return m;
	}
}



















