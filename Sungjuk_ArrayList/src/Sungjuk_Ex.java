import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sungjuk_Ex {

	public static void main(String[] args) {
		ArrayList<Sungjuk> s = new ArrayList<Sungjuk>();

		Scanner scan = new Scanner(System.in);

		// 프로그램 종료를 입력받을때까지 무한루프
		while (true) {
			int menu;
			printMenu();
			System.out.print("메뉴 선택 => ");
			// 정수 외의 값을 입력받을시 개행문자 비워주고 다시
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n다시 입력해주세요\n");
				scan.nextLine();
				continue;
			}

			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			// 메뉴 선택별 실행 메소드
			if (menu == 1) {
				menu_1(s);
			} else if (menu == 2) {
				if (s.size() == 0) {
					System.out.println("조회할 성적이 없습니다\n");
				} else {
					menu_2(s);
				}
			} else if (menu == 3) {
				menu_3(s);
			} else if (menu == 4) {
				Sungjuk.menu_4_input(s);
			} else if (menu == 5) {
				Sungjuk.menu_5_input(s);
			} else {
				System.out.println("잘못된 입력입니다\n");
			}
		}

	}

	// 메뉴 출력
	public static void printMenu() {
		System.out.println("*** 성적관리 ***");
		System.out.println("1. 성적정보 입력");
		System.out.println("2. 성적정보 출력");
		System.out.println("3. 성적정보 조회");
		System.out.println("4. 성적정보 수정");
		System.out.println("5. 성적정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	// 기초데이터 입력 및 계산
	public static void menu_1(ArrayList<Sungjuk> s) {
		s.add(new Sungjuk());
		s.get(s.size() - 1).input(s);
		if (s.get(s.size() - 1) == null) {
			return;
		}
		s.get(s.size() - 1).processc();
	}

	// 전체 데이터 출력
	public static void menu_2(ArrayList<Sungjuk> s) {
		System.out.printf("\t\t\t*** 성적표 ***\n");
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		// 출력할때마다 전체 학생평균을 초기화시켜서 재계산
		Sungjuk.tot_avg = 0;
		for (Sungjuk dat : s) {
			dat.all_output();
			dat.processc_tot();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t학생수 : %d\t\t전체평균 : %.2f\n", s.size(), Sungjuk.getTotal_avg(s));
		System.out.println();
	}

	// 학생별 데이터 조회
	public static void menu_3(ArrayList<Sungjuk> s) {
		// 입력받은 값으로 인덱스 값을 추출하여 출력
		int i = Sungjuk.menu_3_input(s);
		if (i == s.size() + 1) {
			return;
		}
		System.out.printf("\t\t*** %s의 성적표 ***\n", s.get(i).number);
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s.get(i).number, s.get(i).name, s.get(i).kor,
				s.get(i).eng, s.get(i).math, s.get(i).sum, s.get(i).average, s.get(i).rating);
		System.out.println("===========================================================");
		System.out.println();
	}

}
