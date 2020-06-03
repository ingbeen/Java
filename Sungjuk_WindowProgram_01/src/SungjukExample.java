

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SungjukExample {

	public static void main(String[] args) {
        JFrame frame = new JFrame("���� ���α׷�");
        frame.setPreferredSize(new Dimension(440, 250));
        frame.setLocation(500, 400);
        Container contentPane = frame.getContentPane();
        
        // table
        String[] colNames = {"�й�", "�̸�", "����", "����", "����", "����", "���", "���"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);
        int widths[] = {70, 70, 50, 50, 50, 50, 50, 50};
        for (int i=0; i<widths.length; i++) {
         TableColumn column = table.getColumnModel().getColumn(i);
         column.setPreferredWidth(widths[i]);
        }
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER); 
        
        // panel1
        JPanel panel1 = new JPanel();
        JTextField text1 = new JTextField(5);
        JTextField text2 = new JTextField(5);
        JTextField text3 = new JTextField(3);
        JTextField text4 = new JTextField(3);
        JTextField text5 = new JTextField(3);
        panel1.add(new JLabel("�й�"));
        panel1.add(text1);
        panel1.add(new JLabel("�̸�"));
        panel1.add(text2);
        panel1.add(new JLabel("����"));
        panel1.add(text3);
        panel1.add(new JLabel("����"));
        panel1.add(text4);
        panel1.add(new JLabel("����"));
        panel1.add(text5);
        
        // panel2
        JPanel panel2 = new JPanel();
        JButton button1 = new JButton("�߰�");
        JButton button2 = new JButton("����");
        JButton button3 = new JButton("����");
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        
        // panel3
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(panel1, BorderLayout.CENTER);
        panel3.add(panel2, BorderLayout.SOUTH);
        contentPane.add(panel3, BorderLayout.SOUTH);
        
        button1.addActionListener(new SungjukEvent(table, text1, text2, text3, text4, text5));
        button2.addActionListener(new SungjukEvent(table, text1, text2, text3, text4, text5));
        button3.addActionListener(new SungjukEvent(table, text1, text2, text3, text4, text5));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}

