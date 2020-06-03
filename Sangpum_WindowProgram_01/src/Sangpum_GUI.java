import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sangpum_GUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("��ǰ���� ���α׷�");
		frame.setLocation(500, 400);
		frame.setPreferredSize(new Dimension(500, 300));
		Container contentPane = frame.getContentPane();
		
		// table
		String[] colNames = {"��ǰ�ڵ�", "��ǰ��", "����", "�ܰ�", "�ݾ�"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// text_pane1
		JTextField code_field = new JTextField(7);
		JTextField irum_field = new JTextField(7);
		JTextField su_field = new JTextField(4);
		JTextField dan_field = new JTextField(6);
		JPanel text_panel = new JPanel();
		text_panel.add(new JLabel("��ǰ�ڵ�"));
		text_panel.add(code_field);
		text_panel.add(new JLabel("��ǰ��"));
		text_panel.add(irum_field);
		text_panel.add(new JLabel("����"));
		text_panel.add(su_field);
		text_panel.add(new JLabel("�ܰ�"));
		text_panel.add(dan_field);
		
		// button_pane1
		JButton insert_button = new JButton("�߰�");
		JButton delete_button = new JButton("����");
		JButton update_button = new JButton("����");
		JPanel button_panel = new JPanel();
		button_panel.add(insert_button);
		button_panel.add(delete_button);
		button_panel.add(update_button);
		
		// south_panel
		JPanel south_panel = new JPanel(new BorderLayout());
		south_panel.add(text_panel, BorderLayout.CENTER);
		south_panel.add(button_panel, BorderLayout.SOUTH);
		contentPane.add(south_panel, BorderLayout.SOUTH);
		
		// Action
		insert_button.addActionListener(new EventActionListener(table, code_field, irum_field, su_field, dan_field));
		delete_button.addActionListener(new EventActionListener(table, code_field, irum_field, su_field, dan_field));
		update_button.addActionListener(new EventActionListener(table, code_field, irum_field, su_field, dan_field));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
