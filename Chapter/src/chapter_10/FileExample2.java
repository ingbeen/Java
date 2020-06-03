package chapter_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample2 {
	public static void main(String[] args) {
		FileWriter writer = null;
		try {
			File file = File.createTempFile("tmp", ".txt", new File("C:\\temp"));
			writer = new FileWriter(file);
			writer.write('��');
			writer.write('��');
		} catch(IOException ioe) {
			System.out.println("�ӽ� ���Ͽ� �� �� �����ϴ�");
		} finally {
			try {
				writer.close();
			} catch(Exception e) {
				
			}
		}
	}
}
