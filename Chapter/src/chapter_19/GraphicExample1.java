package chapter_19;

import java.awt.*;

import javax.swing.*;

public class GraphicExample1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("�ڵ��� ���α׷�");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 300));
		Container contentPane = frame.getContentPane();
		CarDrawingPanel drawingPanel = new CarDrawingPanel();
		contentPane.add(drawingPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
