import java.util.Scanner;

public class Sungjuk_Ex {
	public static void main(String[] args) {
		SungjukAlloc obj = new SungjukAlloc();
		Scanner scan = new Scanner(System.in);

		// ���α׷� ���Ḧ �Է¹��������� ���ѷ���
		while (true) {
			int menu;
			obj.printMenu();
			System.out.print("�޴� ���� => ");
			// ���� ���� ���� �Է¹����� ���๮�� ����ְ� �ٽ�
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				System.out.println("\n�߸��� �Է��Դϴ�\n");
				scan.nextLine();
				continue;
			}

			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			// �޴� ���ú� ���� �޼ҵ�
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
				System.out.println("�߸��� �Է��Դϴ�\n");
			}
		}
	}
}
