package chapter_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemExample9 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = reader.readLine();
			System.out.println("�Էµ� ���ڿ� : " + str);
		} catch(IOException e) {
			System.err.println("Ű���� �Է� ����");
		}
	}
}
