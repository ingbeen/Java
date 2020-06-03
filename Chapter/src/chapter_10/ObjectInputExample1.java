package chapter_10;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ObjectInputExample1 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("output.dat"));
            while (true) {
                GregorianCalendar calendar = (GregorianCalendar) in.readObject();	
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int date = calendar.get(Calendar.DATE);
                System.out.println(year + "/" + month + "/" + date);
            }
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
        }
        finally {
            try {
                in.close();
            }          
            catch (Exception e) {
            }
        }

	}
}
