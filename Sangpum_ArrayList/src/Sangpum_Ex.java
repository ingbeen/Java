import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sangpum_Ex {

	// 최대 판매 건수
	final static int MAX = 100;

	public static void main(String[] args) {

		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		Scanner scan = new Scanner(System.in);

		while (true) {
			
			int menu;
			menuPrint();

			try {
				menu = scan.nextInt();
				System.out.println();
			} catch (InputMismatchException ime) {
				System.out.println("\n잘못된 값을 입력하셨습니다\n");
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else if (menu == 1) {
				menu_1(list);
			} else if (menu == 2) {
				if (list.size() > 0) {
					menu_2(list);
				} else {
					System.out.println("입력된 값이 없습니다");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(list);
			} else if (menu == 4) {
				Sangpum.menu_4(list);
			} else if (menu == 5) {
				Sangpum.menu_5(list);
			} else {
				System.out.println("잘못된 값을 입력하셨습니다\n");
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
	public static void menu_1(ArrayList<Sangpum> list) {
		Sangpum obj = new Sangpum();
		obj.input();
		for(Sangpum dat : list) {
			if (obj.code.equals(dat.code)) {
				System.out.println("입력오류 : 상품코드가 중복입니다");
				System.out.println();
				return;
			}
		}
		obj.processc();
		list.add(obj);
		System.out.println("판매정보 입력 성공\n");
	}

	// 전체 데이터 출력
	public static void menu_2(ArrayList<Sangpum> list) {
		System.out.printf("\t\t*** 판매 현황 ***\n");
		System.out.println("=============================================");
		System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
		System.out.println("=============================================");
		Sangpum.tot_price = 0;
		for (Sangpum dat : list) {
			dat.output();
			dat.processc_tot();
		}
		System.out.println("=============================================");
		System.out.printf("\t\t\t판매액 합계 : %d\n", Sangpum.tot_price);
		System.out.println();
	}
	
	// 상품정보 조회
	public static void menu_3(ArrayList<Sangpum> list) {
		int i = Sangpum.search(list);
		if (i == list.size()) {
			return;
		}
		System.out.printf("\t\t*** %s의 판매 현황 ***\n", list.get(i).code);
		System.out.println("=============================================");
		System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
		System.out.println("=============================================");
		list.get(i).output();
		System.out.println("=============================================");
		System.out.println();
	}

}
