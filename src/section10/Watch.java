package section10;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;

public class Watch extends JFrame{
	public Watch() {
		setTitle("�������� �ð�");
		setBounds(300,300,400,200);
		setVisible(true);
		
		JLabel label = new JLabel();
		label.setFont(new Font("���� ���", Font.BOLD, 45));
		add(label);
		
		Time time = new Time();
		
		Thread thread = new Thread( //������ (Ŭ����)
				new Runnable() { //Runnable()�� ������ (�������̽�)
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
		thread.start(); //�����·� �ִٰ� �ڱ� ���ʰ� ���� run()ȣ��
	}
	public static void main(String[] args) {
		new Watch();

	}

}
