package chapter_09;
import java.util.Scanner;

public class Jumin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num;
		
		while(true) {
			
			while(true) {
				// 주민번호 입력
				System.out.print("주민번호 입력 => ");
				num = scan.next();
				
				// 오류 검사
				if(!input_check(num)) {
					break;
				}
				
			}
			
			// 주민번호 합계
			int numsum = 0, j = 0;
			int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
			for(int i = 0; i < num.length() - 2; i++) {
				if (j == 6) {
					i--;
					j++;
					continue;
				} else {
					numsum += Character.getNumericValue(num.charAt(j)) * value[i];
					j++;
				}
			}
			
			// 주민번호 체크값 계산
			int check;
			if(11 - (numsum % 11) == 11) {
				check = 1;
			} else if(11 - (numsum % 11) == 10) {
				check = 0;
			} else {
				check = 11 - (numsum % 11);
			}
			
			// 최종 출력
			if(Character.getNumericValue(num.charAt(13)) == check) {
				System.out.println(num.concat("(O)"));
				break;
			} else {
				System.out.println(num.concat("(X)"));
				break;
			}
		}
		
	}
	
	public static boolean input_check(String num) {
		// 14자리 검사
		if (num.length() != 14) {
			System.out.println("하이픈 기호 포함 14자리로 입력해주세요");
			System.out.println();
			return true;
		}
		
		// 한자리씩 추출하여 검색
		for(int i = 0; i < num.length(); i++) {
			
			// 한자리씩 추출
			char check = num.charAt(i);
		
			// 하이픈 기호 검사
			if(i == 6) {
				if (check != '-') {
					System.out.println("\"123456-1234567\"형식으로 다시 입력해주세요");
					System.out.println();
					return true;
				}
			} else if(i == 7) {
				// 성별 검사
				if (!(49 <= check && check <= 52)) {
					System.out.println("뒷자리 첫번째 번호는 1 ~ 4 사이값을 입력해주세요");
					System.out.println();
					return true;
				}
			} else {
				// 정수 검사
				if (!(48 <= check && check <= 57)) {
					System.out.println("1 ~ 9 사이값을 입력해주세요");
					System.out.println();
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}
}
