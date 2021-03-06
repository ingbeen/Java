

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SungjukExample {

	public static void main(String[] args) {
        JFrame frame = new JFrame("성적 프로그램");
        frame.setPreferredSize(new Dimension(440, 250));
        frame.setLocation(500, 400);
        Container contentPane = frame.getContentPane();
        
        // table
        String[] colNames = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
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
        panel1.add(new JLabel("학번"));
        panel1.add(text1);
        panel1.add(new JLabel("이름"));
        panel1.add(text2);
        panel1.add(new JLabel("국어"));
        panel1.add(text3);
        panel1.add(new JLabel("영어"));
        panel1.add(text4);
        panel1.add(new JLabel("수학"));
        panel1.add(text5);
        
        // panel2
        JPanel panel2 = new JPanel();
        JButton button1 = new JButton("추가");
        JButton button2 = new JButton("삭제");
        JButton button3 = new JButton("수정");
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

