package chapter_19;

import java.awt.*;

import javax.swing.*;

public class ImageExample {

	public static void main(String[] args) {
		JFrame frame = new JFrame("이미지 로딩 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(500, 400));
		Container contentPane = frame.getContentPane();

		ImagePanel imagePane = new ImagePanel();
		contentPane.add(imagePane, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("이미지 로드");
		controlPanel.add(text);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);

		button.addActionListener(new LoadActionListener(text, imagePane));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
