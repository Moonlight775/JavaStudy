package section16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

public class ServerReceiveThread implements Runnable{
	ServerFrame sf;
	ServerController sc;
	BufferedWriter send;
	BufferedReader receive;
	Element root = null;
	Element element = null;
	
	public ServerReceiveThread(ServerFrame sf, Socket socket, ServerController sc) { //client socket 과 accept 1:1
		this.sf = sf;
		this.sc = sc;
		
		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			send = new BufferedWriter(osw);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			receive = new BufferedReader(isr);
			
			root = sf.document.getRootElements()[0];
			element = root.getElement(0);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	@Override //코드를 제대로 썼는지 확인해주는 기능
	public void run() {
		while(true) {
		try {
			String msg = receive.readLine(); //
			
//			StyledDocument doc = sf.getTextPane().getStyledDocument();
//			doc.insertString(doc.getLength(), msg, null);
			
			sc.sendAll(msg); //☆
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}
	}

	public void sendMsg(String msg) {
		try {
			send.write(msg);
			send.write("\n");
			send.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
