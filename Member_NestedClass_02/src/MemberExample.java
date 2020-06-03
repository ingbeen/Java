import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberExample {

	public static void main(String[] args) {
		MemberInner obj = new MemberInner();

		Scanner scan = new Scanner(System.in);

		while (true) {
			int menu;
			obj.printMenu();
			System.out.print("메뉴 선택 => ");
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n다시 입력해주세요\n");
				scan.nextLine();
				continue;
			}

			System.out.println();

			if (menu == 6) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else if (menu == 1) {
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
