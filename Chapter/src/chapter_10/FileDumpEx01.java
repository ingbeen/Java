package chapter_10;

import java.io.*;

public class FileDumpEx01 {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FileDump <filename>");
			return;
		} 
		FileInputStream in = null;
		try {
			in = new FileInputStream(args[0]); // 파일명을 읽어서 in에 저장
			while (true) {
				int num = in.read();
				if (num == -1) {
					break;
				}
				System.out.printf("%c", (char) num);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println(args[0] + "파일이 존재하지 않습니다.");
		} catch(IOException ioe) {
			System.out.println(args[0] + "파일을 읽을 수 없습니다.");
		} finally {
			try {
				in.close();
			} catch(Exception e){
			}
		}
	}

}
