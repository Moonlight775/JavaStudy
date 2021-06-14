package section16.objectStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Element;
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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfServerIP;
	private JLabel lblNewLabel_1;
	private JTextField tfPort;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_3;
	private JTextField tfMsg;
	private JButton btnSend;

	/**
	 * Launch the application.
	 */
	
	ServerController sc;
	
	HTMLEditorKit editorKit;
	HTMLDocument document;
	StyleSheet styleSheet;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		setTitle("\uCC44\uD305\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTfServerIP());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfPort());
		contentPane.add(getBtnStart());
		contentPane.add(getBtnStop());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getTfMsg());
		contentPane.add(getBtnSend());
		
		try {
			InetAddress ia = InetAddress.getLocalHost();
			tfServerIP.setText(ia.getHostAddress());
			
			editorKit = new HTMLEditorKit();
			styleSheet = new StyleSheet();
			
			styleSheet.addRule("div{border:1px solid #0000ff;padding:5px; width:80%; margin-bottom:10px;}");
			styleSheet.addRule(".left{color:#ff0000}");
			styleSheet.addRule(".right{color:#0000ff}");
			
			editorKit.setStyleSheet(styleSheet);
			document = (HTMLDocument)editorKit.createDefaultDocument();
			
			textPane.setEditorKit(editorKit);
			textPane.setDocument(document);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			String msg = "<font color='red'>IP주소를 가져오는데 오류가 발생함</font>";
			Element root = document.getRootElements()[0];
			Element element = root.getElement(0);
			try {
				document.insertBeforeEnd(element, msg);
				textPane.setCaretPosition(document.getLength()); // 스크롤바를 하단으로 이동
			}catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Server IP");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfServerIP() {
		if (tfServerIP == null) {
			tfServerIP = new JTextField();
			tfServerIP.setBounds(70, 4, 98, 21);
			tfServerIP.setColumns(10);
		}
		return tfServerIP;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setBounds(185, 10, 41, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfPort() {
		if (tfPort == null) {
			tfPort = new JTextField();
			tfPort.setText("9292");
			tfPort.setBounds(229, 7, 76, 21);
			tfPort.setColumns(10);
		}
		return tfPort;
	}
	public JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("\uC11C\uBC84\uC2DC\uC791");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sc = new ServerController(ServerFrame.this);//Control부분과 UI부분이 나누어져있기 때문에 ServerFrame.this를 매개변수로 써줌
					Thread t = new Thread(sc); //병행처리를 하는 스레드. 병렬처리와 다르게 일의 순서가 존재(매우 짧은 시차 존재)
					t.start(); //스레드를 시작
				}
			});
			btnStart.setBounds(317, 6, 97, 23);
		}
		return btnStart;
	}
	public JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\uC11C\uBC84\uC885\uB8CC");
			btnStop.setBounds(418, 6, 97, 23);
		}
		return btnStop;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 35, 114, 149);
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
			scrollPane_1.setBounds(138, 35, 377, 149);
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
			//lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfMsg() {
		if (tfMsg == null) {
			tfMsg = new JTextField();
			tfMsg.setBounds(12, 194, 402, 21);
			tfMsg.setColumns(10);
		}
		return tfMsg;
	}
	public JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("\uC804\uC1A1");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//서버가 클라이언트에게 메시지 전송
					String msg = tfMsg.getText();
					Data data = new Data();
					data.setMsg(msg);
					data.setId("server");
					data.setCommand("msg");
					sc.sendAll(data);
					
					
				}
			});
			btnSend.setBounds(418, 194, 97, 23);
		}
		return btnSend;
	}
}
