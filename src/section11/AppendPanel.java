package section11;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppendPanel extends JPanel {
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfId;
	private JLabel lblNewLabel_2;
	private JTextField tfIrum;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JTextField tfAddress;

	/**
	 * Create the panel.
	 */
	public AppendPanel() {
		setLayout(null);
		add(getBtnNewButton());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getTfId());
		add(getLblNewLabel_2());
		add(getTfIrum());
		add(getLblNewLabel_3());
		add(getTfPhone());
		add(getLblNewLabel_4());
		add(getTfAddress());

	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = tfId.getText();
					String mIrum = tfIrum.getText();
					String mPhone = tfPhone.getText();
					String mAddress = tfAddress.getText();
					
					Member m = new Member(mId, mIrum, mPhone, mAddress);
					MemberController mc = new MemberController();
					String msg = mc.append(m);
					JOptionPane.showMessageDialog(AppendPanel.this, msg);
				}
			});
			btnNewButton.setBounds(81, 179, 97, 23);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uCD94\uAC00");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.PINK);
			lblNewLabel.setFont(new Font("????", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 428, 35);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(12, 72, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(81, 69, 167, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setBounds(12, 97, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setBounds(81, 94, 145, 21);
			tfIrum.setColumns(10);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(12, 126, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(81, 123, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(12, 151, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setBounds(81, 148, 290, 21);
			tfAddress.setColumns(10);
		}
		return tfAddress;
	}
}
