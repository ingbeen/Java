package chapter_09;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String num;
		String token;
		
		input:
		while (true) {
			int sqnc = 0, result = 0;
			System.out.print("수식 입력 => ");
			num = scan.next().trim();
			
			StringTokenizer str = new StringTokenizer(num, "+-/*", true);
			
			while (str.hasMoreTokens()) {
				
	            token = str.nextToken();
	            
	            try {
	            	if (sqnc == 0) {
	            		char check = token.charAt(0);
	                	if('0' <= check && check <= '9') {
	                		int check2 = Integer.parseInt(token); 
	                		result = check2;
	                		sqnc++;
	        			} else {
	        				System.out.println("첫번째 자리 수식 입력 오류!!");
	        				System.out.println();
	        				continue input;
	        			}
	                } else if(sqnc == 1) {
	                	char check = token.charAt(0);
	                	token = str.nextToken();
	                	int check2 = Integer.parseInt(token); 
	                	if(check == '+') {
	                		result += check2;
	        			} else if(check == '-') {
	                		result -= check2;
	        			} else if(check == '/') {
	                 		result /= check2;
	         			} else if(check == '*') {
	                 		result *= check2;
	         			} else {
	         				System.out.println("수식 입력 오류!!");
	         				System.out.println();
	         				continue input;
	         			}
	                }
	            } catch(java.lang.Exception e) {
	            	System.out.println("수식 입력 오류!!");
	            	System.out.println();
	            	continue input;
	            }
	        }
			System.out.println(num + "=" + result);
			break;
		}

	}

}
