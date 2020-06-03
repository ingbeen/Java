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
			System.out.println("���Ϸ� ��� �Ҽ� �����ϴ�");
		} finally {
			try {
				out.close();
			} catch(Exception e) {
			}
		}
	}
}
