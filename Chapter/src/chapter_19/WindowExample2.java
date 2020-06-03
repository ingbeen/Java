package chapter_19;

import java.awt.*;

import javax.swing.*;

public class WindowExample2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Java Program");
		frame.setLocation(500, 400);
		frame.setPreferredSize(new Dimension(400, 80));
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello");
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);
		ConfirmButtonActionListener listener = new ConfirmButtonActionListener(text, label);
		// button을 누르면 listener(ConfirmButtonActionListener)의 actionPerformed메소드를 실행
		button.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
