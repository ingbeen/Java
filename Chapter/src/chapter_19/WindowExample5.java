package chapter_19;

import java.awt.*;

import javax.swing.*;

public class WindowExample5 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fruit Basket Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		contentPane.setLayout(layout);
		contentPane.add(new JButton("�ڹ�"));
		contentPane.add(new JButton("����������"));
		contentPane.add(new JButton("īǪġ��"));
		contentPane.add(new JButton("��縶��ƾ"));
		contentPane.add(new JButton("�ݷ����"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
