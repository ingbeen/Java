package chapter_10;

import java.io.*;
import java.util.GregorianCalendar;

public class ObjectOutputExample1 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output.dat"));
			out.writeObject(new GregorianCalendar(2006, 0 ,14));
			out.writeObject(new GregorianCalendar(2006, 0 ,15));
			out.writeObject(new GregorianCalendar(2006, 0 ,16));
		} catch(IOException ioe) {
			System.out.println("파일로 출력 할수 없습니다");
		} finally {
			try {
				out.close();
			} catch(Exception e) {
			}
		}
	}
}
