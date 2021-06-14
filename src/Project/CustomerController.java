//회원 정보 CRUD 컨트롤러

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	// 회원 정보 입력기능
	public String append(Customer c, boolean isSame) {
		String msg = "데이터가 정상적으로 저장되었습니다.";

		try {
			// 빈칸이 있을 경우
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) {
				msg = "값을 입력해주세요.";
			} else { // 빈칸이 없는데, ID가 중복일 경우 check
				if (isSame) // 아이디가 존재한다면
					msg = "이미 가입된 회원입니다.";
				else {
					MainData.addCustomer(c); // 정보를 리스트에 추가
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "데이터 저장 중 오류발생.";
		}
		return msg;
	}

	// 수정 기능
	public String update(String id, String phoneNum, String irum, String address) {
		String msg = "데이터가 정상적으로 수정되었습니다.";

		try {
			if (id.length() == 0)
				msg = "값을 선택해주세요.";
			// 빈칸이 있을 경우
			else if (!(id.length() != 0 && irum.length() != 0 && address.length() != 0))
				msg = "수정할 값을 입력해주세요.";
			else {
				// 리스트 내용 수정
				for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) {

						MainData.getCustomers().get(index).setPhoneNum(phoneNum);
						MainData.getCustomers().get(index).setIrum(irum);
						MainData.getCustomers().get(index).setAddress(address);

						for (int i = 0; i < MainData.getCheckOutInfo().size(); i++) {
							CheckOut c = MainData.getCheckOutInfo().get(i);
							System.out.println(c.getIrum());
							System.out.println(c.getPhone());
							System.out.println(id);
							if (c.getPhone().equals(id)) {
								System.out.println("수정함");
								c.setPhone(phoneNum);
								c.setIrum(irum);
							}
						}

						break;
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "데이터 수정 중 오류 발생.";
		}
		return msg;
	}

	// 삭제 기능
	public String delete(String id) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
		try {
			if (id.length() == 0)
				msg = "값을 선택해주세요.";
			else {
				for (int index = MainData.getCustomers().size() - 1; index >= 0; index--) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) {
						MainData.getCustomers().remove(index);
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "데이터 삭제 중 오류 발생";
		}
		return msg;
	}

	// 조회 기능
	public List<Customer> search(String findID, String findIrum) {
		List<Customer> returnList = new ArrayList<Customer>();

		for (int index = 0; index < MainData.getCustomers().size(); index++) {
			Customer target = MainData.getCustomers().get(index);
			if (findID.length() == 0) { // 도서명(or No.)의 검색어가 없는경우
				if (target.getIrum().indexOf(findIrum) > -1) { // 저자명과 일치하는 객체만 추가.
					returnList.add(target);
				}
			} else if (findIrum.length() == 0) { // 저자명의 검색어가 없는경우
				if (target.getPhoneNum().indexOf(findID) > -1) { // 도서명(or No.)과 일치하는 객체만 추가
					returnList.add(target);
				}
			} else {
				if (target.getPhoneNum().indexOf(findID) > -1 && target.getIrum().indexOf(findIrum) > -1) // 둘다 일치하는 객체만
																											// 추가
					returnList.add(target);
			}
		}
		return returnList;
	}

	// 회원 검색 메소드 (대여탭)
	Customer searchCustomer(String PhoneNum) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (MainData.getCustomers().get(i).getPhoneNum().equals(PhoneNum))
				return MainData.getCustomers().get(i);
		}
		return null;
	}

	List<Customer> searchCustomers(String endPhoneNum) { // 검색조건(휴대전화 끝번호 4개)
		// 입력한 검색조건 무결성 확인
		if (endPhoneNum.length() != 4) { // 입력값이 네자리가 아닐 경우
			return null;
		} else
			try {
				Integer.parseInt(endPhoneNum); // 숫자가 아닐경우
			} catch (Exception ex) {
				return null;
			}
		// searchEndPhoneNum 메소드를 통해 끝자리 번호 4개가 일치하는 회원리스트를 생성
		List<Customer> searchCustomerList = searchEndPhoneNum(endPhoneNum);

		return searchCustomerList; // 검색된 회원리스트를 반환
	}

	// 끝번호 네자리로 검색
	List<Customer> searchEndPhoneNum(String findNum) {
		List<Customer> returnList = new ArrayList<Customer>();
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			String endNum = MainData.getCustomers().get(i).getPhoneNum()
					.substring(MainData.getCustomers().get(i).getPhoneNum().length() - 4);
			if (findNum.equals(endNum))
				returnList.add(MainData.getCustomers().get(i));
		}
		return returnList;
	}

	// 중복 회원 가입 여부 확인
	private boolean overlappingCheck(Customer c) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (c.getPhoneNum().equals(MainData.getCustomers().get(i).getPhoneNum()))
				return true;
		}
		return false;
	}

	// 휴대전화 무결성 확인
	private boolean phoneNumCheck(String num) {
		if (num.length() != 11)
			return true;
		else {
			if (num.charAt(0) != '0' || num.charAt(1) != '1' || num.charAt(2) != '0')
				return true;
			for (int i = 3; i < num.length(); i++) {
				if (!('0' <= num.charAt(i) && num.charAt(i) <= '9'))
					return true;
			}
		}
		return false;
	}
	//

}
