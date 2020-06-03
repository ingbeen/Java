package chapter_19;

import java.awt.event.*;

import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener {
	JTextField text;
	JLabel label;
	
	ConfirmButtonActionListener(JTextField text, JLabel label){
		this.text = text;
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = text.getText();
		label.setText("Hello, " + name);
	}

}
