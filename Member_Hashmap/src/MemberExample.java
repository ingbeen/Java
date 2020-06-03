import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MemberExample {

	public static void main(String[] args) {
		HashMap<String, Member> list = new HashMap<String, Member>();

		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int menu;
			printMenu();
			System.out.print("�޴� ���� => ");
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n�ٽ� �Է����ּ���\n");
				scan.nextLine();
				continue;
			}

			System.out.println();

			if (menu == 6) {
				System.out.println("�̿����ּż� �����մϴ�");
				break;
			} else if (menu == 1) {
				menu_1(list);
			} else if (menu == 2) {
				menu_2(list);
			} else if (menu == 3) {
				menu_3(list);
			} else if (menu == 4) {
				menu_4(list);
			} else if (menu == 5) {
				menu_5(list);
			} else {
				System.out.println("�߸��� �Է��Դϴ�\n");
			}

		}

	}

	public static void printMenu() {
		System.out.println("*** ȸ������ ***");
		System.out.println("1. ȸ������ �Է�");
		System.out.println("2. ȸ������ ���");
		System.out.println("3. ȸ������ ��ȸ");
		System.out.println("4. ȸ������ ����");
		System.out.println("5. ȸ������ ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}

	public static Member Search(HashMap<String, Member> list) {
		System.out.print("�̸� ���� => ");
		String choice = new Scanner(System.in).next();
		System.out.println();
		
		if(list.containsKey(choice)) {
			return list.get(choice);
		}
		System.out.println("�Է��Ͻ� �̸��� �����ϴ�\n");
		return null;
	}

	public static void menu_1(HashMap<String, Member> list) {
		Member obj1 = new Member();
		obj1.inputData();
		if(list.containsKey(obj1.irum)) {
			System.out.println("�̸����� �ߺ��Դϴ�\n");
			return;
		}
		list.put(obj1.irum, obj1);
		System.out.println("ȸ������ �Է� ����\n");
	}

	public static void menu_2(HashMap<String, Member> list) {
		if (list.size() == 0) {
			System.out.println("��°����� ȸ�������� �����ϴ�");
			return;
		}
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
		System.out.printf("====================================================================\n");
		Set<String> keyset = list.keySet();
		for (String key : keyset) {
			list.get(key).outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    ��ȸ���� : %d\n\n", list.size());
	}

	public static void menu_3(HashMap<String, Member> list) {
		Member obj = Search(list);
		if (obj == null) {
			return;
		}
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
		System.out.printf("====================================================================\n");
		obj.outputData();
		System.out.printf("====================================================================\n\n");
	}

	public static void menu_4(HashMap<String, Member> list) {
		Member obj = Search(list);
		if (obj == null) {
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� => ");
		obj.gender = scan.next();
		System.out.print("�̸��� �Է� => ");
		obj.email = scan.next();
		System.out.print("���̵� �Է� => ");
		obj.id = scan.next();
		System.out.print("�н����� �Է� => ");
		obj.passwd = scan.next();
		System.out.println();
		System.out.println("ȸ������ ���� ����\n");
	}

	public static void menu_5(HashMap<String, Member> list) {
		Member obj = Search(list);
		if (obj == null) {
			return;
		}
		System.out.println("ȸ������ ���� ����\n");
		list.remove(obj.irum);
	}

}
