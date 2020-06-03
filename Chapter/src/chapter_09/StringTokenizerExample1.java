package chapter_09;
import java.util.StringTokenizer;

public class StringTokenizerExample1 {
    public static void main(String args[]) { 
        StringTokenizer stok = new StringTokenizer("»ç°ú=10|ÃÊÄÝ·¿=3|¼¤ÆäÀÎ=1", "=|", true); 
        while (stok.hasMoreTokens()) { 
            String token = stok.nextToken(); 
            if (token.equals("=")) {
            	System.out.print("\t"); 
            } else if (token.equals("|")) {
            	System.out.print("\n"); 
            } else {
            	System.out.print(token); 
            }
                 
        } 
    }
}
