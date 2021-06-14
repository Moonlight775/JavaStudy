package section10;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;

public class Watch extends JFrame{
	public Watch() {
		setTitle("내가만든 시계");
		setBounds(300,300,400,200);
		setVisible(true);
		
		JLabel label = new JLabel();
		label.setFont(new Font("맑은 고딕", Font.BOLD, 45));
		add(label);
		
		Time time = new Time();
		
		Thread thread = new Thread( //스레드 (클래스)
				new Runnable() { //Runnable()도 스레드 (인터페이스)
					public void run() {
						while(true) {
							try {
								String now = time.getTime();
								label.setText(now);
								Thread.sleep(1);
							}catch(Exception ex) {}
							
						}
					}
				}
			);
		thread.start(); //대기상태로 있다가 자기 차례가 오면 run()호출
	}
	public static void main(String[] args) {
		new Watch();

	}

}
