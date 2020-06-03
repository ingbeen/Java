package chapter_10;

import java.io.File;

public class FileEx01 {
	public static void main(String[] args) {
		File file = new File("test.txt");
		try {
			file.createNewFile();
		} catch(Exception e) {
			
		}
	}
}
