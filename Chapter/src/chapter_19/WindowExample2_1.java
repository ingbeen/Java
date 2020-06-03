package chapter_19;

import java.awt.*;

import javax.swing.*;

public class WindowExample2_1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Java Program");
		frame.setLocation(500, 400);
		frame.setPreferredSize(new Dimension(400, 170));
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(300, 100));
		JButton button = new JButton("»Æ¿Œ");
		button.setPreferredSize(new Dimension(100, 0));
		JLabel label = new JLabel("Hello");
		label.setPreferredSize(new Dimension(0, 50));
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);
		ConfirmButtonActionListener listener = new ConfirmButtonActionListener(text, label);
		button.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
