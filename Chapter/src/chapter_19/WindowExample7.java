package chapter_19;

import java.awt.*;

import javax.swing.*;

public class WindowExample7 {

	public static void main(String[] args) {
        JFrame frame = new JFrame("참가자 명단 프로그램");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setLocation(500, 400);
        Container contentPane = frame.getContentPane();
        String[] colNames = {"이름", "나이", "성별"};
        Object[][] data = {
        		{"김철수", 24, '남'},
        		{"이순희", 21, '여'},
        		{"박지영", 26, '여'},
        };
        JTable table = new JTable(data, colNames);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JButton button = new JButton("출력");
        // addActionListener() : PrintActionListener의 actionPerformed메소드를 실행하겠다
        // PrintActionListener() : table을 이용해서 이벤트를 실행하겠다
        button.addActionListener(new PrintActionListener(table));
        contentPane.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

	}
}
