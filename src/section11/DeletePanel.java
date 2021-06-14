package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeletePanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public DeletePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getTextField());
		add(getLblNewLabel_2());
		add(getTextField_1());
		add(getLblNewLabel_3());
		add(getTextField_2());
		add(getBtnNewButton());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
			lblNewLabel.setFont(new Font("HY¿±¼­L", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 408, 36);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(12, 56, 68, 23);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(142, 56, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_2.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(12, 89, 110, 23);
		}
		return lblNewLabel_2;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(142, 91, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
			lblNewLabel_3.setFont(new Font("HY¿±¼­L", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(12, 122, 116, 28);
		}
		return lblNewLabel_3;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(142, 126, 116, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.setBounds(183, 180, 97, 23);
		}
		return btnNewButton;
	}
}
