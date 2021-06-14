package section16.objectStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfServerIP;
	private JLabel lblNewLabel_1;
	private JTextField tfPort;
	private JButton btnConnect;
	private JButton btnDisConnect;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JList list;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_3;
	private JTextField tfMsg;
	private JButton btnSend;

	/**
	 * Launch the application.
	 */
	
	ClientController cc;
	HTMLEditorKit editorKit;
	HTMLDocument document;
	StyleSheet styleSheet;
	private JLabel lblNewLabel_4;
	private JTextField tfId;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientFrame() {
		setTitle("\uCC44\uD305\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTfServerIP());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfPort());
		contentPane.add(getBtnConnect());
		contentPane.add(getBtnDisConnect());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getTfMsg());
		contentPane.add(getBtnSend());
		try {
			InetAddress ia = InetAddress.getLocalHost();
			tfServerIP.setText(ia.getHostAddress());
			
			editorKit = new HTMLEditorKit();
			styleSheet = new StyleSheet();
			
			styleSheet.addRule("div {border:1px solid #0000ff;padding:5px; width:80%; margin-bottom:10px;");
			styleSheet.addRule(".left{color:#ff0000");
			styleSheet.addRule(".right{color:#0000ff");
			
			editorKit.setStyleSheet(styleSheet);
			document = (HTMLDocument)editorKit.createDefaultDocument();
			
			textPane.setEditorKit(editorKit);
			textPane.setDocument(document);
					
		}catch(Exception ex) {
			ex.printStackTrace();
			String msg = "<font color ='red'>IP주소를 가져오는데 실패하였습니다.</font>";
			textPane.setText(msg);
		}
		
		btnDisConnect.setEnabled(false);
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTfId());
	}
	

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("IP");
			lblNewLabel.setBounds(12, 10, 35, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfServerIP() {
		if (tfServerIP == null) {
			tfServerIP = new JTextField();
			tfServerIP.setBounds(44, 7, 116, 21);
			tfServerIP.setColumns(10);
		}
		return tfServerIP;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setBounds(172, 10, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfPort() {
		if (tfPort == null) {
			tfPort = new JTextField();
			tfPort.setText("9292");
			tfPort.setBounds(217, 7, 65, 21);
			tfPort.setColumns(10);
		}
		return tfPort;
	}
	public JButton getBtnConnect() {
		if (btnConnect == null) {
			btnConnect = new JButton("\uC811\uC18D");
			btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cc = new ClientController(ClientFrame.this);
						Thread t = new Thread(cc);
						t.start();
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
				}
			});
			btnConnect.setBounds(469, 6, 97, 23);
		}
		return btnConnect;
	}
	public JButton getBtnDisConnect() {
		if (btnDisConnect == null) {
			btnDisConnect = new JButton("\uD574\uC81C");
			btnDisConnect.setBounds(578, 6, 97, 23);
		}
		return btnDisConnect;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 46, 145, 189);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
		}
		return scrollPane;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(182, 46, 493, 189);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
		}
		return textPane;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC2DC\uC9C0");
		}
		return lblNewLabel_3;
	}
	public JTextField getTfMsg() {
		if (tfMsg == null) {
			tfMsg = new JTextField();
			tfMsg.setBounds(12, 245, 554, 21);
			tfMsg.setColumns(10);
		}
		return tfMsg;
	}
	public JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("\uC804\uC1A1");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String msg = tfMsg.getText();
					Data data = new Data();
					data.setId(tfId.getText());
					data.setCommand("msg");
					data.setMsg(msg);
					
					cc.sendMsg(data);
					
//					String msg = "<div>" + tfMsg.getText() + "</div>";
//					msg = String.format("<div>%s</div>", tfMsg.getText());
//					cc.sendMsg(msg);
				}
			});
			btnSend.setBounds(578, 244, 97, 23);
		}
		return btnSend;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_4.setBounds(294, 10, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(341, 7, 116, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
}
