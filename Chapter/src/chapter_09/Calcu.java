package chapter_09;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calcu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
  
		int result;
		String str = null, token_str = null;
		
	input_loop:	 
		while(true)
		{
			System.out.print("수식 입력 => ");
			str = scan.next().trim(); // trim():불필요한 공백 제거
		  
			StringTokenizer token = new StringTokenizer(str, "+-*/", true);
		  
			token_str = token.nextToken();  // 첫번째 토큰 읽음 
			if (input_check(token_str)) // input_check():토큰이 숫자인지 검사
			{
				System.out.println("수식 입력 오류!!!\n");  // 토큰이 숫자가 아님
				continue;  // 13행의 while(true)로 이동
			}
			
			result = Integer.parseInt(token_str); // 토큰을 숫자로 변환
			System.out.println(result);
		  
			while(token.hasMoreTokens())  // 토큰이 없을때까지 반복
			{
				token_str = token.nextToken(); // 짝수번째 토큰 읽음(연산자)
				char ch = token_str.charAt(0);  // 문자열에서 연산자 추출
		   
				if (token.hasMoreTokens())
					token_str = token.nextToken();  // 홀수번째 토큰을 읽음(숫자)
				else
				{
					System.out.println("수식 입력 오류!!!\n");  //연산자로 수식이 끝나는 경우
					continue input_loop;
				}
		   
				if (input_check(token_str)) // input_check():토큰이 숫자인지 검사
				{
					System.out.println("수식 입력 오류!!!\n");
					continue input_loop;
				}
				
				switch(ch)
				{
					case '+':
						result += Integer.parseInt(token_str);
						break;
					case '-':
					     result -= Integer.parseInt(token_str);
					     break;
					case '*':
						result *= Integer.parseInt(token_str);
						break;
					case '/':
						result /= Integer.parseInt(token_str); 
						break;
				} // switch
				System.out.println(result);
			} // while()
			
			break;
		} // while(true)
		System.out.println(str + "=" + result);
 	}
	 
	static boolean input_check(String str)
	{
		char ch;
		
		for (int i=0; i<str.length(); i++) //토큰을 전달 받아 문자열 길이만큼 한문자씩 검사
		{
			ch = str.charAt(i);  ////문자열에서 한문자씩 추출
			
			
			if (ch < '0' || ch > '9') // ch가 숫자인지 검사(유니코드로 비교)
				return true;  // 숫자 아닌 문자가 있음
		}
		return false;
	}
}