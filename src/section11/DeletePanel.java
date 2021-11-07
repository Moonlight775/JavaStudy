package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class DeletePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tfFindStr;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JTextField tfId;
	private JTextField tfIrum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JTextField tfAddress;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_5;

	/**
	 * Create the panel.
	 */
	
	Member m;
	
	public DeletePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTfFindStr());
		add(getBtnNewButton());
		add(getSeparator());
		add(getLblNewLabel_1());
		add(getTfId());
		add(getTfIrum());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTfPhone());
		add(getLblNewLabel_4());
		add(getTfAddress());
		add(getBtnNewButton_1());
		add(getLblNewLabel_5());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.BLUE);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 311, 30);
		}
		return lblNewLabel;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setBounds(22, 59, 192, 21);
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
					m = mc.selectOne(findStr);
					if(m==null) {
						JOptionPane.showMessageDialog(DeletePanel.this, "찾는 데이터가 없슴");
					}else {
						tfId.setText(m.getId());
						tfIrum.setText(m.getIrum());
						tfPhone.setText(m.getPhone());
						tfAddress.setText(m.getAddress());
					}
					
				}
			});
			btnNewButton.setBounds(226, 58, 97, 23);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 96, 311, 2);
		}
		return separator;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(22, 111, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(91, 108, 167, 21);
		}
		return tfId;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setEditable(false);
			tfIrum.setColumns(10);
			tfIrum.setBounds(91, 133, 145, 21);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setBounds(22, 136, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(22, 165, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(91, 162, 116, 21);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(22, 190, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setEditable(false);
			tfAddress.setColumns(10);
			tfAddress.setBounds(91, 187, 290, 21);
		}
		return tfAddress;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(m==null) {
						JOptionPane.showMessageDialog(DeletePanel.this, "먼저 검색하세요");
					}else {
						MemberController mc = new MemberController();
						
						String msg = mc.delete(m);
						JOptionPane.showMessageDialog(DeletePanel.this, msg);
					}
				}
			});
			btnNewButton_1.setForeground(Color.YELLOW);
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setBounds(91, 218, 97, 23);
		}
		return btnNewButton_1;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\2-31 (\uAC15\uC0AC)\\Pictures\\\uC774\uBBF8\uC9C0 1.png"));
			lblNewLabel_5.setBounds(364, 10, 63, 65);
		}
		return lblNewLabel_5;
	}
}
