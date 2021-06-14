package section16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Element;


public class ServerController implements Runnable{
	ServerFrame sf;
	ServerSocket serverSocket;
	List<ServerReceiveThread> clients;
	Element root = null;
	Element element = null;
	
	public ServerController(ServerFrame sf) {
		this.sf = sf;
		String port = sf.getTfPort().getText();
		String msg = "";
		clients = new ArrayList<ServerReceiveThread>();
		root = sf.document.getRootElements()[0];
		element = root.getElement(0);
		
		try {
			serverSocket = new ServerSocket( Integer.parseInt(port) ); //serverSocket을 만드는 것
			msg = "<font color='blue'>서버가 시작되었습니다.</font>";
			
			
			sf.document.insertBeforeEnd(element, msg);
			sf.getTextPane().setCaretPosition(sf.document.getLength());
			
			sf.getBtnStart().setEnabled(true);
			sf.getBtnStart().setEnabled(false); //서버 종료 전까지 버튼이 다시는 안 눌리게 해준다
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "<font color='red'>서버 시작중 오류 발생</font>";
			try{
				sf.document.insertBeforeEnd(element, msg);
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			sf.getTextPane().setCaretPosition(sf.document.getLength());
			
			sf.getBtnSend().setEnabled(false);
			sf.getBtnStart().setEnabled(true);
		}
	}
	
	@Override
	public void run() { 
		while(true) {
			try {						//↓blocking mode
				Socket socket = serverSocket.accept(); 
				String msg = "<div class='left'>새로운 클라이언트가 접속되었습니다.</div>";
				sf.document.insertBeforeEnd(element, msg);
				sf.getTextPane().setCaretPosition(sf.document.getLength());
				
				ServerReceiveThread srt = 
					new ServerReceiveThread(sf, socket, ServerController.this);
				Thread t = new Thread(srt);
				t.start();
				
				clients.add(srt);
				
			}catch(Exception ex) {
				ex.printStackTrace();
				String msg = "<font color='red'>클라이언트 접속 중 오류발생</font>";
				try{
					sf.getTextPane().setText(msg);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	
	//접속되어 있는 모든 클라이언트에게 메시지 전송
	public void sendAll(String msg) {
		try{
			for(ServerReceiveThread srt : clients) {
				srt.sendMsg(msg);
		}
			msg = String.format("<div class='right'>%s</div>", msg);
			sf.document.insertBeforeEnd(element, msg);
			sf.getTextPane().setCaretPosition(sf.document.getLength());
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	}	
}
