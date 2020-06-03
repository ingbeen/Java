

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SungjukEvent implements ActionListener {
	JTable table;
	DrawingPanel drawingPanel;
	JTextField text1, text2, text3, text4, text5;

	SungjukEvent(JTable table, DrawingPanel drawingPanel, JTextField text1, JTextField text2, JTextField text3, JTextField text4,
			JTextField text5) {
		this.table = table;
		this.drawingPanel = drawingPanel;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent e�� ��ư�� ������ ����ִ�
		if (e.getActionCommand().equals("�߰�")) {
			add();
		} else if (e.getActionCommand().equals("����")) {
			remove();
		} else if (e.getActionCommand().equals("����")) {
			change();
		} else if (e.getActionCommand().equals("�׷������")) {
			graphicPrint();
		} else {
			return;
		}
	}

	void add() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		boolean check = false;
		if(text1.getText().trim().equals("")) {
			check = true;
			System.out.println("�й��� �Է����ֽʽÿ�");
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(text1.getText().trim())) {
				check = true;
				System.out.println("�й��� �ߺ��Դϴ�");
			}
		}
		if(check) {
			return;
		}
		String[] arr = new String[8];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();
		arr[3] = text4.getText();
		arr[4] = text5.getText();
		try {
			arr[5] = Sungjuk.tot(arr[2], arr[3], arr[4]);
			arr[6] = Sungjuk.avg(arr[5]);
			arr[7] = Sungjuk.grade(arr[6]);
		} catch(NumberFormatException nfe) {
			System.out.println("������ �Է����ֽʽÿ�");
			return;
		}
		model.addRow(arr);
		System.out.println("������ �Է� ����");
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		text5.setText("");
	}

	void remove() {
		int row = table.getSelectedRow();
		if (row == -1) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.println(model.getValueAt(row, 0) + " ���� ����");
		model.removeRow(row);
	}

	void change() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		boolean check = false;
		String choice = text1.getText();
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(choice)) {
				String[] arr = new String[6];
				arr[0] = text3.getText();
				arr[1] = text4.getText();
				arr[2] = text5.getText();
				arr[3] = Sungjuk.tot(arr[0], arr[1], arr[2]);
				arr[4] = Sungjuk.avg(arr[3]);
				arr[5] = Sungjuk.grade(arr[4]);
				model.setValueAt(arr[0], i, 2);
				model.setValueAt(arr[1], i, 3);
				model.setValueAt(arr[2], i, 4);
				model.setValueAt(arr[3], i, 5);
				model.setValueAt(arr[4], i, 6);
				model.setValueAt(arr[5], i, 7);
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				check = true;
				System.out.println(choice + " ���� ����");
			}
		}
		if(!check) {
			System.out.println("�й��� Ȯ�����ֽʽÿ�");
		}
	}
	
	void graphicPrint() {
		int row = table.getSelectedRow();
		if (row == -1) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int korean = Integer.parseInt((String) model.getValueAt(row, 2));
		int english = Integer.parseInt((String) model.getValueAt(row, 3));
		int math = Integer.parseInt((String) model.getValueAt(row, 4));
		int avg = (int) Math.round(Double.parseDouble((String) model.getValueAt(row, 6)));
		drawingPanel.setPoint(korean, english, math, avg);
		drawingPanel.repaint();
		System.out.println("�׷������ �Ϸ�");
	}

}
