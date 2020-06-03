import java.util.Scanner;

public class Sangpum_Ex {

	// 최대 판매 건수
	final static int MAX = 100;

	public static void main(String[] args) {

		Sangpum[] s = new Sangpum[MAX];
		Scanner scan = new Scanner(System.in);

		while (true) {
			
			int menu;
			menuPrint();

			try {
				menu = scan.nextInt();
				System.out.println();
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다");
				System.out.println();
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else if (menu == 1) {
				menu_1(s);
			} else if (menu == 2) {
				if (Sangpum.cnt > 0) {
					menu_2(s);
				} else {
					System.out.println("입력된 값이 없습니다");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(s);
			} else if (menu == 4) {
				Sangpum.menu_4(s);
			} else if (menu == 5) {
				Sangpum.menu_5(s);
			} else {
				System.out.println("잘못된 값을 입력하셨습니다");
				System.out.println();
			}
		}
	}
	
	

	public static void menuPrint() {
		System.out.println("*** 판매 현황 ***");
		System.out.println("1. 판매정보 입력");
		System.out.println("2. 판매정보 출력");
		System.out.println("3. 판매정보 조회");
		System.out.println("4. 판매정보 수정");
		System.out.println("5. 판매정보 삭제");
		System.out.println("6. 판매정보 종료");
		System.out.println();
		System.out.print("메뉴번호 입력 => ");
	}

	// 기초데이터 입력 및 계산
	public static void menu_1(Sangpum[] s) {
		s[Sangpum.cnt] = new Sangpum();
		s[Sangpum.cnt].input(s);
		if (s[Sangpum.cnt] == null) {
			return;
		}
		s[Sangpum.cnt].processc();
		Sangpum.cnt++;
		System.out.println("판매정보 입력 성공");
		System.out.println();
	}

	// 전체 데이터 출력
	public static void menu_2(Sangpum[] s) {
		System.out.printf("\t\t*** 판매 현황 ***\n");
		System.out.println("=============================================");
		System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
		System.out.println("=============================================");
		Sangpum.tot_price = 0;
		for (int i = 0; i < Sangpum.cnt; i++) {
			s[i].output();
			s[i].processc_tot();
		}
		System.out.println("=============================================");
		System.out.printf("\t\t\t판매액 합계 : %d\n", Sangpum.tot_price);
		System.out.println();
	}
	
	// 상품정보 조회
	public static void menu_3(Sangpum[] s) {
		int i = Sangpum.search(s);
		System.out.printf("\t\t*** %s의 판매 현황 ***\n", s[i].code);
		System.out.println("=============================================");
		System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
		System.out.println("=============================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", s[i].code, s[i].irum, s[i].su, s[i].dan, s[i].price, s[i].grade);
		System.out.println("=============================================");
		System.out.println();
	}

}
