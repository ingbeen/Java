package chapter_10;

import java.io.*;

public class SungjukOutput {
    public static void main(String args[]) {
        ObjectOutputStream out = null;
        Sungjuk arr[] = new Sungjuk[3];
        
        try {
            out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
            for (int i = 0; i < arr.length; i++) {
            	arr[i] = new Sungjuk();
                arr[i].input();
                arr[i].process();
                out.writeObject(arr[i]);
            }
        }
        catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        }
        finally {
            try {
                out.close();
            }          
            catch (Exception e) {
            }
        }
    }
}
