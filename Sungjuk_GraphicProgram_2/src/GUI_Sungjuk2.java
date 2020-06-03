import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI_Sungjuk2 {
	public static void main(String[] args) {
        JFrame frame = new JFrame("���� ���α׷�");
        frame.setPreferredSize(new Dimension(500, 580));
        frame.setLocation(380, 20);
        Container contentPane = frame.getContentPane();
        
        String colNames[] = { "�й�", "�̸�", "����", "����", "����", "����", "���", 
        		"���" };
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);  
        //���̺� ũ�� ����
        table.setPreferredScrollableViewportSize(new Dimension(400,150)); 

        int widths[] = {70, 70, 50, 50, 50, 50, 50, 50};
        for (int i=0; i<widths.length; i++) {
         TableColumn column = table.getColumnModel().getColumn(i);
         column.setPreferredWidth(widths[i]);
        }
        
        contentPane.add(new JScrollPane(table), BorderLayout.NORTH);
        
        DrawingPanel drawingPanel = new DrawingPanel();
        contentPane.add(drawingPanel, BorderLayout.CENTER);
        
        JTextField hakbun = new JTextField(5);
        JTextField irum = new JTextField(5);
        JTextField kor = new JTextField(3);
        JTextField eng = new JTextField(3);
        JTextField math = new JTextField(3);
        
        JButton button1 = new JButton("�߰�");
        JButton button2 = new JButton("����");
        JButton button3 = new JButton("����");
        JButton button4 = new JButton("�׷������");
        
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("�й�"));
        panel1.add(hakbun);
        panel1.add(new JLabel(" �̸�"));
        panel1.add(irum);
        panel1.add(new JLabel(" ����"));
        panel1.add(kor);
        panel1.add(new JLabel(" ����"));
        panel1.add(eng);
        panel1.add(new JLabel(" ����"));
        panel1.add(math);
        //panel1.setPreferredSize(new Dimension(100, 60));
        
        JPanel panel2 = new JPanel();
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(panel1, BorderLayout.CENTER);
        panel3.add(panel2, BorderLayout.SOUTH);
        
        contentPane.add(panel3, BorderLayout.SOUTH);
        
        button1.addActionListener(new EventActionListener(table, hakbun, irum, kor, eng, math));
        button2.addActionListener(new EventActionListener(table));
        button3.addActionListener(new EventActionListener(table, hakbun, kor, eng, math));
        button4.addActionListener(new EventActionListener(table, drawingPanel));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}