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
import javax.swing.text.StyledDocument;

public class ServerReceiveThread implements Runnable{
	ServerFrame sf;
	ServerController sc;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	Element root = null;
	Element element = null;
	
	public ServerReceiveThread(ServerFrame sf, Socket socket, ServerController sc) { //client socket 과 accept 1:1
		this.sf = sf;
		this.sc = sc;
		
		try {
			OutputStream os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			
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
			Data data = (Data)ois.readObject(); //
			
//			StyledDocument doc = sf.getTextPane().getStyledDocument();
//			doc.insertString(doc.getLength(), msg, null);
			
			sc.sendAll(data); //☆
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
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
	
}
