import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sangpum_Ex {

	// �ִ� �Ǹ� �Ǽ�
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
				System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("�̿����ּż� �����մϴ�");
				break;
			} else if (menu == 1) {
				menu_1(list);
			} else if (menu == 2) {
				if (list.size() > 0) {
					menu_2(list);
				} else {
					System.out.println("�Էµ� ���� �����ϴ�");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(list);
			} else if (menu == 4) {
				Sangpum.menu_4(list);
			} else if (menu == 5) {
				Sangpum.menu_5(list);
			} else {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
			}
		}
	}
	
	

	public static void menuPrint() {
		System.out.println("*** �Ǹ� ��Ȳ ***");
		System.out.println("1. �Ǹ����� �Է�");
		System.out.println("2. �Ǹ����� ���");
		System.out.println("3. �Ǹ����� ��ȸ");
		System.out.println("4. �Ǹ����� ����");
		System.out.println("5. �Ǹ����� ����");
		System.out.println("6. �Ǹ����� ����");
		System.out.println();
		System.out.print("�޴���ȣ �Է� => ");
	}

	// ���ʵ����� �Է� �� ���
	public static void menu_1(ArrayList<Sangpum> list) {
		Sangpum obj = new Sangpum();
		obj.input();
		for(Sangpum dat : list) {
			if (obj.code.equals(dat.code)) {
				System.out.println("�Է¿��� : ��ǰ�ڵ尡 �ߺ��Դϴ�");
				System.out.println();
				return;
			}
		}
		obj.processc();
		list.add(obj);
		System.out.println("�Ǹ����� �Է� ����\n");
	}

	// ��ü ������ ���
	public static void menu_2(ArrayList<Sangpum> list) {
		System.out.printf("\t\t*** �Ǹ� ��Ȳ ***\n");
		System.out.println("=============================================");
		System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
		System.out.println("=============================================");
		Sangpum.tot_price = 0;
		for (Sangpum dat : list) {
			dat.output();
			dat.processc_tot();
		}
		System.out.println("=============================================");
		System.out.printf("\t\t\t�Ǹž� �հ� : %d\n", Sangpum.tot_price);
		System.out.println();
	}
	
	// ��ǰ���� ��ȸ
	public static void menu_3(ArrayList<Sangpum> list) {
		int i = Sangpum.search(list);
		if (i == list.size()) {
			return;
		}
		System.out.printf("\t\t*** %s�� �Ǹ� ��Ȳ ***\n", list.get(i).code);
		System.out.println("=============================================");
		System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
		System.out.println("=============================================");
		list.get(i).output();
		System.out.println("=============================================");
		System.out.println();
	}

}
