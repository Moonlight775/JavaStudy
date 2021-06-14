package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckOutController {
//	final int CHECK_OUT_LIMIT = 5; // �δ� �� �뿩 ���� ��

	// �˻������ ���̺� ���
	String printSearchResult(List<?> result, JTable table) { // �Ű������� ȸ������Ʈ or ��������Ʈ
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();  // �˻����(ȸ������Ʈ)����� ���̺� ����
		tableModel.setRowCount(0); // ���̺� �ʱ�ȭ	

		if (result==null) // result�� null�� ���� ���˻� �� �˻������� �߸� �Է����� ���
			return "�޴���ȭ �� ���ڸ� ��ȣ�� �Է��ϼ���.";
		else if (result.isEmpty()) return "�˻� ����� �����ϴ�."; // ����Ʈ�� ������� ���

		else if (result.get(0) instanceof Customer) { // �Ű������� ȸ������Ʈ�� ���
			for (int i = 0; i < result.size(); i++) { // ȸ������Ʈ �б�
				Customer customer = (Customer) result.get(i); // ȸ������Ʈ�� ����� ȸ����
				String[] tableRecord = { customer.getIrum(), customer.getPhoneNum(), customer.getAddress() }; // �Ӽ����� ���̺� �࿡ �߰�(1)
				tableModel.addRow(tableRecord); // �Ӽ����� ���̺� �࿡ �߰�(2)
			}
		}
		else { // if (result.get(0) instanceof Book) { // �Ű������� ��������Ʈ�� ���
			for (int i = 0; i < result.size(); i++) { // ��������Ʈ �б�
				Book book = (Book) result.get(i); // ��������Ʈ�� ����� ������
				// �Ӽ����� ���̺� �࿡ �߰�
				String[] tableRecord = { book.getBookNo(), book.getSort(), book.getTitle(), book.getAuthor(), getCheckOutAble(book.getBookNo()) };
				// �뿩�������� ���  getCheckOutAble()�� �ش� å�� ������ȣ�� �̿��� ���ɿ��� Ȯ��
				tableModel.addRow(tableRecord);
			}
		}
		return null;
	}
	// �뿹 ���� ��Ͽ� ���� �߰�
	void addCheckOut(JTable bookTable, JTable checkOutTable) {
		List<Book> selectBooks = new ArrayList<Book>(); // �뿩���� ��������Ʈ
		int bookSelectRow[] = bookTable.getSelectedRows(); // ���õ� ���� ��ȣ�� ������ ������ �迭����
		String selectBookNo[] = new String[bookSelectRow.length]; // ���õ� ���� ����ŭ ������ ������ȣ ����

		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();

		for(int i=0; i<selectBookNo.length; i++) {
			selectBookNo[i] = (String)bookTable.getModel().getValueAt(bookSelectRow[i], 0); // ���õ� ���� ������ȣ �Է�
			Book selectBook = MainData.bookC.searchBookNo(selectBookNo[i]); // ������ȣ�� ��ġ�ϴ� ������ �˻��ؼ� �뿩���� ������ ����
			if( getCheckOutAble(selectBook.getBookNo()) != "�뿩����")	{ // �ش� ������ �뿩������ �ƴ� ���
				System.out.println("�뿩 ���� ������ ���õǾ����ϴ�.");
				continue;
			}
			else {
				boolean alreadyInput = false; // ����Ʈ�� �߰��Ǿ����� Ȯ�ο� ����
				for(int j=0; j<checkOutTableModel.getRowCount(); j++) { // �뿩���� ����Ʈ �б�
					if(selectBook.getBookNo().equals(checkOutTableModel.getValueAt(j, 0))) { // ����Ʈ�� ���� ������ȣ�� ���� ������ ���� ��� 
						alreadyInput = true;
						break;
					}	
				}
				if (!alreadyInput) // ����Ʈ�� �߰��Ǿ� ���� ���� ���
					selectBooks.add(selectBook); // �뿩���� ��������Ʈ�� ����
				else 
					System.out.println("�̹� ���õ� ������ �ֽ��ϴ�.");
			}
		}

		// �뿩���� ��������Ʈ�� �����뿩��� ���̺� �߰�
		for (int i = 0; i < selectBooks.size(); i++) {
			Book book = selectBooks.get(i);
			String[] checkOutTableTuple = { book.getBookNo(), book.getTitle(), book.getAuthor(), book.getDate() };
//			if(checkOutTableModel.getRowCount()<CHECK_OUT_LIMIT)
				checkOutTableModel.addRow(checkOutTableTuple);
//			else System.out.println("�뿩����� "+CHECK_OUT_LIMIT+"�� �ʰ��Ǿ����ϴ�.");
		}

	}
	// �뿩 ���� ��� ���̺��� ���� ����
	void removeCheckOut (JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();
		int bookSelectRow[] = checkOutTable.getSelectedRows(); // ���õ� ���� ��ȣ�� ������ ������ �迭����
		for(int i=bookSelectRow.length-1; 0<=i; i--) {
			checkOutTableModel.removeRow(bookSelectRow[i]);
		}
	}
	// �뿩 ��� �߰�
	String checkOut(String phoneNum, DefaultTableModel checkOutTableModel) {
		String resultMsg;
		
		Customer customer = MainData.customerC.searchCustomer(phoneNum);
		Date today = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String coDate = dateForm.format(today);

		try {
			for(int i=0; i<checkOutTableModel.getRowCount()-1; i++) {
				Book book = MainData.bookC.searchBookNo((String)checkOutTableModel.getValueAt(i, 0));
				CheckOut checkOut = new CheckOut(book.getBookNo(), book.getTitle(), customer.getIrum(), customer.getPhoneNum(), coDate, coDate);
				// �뿩 ���� ���� �� �ߺ� �� �ִ��� ��ȸ (�뿩 ��ư ���� Ŭ�� ����)
				if(getCheckOutAble(book.getBookNo())=="�뿩����") {
//					if(checkOutLimit(customer.getPhoneNum()))
//						return resultMsg = "�뿩 ���� ������ "+CHECK_OUT_LIMIT+"�� �ʰ��Ǿ����ϴ�.";
//					else
						MainData.addCheckOutInfo(checkOut);
				} else
					return resultMsg = "�̹� �뿩 ���� �����Դϴ�.";

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return resultMsg = "�뿩 ��� ���� �� ���� �߻�(error : ex2)";
		}
		
		return resultMsg = customer.getIrum()+"���� "+checkOutTableModel.getRowCount()+"�� �뿩�Ͽ����ϴ�.";
	}

	String getCheckOutAble(String bookNo) { // �뿩���ɿ��� ����
		String able = "�뿩����";

		if(getLastReturnDate(bookNo)!=null) {
			return able;
		}
		else return getReturnScheduledDate(bookNo)+" ����";
	}

	String getLastReturnDate(String bookNo) { // ������ �ݳ����� ����
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) {
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getReturnDate();
			}
		}
		return "�뿩��Ͼ���";
	}

	String getReturnScheduledDate(String bookNo) {
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) {
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getCiDate();
			}
		}
		return "�뿩��Ͼ���";
	}
//	boolean checkOutLimit(String phoneNum) {
//		int checkOutCnt=0;
//		for(int i=MainData.getCheckOutInfo().size()-1; 0<=i; i--) {
//			if(	MainData.getCheckOutInfo().get(i).getPhone().equals(phoneNum)
//					&& MainData.getCheckOutInfo().get(i).getReturnDate()==null)
//			{
//				checkOutCnt++;
//				if (checkOutCnt>CHECK_OUT_LIMIT)
//					return true;
//			}
//		}
//		return false;
//	}
}
