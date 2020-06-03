import java.util.Scanner;

public class Sungjuk_Ex {
	
	// 최대 학생 수
	final static int MAX = 100;
	
	public static void main(String[] args) {

		// 학번에 exit 입력하면 종료
		// 입력가능한 데이터 건수는 100으로 제한
		// 마지막에 학생수와 전체평균 구하기
		
		Sungjuk[] s = new Sungjuk[MAX];
		
		Scanner scan = new Scanner(System.in);

		// 프로그램 종료를 입력받을때까지 무한루프
		while(true) {
			int menu;
			printMenu();
			System.out.print("메뉴 선택 => ");
			// 정수 외의 값을 입력받을시 개행문자 비워주고 다시
			try {
				menu = scan.nextInt();
			} catch(Exception e) {
				scan.nextLine();
				continue;
			}
			
			System.out.println();
			
			if(menu == 6) {
				System.out.println("The End...");
				break;
			}
			
			// 메뉴 선택별 실행 메소드
			if(menu == 1) {
				menu_1(s);
			} else if(menu == 2) {
				if (Sungjuk.cnt > 0) {
					menu_2(s);
				} else {
					System.out.println("조회할 성적이 없습니다");
					System.out.println();
				}
			} else if(menu == 3) {
				menu_3(s);
			} else if(menu == 4) {
				Sungjuk.menu_4_input(s);
			} else if(menu == 5) {
				Sungjuk.menu_5_input(s);
			} else {			
				System.out.println("잘못된 입력입니다");
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
	public static void menu_1(Sungjuk[] s) {
		s[Sungjuk.cnt] = new Sungjuk();
		s[Sungjuk.cnt].input(s);
		if(s[Sungjuk.cnt] == null) {
			return;
		}
		s[Sungjuk.cnt].processc();
		Sungjuk.cnt++;
	}

	// 전체 데이터 출력
	public static void menu_2(Sungjuk[] s) {
		System.out.printf("\t\t\t*** 성적표 ***\n");
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		// 출력할때마다 전체 학생평균을 초기화시켜서 재계산
		Sungjuk.tot_avg = 0;
		for (int i = 0; i < Sungjuk.cnt; i++) {
			s[i].all_output();
			s[i].processc_tot();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t학생수 : %d\t\t전체평균 : %.2f\n", Sungjuk.cnt, Sungjuk.getTotal_avg());
		System.out.println();
	}
	
	// 학생별 데이터 조회
	public static void menu_3(Sungjuk[] s) {
		// 입력받은 값으로 인덱스 값을 추출하여 출력
		int i = Sungjuk.menu_3_input(s);
		if(i == MAX+1) {
			return;
		}
		System.out.printf("\t\t*** %s의 성적표 ***\n", s[i].number);
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s[i].number, s[i].name, s[i].kor, s[i].eng, s[i].math, s[i].sum, s[i].average, s[i].rating);
		System.out.println("===========================================================");
		System.out.println();
	}
	
	

}
