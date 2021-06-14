package section11;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchPanel extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField tfFindStr;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		add(getTfFindStr());
		add(getBtnNewButton());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel.setBounds(12, 10, 426, 36);
		}
		return lblNewLabel;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 93, 370, 76);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			String[] header = {"아이디","성명","연락처","주소"};
			DefaultTableModel model = new DefaultTableModel(header,3);
			table = new JTable(model);
			
		}
		return table;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setBounds(12, 51, 199, 22);
			tfFindStr.setColumns(10);
		}
		return tfFindStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberController mc = new MemberController();
					String findStr = tfFindStr.getText();
					List<Member> list = mc.search(findStr);
					
					DefaultTableModel model = 
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);//기존 표시된 데이터를 모두 삭제
					
					for(int i=0; i<list.size(); i++) {
						Member m = list.get(i);
						String[] data = {m.getId(), m.getIrum(), m.getPhone(), m.getAddress()};
						model.addRow(data);
					}
				}
			});
			btnNewButton.setFont(new Font("HY엽서L", Font.PLAIN, 15));
			btnNewButton.setBounds(223, 50, 97, 23);
		}
		return btnNewButton;
	}
}
