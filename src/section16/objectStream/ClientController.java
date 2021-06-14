package section16.objectStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.Element;

public class ClientController implements Runnable{
	ClientFrame cf;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	Element root;
	Element element;
	
	public ClientController(ClientFrame cf) {
		this.cf = cf;
		String ip = cf.getTfServerIP().getText();
		int port = Integer.parseInt(cf.getTfPort().getText());
		
		try {
		Socket socket = new Socket(ip, port);
		
		OutputStream os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		
		InputStream is = socket.getInputStream();
		ois = new ObjectInputStream(is);
		
		root = cf.document.getRootElements()[0];
		element = root.getElement(0);
		
		Data data = new Data();
		data.setId(cf.getTfId().getText());
		data.setCommand("login");
		data.setMsg("�α��� �Ͽ����ϴ�.");
		sendMsg(data); //send�� buffer ����� ������ �ִ�.
		
		}catch (Exception e) {
			e.printStackTrace();
			String msg = "<front color = 'red'>���� ���ӽ� �����߻�</font>";
			try{
				cf.document.insertBeforeEnd(element, msg);
				cf.getTextPane().setCaretPosition(cf.document.getLength());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			cf.getTextPane().setText(msg);
		}
	}
	
	public void sendMsg(Data data) {
		try {
			oos.writeObject(data);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		while(true) {
			try {
				Data data = (Data)ois.readObject();
				
				String msg = "";
				if(data.getId().equals(cf.getTfId().getText())) {	
					msg = String.format("<div class='%s'><b>%s:</b><br/>%s</div>","right", data.getId(), data.getMsg());
				}else {
					msg = String.format("<div class='%s'><b>%s:</b><br/>%s</div>","left", data.getId(), data.getMsg());
				}
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
