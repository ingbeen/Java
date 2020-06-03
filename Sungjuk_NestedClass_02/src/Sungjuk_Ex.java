import java.util.Scanner;

public class Sungjuk_Ex {
	public static void main(String[] args) {
		SungjukAlloc obj = new SungjukAlloc();
		Scanner scan = new Scanner(System.in);

		// 프로그램 종료를 입력받을때까지 무한루프
		while (true) {
			int menu;
			obj.printMenu();
			System.out.print("메뉴 선택 => ");
			// 정수 외의 값을 입력받을시 개행문자 비워주고 다시
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				System.out.println("\n잘못된 입력입니다\n");
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
				obj.menu_1();
			} else if (menu == 2) {
				obj.menu_2();
			} else if (menu == 3) {
				obj.menu_3();
			} else if (menu == 4) {
				obj.menu_4();
			} else if (menu == 5) {
				obj.menu_5();
			} else {
				System.out.println("잘못된 입력입니다\n");
			}
		}
	}
}
