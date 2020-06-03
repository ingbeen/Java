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
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
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
