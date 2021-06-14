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
			serverSocket = new ServerSocket( Integer.parseInt(port) ); //serverSocket�� ����� ��
			msg = "<font color='blue'>������ ���۵Ǿ����ϴ�.</font>";
			
			
			sf.document.insertBeforeEnd(element, msg);
			sf.getTextPane().setCaretPosition(sf.document.getLength());
			
			sf.getBtnStart().setEnabled(true);
			sf.getBtnStart().setEnabled(false); //���� ���� ������ ��ư�� �ٽô� �� ������ ���ش�
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "<font color='red'>���� ������ ���� �߻�</font>";
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
			try {						//��blocking mode
				Socket socket = serverSocket.accept(); 
				String msg = "<div class='left'>���ο� Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�.</div>";
				sf.document.insertBeforeEnd(element, msg);
				sf.getTextPane().setCaretPosition(sf.document.getLength());
				
				ServerReceiveThread srt = 
					new ServerReceiveThread(sf, socket, ServerController.this);
				Thread t = new Thread(srt);
				t.start();
				
				clients.add(srt);
				
			}catch(Exception ex) {
				ex.printStackTrace();
				String msg = "<font color='red'>Ŭ���̾�Ʈ ���� �� �����߻�</font>";
				try{
					sf.getTextPane().setText(msg);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	
	//���ӵǾ� �ִ� ��� Ŭ���̾�Ʈ���� �޽��� ����
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
