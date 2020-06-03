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
