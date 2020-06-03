import java.util.Scanner;

public class Sangpum {

	// 상품코드에 exit 입력하면 종료
	// 입력가능한 데이터 건수는 100으로 제한

	String code;
	String irum;
	int su;
	int dan;
	int price;
	String grade;
	
	static int cnt = 0;
	static int tot_price = 0;

	// 기초데이터 입력
	public void input(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		System.out.print("상품명 입력 => ");
		irum = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		System.out.println();
		
		for(int i = 0; i < cnt; i++) {
			if (s[i].code.equals(code)) {
				s[cnt] = null;
				System.out.println("입력오류 : 상품코드가 중복입니다");
				System.out.println();
			}
		}
	}

	// 기초데이터 계산
	public void processc() {
		price = su * dan;

		if (su >= 100) {
			grade = "우수";
		} else if (su >= 70) {
			grade = "보통";
		} else {
			grade = "분발";
		}
	}
	
	// 판매액 합계 계산
	public void processc_tot() {
		tot_price += price;
	}

	// 전체 데이터 출력
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", code, irum, su, dan, price, grade);
	}
	
	// 상품정보 조회
	public static int search(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("조회할 상품코드 입력 => ");
		choice = scan.next();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if (k) {
			System.out.println("존재하지 않는 상품코드입니다");
			System.out.println();
		}
		return i;
	}
	
	// 상품정보 수정
	public static void menu_4(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		int su;
		int dan;
		
		System.out.print("수정할 상품코드 입력 => ");
		choice = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				
				s[i].su = su;
				s[i].dan = dan;
				s[i].processc();
				
				System.out.println("판매정보 수정 성공");
				System.out.println();
				
				break;
			}
		}
		
		if (k) {
			System.out.println("존재하지 않는 상품코드입니다");
			System.out.println();
		}
	}
	
	// 상품정보 삭제
	public static void menu_5(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("삭제할 상품코드 입력 => ");
		choice = scan.next();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				for(int j = i + 1; j < cnt; j++) {
					s[i] = s[j];
					i++;
				}
				s[i] = null;
				System.out.println("판매정보 삭제 성공");
				System.out.println();
				cnt--;
				break;
			}
		}
		
		if (k) {
			System.out.println("존재하지 않는 상품코드입니다");
			System.out.println();
		}
	}

}
