//ȸ�� ���� CRUD ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	// ȸ�� ���� �Է±��
	public String append(Customer c, boolean isSame) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";

		try {
			// ��ĭ�� ���� ���
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) {
				msg = "���� �Է����ּ���.";
			} else { // ��ĭ�� ���µ�, ID�� �ߺ��� ��� check
				if (isSame) // ���̵� �����Ѵٸ�
					msg = "�̹� ���Ե� ȸ���Դϴ�.";
				else {
					MainData.addCustomer(c); // ������ ����Ʈ�� �߰�
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� �����߻�.";
		}
		return msg;
	}

	// ���� ���
	public String update(String id, String phoneNum, String irum, String address) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";

		try {
			if (id.length() == 0)
				msg = "���� �������ּ���.";
			// ��ĭ�� ���� ���
			else if (!(id.length() != 0 && irum.length() != 0 && address.length() != 0))
				msg = "������ ���� �Է����ּ���.";
			else {
				// ����Ʈ ���� ����
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
								System.out.println("������");
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
			msg = "������ ���� �� ���� �߻�.";
		}
		return msg;
	}

	// ���� ���
	public String delete(String id) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			if (id.length() == 0)
				msg = "���� �������ּ���.";
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
			msg = "������ ���� �� ���� �߻�";
		}
		return msg;
	}

	// ��ȸ ���
	public List<Customer> search(String findID, String findIrum) {
		List<Customer> returnList = new ArrayList<Customer>();

		for (int index = 0; index < MainData.getCustomers().size(); index++) {
			Customer target = MainData.getCustomers().get(index);
			if (findID.length() == 0) { // ������(or No.)�� �˻�� ���°��
				if (target.getIrum().indexOf(findIrum) > -1) { // ���ڸ�� ��ġ�ϴ� ��ü�� �߰�.
					returnList.add(target);
				}
			} else if (findIrum.length() == 0) { // ���ڸ��� �˻�� ���°��
				if (target.getPhoneNum().indexOf(findID) > -1) { // ������(or No.)�� ��ġ�ϴ� ��ü�� �߰�
					returnList.add(target);
				}
			} else {
				if (target.getPhoneNum().indexOf(findID) > -1 && target.getIrum().indexOf(findIrum) > -1) // �Ѵ� ��ġ�ϴ� ��ü��
																											// �߰�
					returnList.add(target);
			}
		}
		return returnList;
	}

	// ȸ�� �˻� �޼ҵ� (�뿩��)
	Customer searchCustomer(String PhoneNum) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (MainData.getCustomers().get(i).getPhoneNum().equals(PhoneNum))
				return MainData.getCustomers().get(i);
		}
		return null;
	}

	List<Customer> searchCustomers(String endPhoneNum) { // �˻�����(�޴���ȭ ����ȣ 4��)
		// �Է��� �˻����� ���Ἲ Ȯ��
		if (endPhoneNum.length() != 4) { // �Է°��� ���ڸ��� �ƴ� ���
			return null;
		} else
			try {
				Integer.parseInt(endPhoneNum); // ���ڰ� �ƴҰ��
			} catch (Exception ex) {
				return null;
			}
		// searchEndPhoneNum �޼ҵ带 ���� ���ڸ� ��ȣ 4���� ��ġ�ϴ� ȸ������Ʈ�� ����
		List<Customer> searchCustomerList = searchEndPhoneNum(endPhoneNum);

		return searchCustomerList; // �˻��� ȸ������Ʈ�� ��ȯ
	}

	// ����ȣ ���ڸ��� �˻�
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

	// �ߺ� ȸ�� ���� ���� Ȯ��
	private boolean overlappingCheck(Customer c) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (c.getPhoneNum().equals(MainData.getCustomers().get(i).getPhoneNum()))
				return true;
		}
		return false;
	}

	// �޴���ȭ ���Ἲ Ȯ��
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
