package section16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

public class ClientController implements Runnable{
	ClientFrame cf;
	
	BufferedWriter send; //전송
	BufferedReader receive; //수신
	
	Element root;
	Element element;
	
	public ClientController(ClientFrame cf) {
		this.cf = cf;
		String ip = cf.getTfServerIP().getText();
		int port = Integer.parseInt(cf.getTfPort().getText());
		
		try {
		Socket socket = new Socket(ip, port);
		
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		send = new BufferedWriter(ow);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		receive = new BufferedReader(isr);
		
		root = cf.document.getRootElements()[0];
		element = root.getElement(0);
		
		sendMsg("문관영님이 접속하셨습니다."); //send는 buffer 기능을 가지고 있다.
		
		}catch (Exception e) {
			e.printStackTrace();
			String msg = "<front color = 'red'>서버 접속시 오류발생</font>";
			try{
				cf.document.insertBeforeEnd(element, msg);
				cf.getTextPane().setCaretPosition(cf.document.getLength());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			cf.getTextPane().setText(msg);
		}
	}
	
	public void sendMsg(String msg) {
		try {
			send.write(msg);
			send.write("\n");
			send.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		while(true) {
			try {
				String msg = receive.readLine();
				msg = String.format("<div class='left'>%s</div>", msg);
				cf.document.insertBeforeEnd(element, msg);
				cf.getTextPane().setCaretPosition(cf.document.getLength());
//				StyledDocument doc = cf.getTextPane().getStyledDocument();
//				doc.insertString(doc.getLength(), msg, null);
				
			}catch(Exception ex) {
				ex.getStackTrace();
				
			}
		}
		
		
	}

}
