package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tfFindStr;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JTextField tfId;
	private JTextField tfIrum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JTextField tfAddress;

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTfFindStr());
		add(getBtnNewButton());
		add(getSeparator());
		add(getLblNewLabel_1());
		add(getBtnNewButton_1());
		add(getTfId());
		add(getTfIrum());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTfPhone());
		add(getLblNewLabel_4());
		add(getTfAddress());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC218\uC815");
			lblNewLabel.setBackground(new Color(221, 160, 221));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setFont(new Font("HY¿±¼­L", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 426, 30);
		}
		return lblNewLabel;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setBounds(12, 47, 195, 21);
			tfFindStr.setColumns(10);
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
					Member m = mc.selectOne(findStr);
					if(m==null) {
						JOptionPane.showMessageDialog(UpdatePanel.this, "Ã£´Â µ¥ÀÌÅÍ°¡ ¾ø½À´Ï´Ù.");
					}else {
						tfId.setText(m.getId());
						tfIrum.setText(m.getIrum());
						tfPhone.setText(m.getPhone());
						tfAddress.setText(m.getAddress());
						
					}
					
				}
			});
			btnNewButton.setFont(new Font("HY¿±¼­L", Font.PLAIN, 15));
			btnNewButton.setBounds(219, 46, 105, 23);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 78, 327, 2);
		}
		return separator;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(12, 97, 57, 19);
		}
		return lblNewLabel_1;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String address = tfAddress.getText();
					
					Member m = new Member(id, irum, phone, address);	  //¼³Á¤
					MemberController mc = new MemberController();
					String msg = mc.update(m);							  //½ÇÇà
					JOptionPane.showMessageDialog(UpdatePanel.this, msg); //°á°ú Ç¥½Ã
					
					
				}
			});
			btnNewButton_1.setFont(new Font("HY¿±¼­L", Font.PLAIN, 15));
			btnNewButton_1.setBounds(81, 218, 97, 23);
		}
		return btnNewButton_1;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(81, 95, 151, 21);
		}
		return tfId;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(81, 124, 116, 21);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(12, 126, 57, 19);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(12, 155, 57, 19);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(81, 153, 183, 21);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(12, 186, 57, 19);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(81, 184, 284, 21);
		}
		return tfAddress;
	}
}
