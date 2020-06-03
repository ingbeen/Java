package chapter_19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoadActionListener implements ActionListener {
	JTextField text;
	ImagePanel imagePanel;

	LoadActionListener(JTextField text, ImagePanel imagePanel) {
		this.text = text;
		this.imagePanel = imagePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			imagePanel.setPath(text.getText());
			imagePanel.repaint();
	}
}
