package chapter_19;

import java.awt.*;

import javax.swing.*;

public class WindowExample3_1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		frame.setLocation(500, 400);
		frame.setPreferredSize(new Dimension(360, 300));
		Container contentPane = frame.getContentPane();
		JButton text1 = new JButton("��踻");
		text1.setPreferredSize(new Dimension(200, 50));
		JButton text2 = new JButton("����");
		text2.setPreferredSize(new Dimension(80, 200));
		JButton text3 = new JButton("�ڳ���");
		text3.setPreferredSize(new Dimension(80, 200));
		JButton text4 = new JButton("�ڻԼ�");
		JButton text5 = new JButton("���");
		text5.setPreferredSize(new Dimension(200, 50));
		contentPane.add(text1, BorderLayout.NORTH);
		contentPane.add(text2, BorderLayout.EAST);
		contentPane.add(text3, BorderLayout.WEST);
		contentPane.add(text4, BorderLayout.CENTER);
		contentPane.add(text5, BorderLayout.SOUTH );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
