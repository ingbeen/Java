package chapter_10;

import java.io.*;

public class FileDumpEx02 {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FileDump <filename>");
			return;
		} 
		FileInputStream in = null;
		FileWriter out = null;
		try {
			in = new FileInputStream(args[0]);
			out = new FileWriter(args[1]);
			while (true) {
				int num = in.read();
				if (num == -1) {
					break;
				}
				out.write((char) num);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println(args[0] + "파일이 존재하지 않습니다.");
		} catch(IOException ioe) {
			System.out.println(args[0] + "파일을 읽을 수 없습니다.");
		} finally {
			try {
				in.close();
				out.close();
			} catch(Exception e){
			}
		}
	}

}
