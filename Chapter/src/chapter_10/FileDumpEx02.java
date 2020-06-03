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
			System.out.println(args[0] + "������ �������� �ʽ��ϴ�.");
		} catch(IOException ioe) {
			System.out.println(args[0] + "������ ���� �� �����ϴ�.");
		} finally {
			try {
				in.close();
				out.close();
			} catch(Exception e){
			}
		}
	}

}
