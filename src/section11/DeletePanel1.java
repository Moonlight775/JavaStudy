package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class DeletePanel1 extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tfFindStr;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField tfId;
	private JLabel lblNewLabel_2;
	private JTextField tfIrum;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JLabel lblNewLabel_4;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	Member m;
	
	public DeletePanel1() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTfFindStr());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getTfId());
		add(getLblNewLabel_2());
		add(getTfIrum());
		add(getLblNewLabel_3());
		add(getTfPhone());
		add(getTfAddress());
		add(getLblNewLabel_4());
		add(getBtnDelete());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
			lblNewLabel.setForeground(new Color(255, 0, 0));
			lblNewLabel.setBackground(new Color(64, 224, 208));
			lblNewLabel.setFont(new Font("HY엽서L", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 405, 37);
		}
		return lblNewLabel;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setColumns(10);
			tfFindStr.setBounds(12, 63, 195, 21);
		}
		return tfFindStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String findStr = tfFindStr.getText();
					MemberController mc = new MemberController();
					m = mc.selectOne(findStr); //m은 필드에 설정되어있다. 31행
					if(m==null) {
						JOptionPane.showMessageDialog(DeletePanel1.this, "찾는 데이터가 없음.");
					}else {
						tfId.setText(m.getId());
						tfIrum.setText(m.getIrum());
						tfPhone.setText(m.getPhone());
						tfAddress.setText(m.getAddress());
					}
					
					
					/*
					String findStr = tfFindStr.getText();
					MemberController mc = new MemberController();
					Member m = mc.selectOne(findStr);
					if(m==null) {
						JOptionPane.showMessageDialog(DeletePanel1.this, "찾는 데이터가 없습니다.");
					}else {
						tfId.setText(m.getId());
						tfIrum.setText(m.getIrum());
						tfPhone.setText(m.getPhone());
						tfAddress.setText(m.getAddress());
					}
					*/
				}
				
			});
			
			btnNewButton.setFont(new Font("HY엽서L", Font.PLAIN, 15));
			btnNewButton.setBounds(219, 62, 97, 23);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setFont(new Font("HY엽서L", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(12, 113, 57, 19);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(81, 111, 151, 21);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("HY엽서L", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(12, 142, 57, 19);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setEditable(false);
			tfIrum.setColumns(10);
			tfIrum.setBounds(81, 140, 116, 21);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setFont(new Font("HY엽서L", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(12, 171, 57, 19);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(81, 169, 183, 21);
		}
		return tfPhone;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setEditable(false);
			tfAddress.setColumns(10);
			tfAddress.setBounds(81, 200, 284, 21);
		}
		return tfAddress;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setFont(new Font("HY엽서L", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(12, 202, 57, 19);
		}
		return lblNewLabel_4;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("\uC0AD\uC81C");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					if(m==null){
						JOptionPane.showMessageDialog(DeletePanel1.this, "먼저 검색하세요.");
					}
					else if(result == JOptionPane.CLOSED_OPTION) {
					}
					else if(result == JOptionPane.YES_OPTION) {
						MemberController mc = new MemberController();
						String msg = mc.delete(m);
						JOptionPane.showMessageDialog(DeletePanel1.this, msg);
					}else {
						
					}
					
//					if(m==null) {
//						JOptionPane.showMessageDialog(DeletePanel1.this, "먼저 검색하세요.");
//					}
//					else {
//						MemberController mc = new MemberController();
//						String msg = mc.delete(m);
//						JOptionPane.showMessageDialog(DeletePanel1.this, msg);
//
//					}
					
					/*
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String address = tfAddress.getText();
					
					Member m = new Member(id, irum, phone, address);
					MemberController mc = new MemberController();
					String msg = mc.delete(m);
					JOptionPane.showMessageDialog(DeletePanel1.this, msg);
					*/
				}
			});
			btnDelete.setForeground(new Color(255, 0, 0));
			btnDelete.setBackground(new Color(240, 255, 255));
			btnDelete.setFont(new Font("HY엽서L", Font.PLAIN, 15));
			btnDelete.setBounds(81, 234, 97, 23);
		}
		return btnDelete;
	}
}
