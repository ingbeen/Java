package chapter_10;

import java.io.*;

public class SungjukInput {
	public static void main(String args[]) {
        ObjectInputStream in = null;
        try {
        	in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
            while (true) {
            	Sungjuk obj = (Sungjuk) in.readObject();	
            	obj.output();
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
