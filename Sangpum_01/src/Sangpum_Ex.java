import java.util.Scanner;

public class Sangpum_Ex {

	// �ִ� �Ǹ� �Ǽ�
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
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�");
				System.out.println();
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("�̿����ּż� �����մϴ�");
				break;
			} else if (menu == 1) {
				menu_1(s);
			} else if (menu == 2) {
				if (Sangpum.cnt > 0) {
					menu_2(s);
				} else {
					System.out.println("�Էµ� ���� �����ϴ�");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(s);
			} else if (menu == 4) {
				Sangpum.menu_4(s);
			} else if (menu == 5) {
				Sangpum.menu_5(s);
			} else {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�");
				System.out.println();
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
	public static void menu_1(Sangpum[] s) {
		s[Sangpum.cnt] = new Sangpum();
		s[Sangpum.cnt].input(s);
		if (s[Sangpum.cnt] == null) {
			return;
		}
		s[Sangpum.cnt].processc();
		Sangpum.cnt++;
		System.out.println("�Ǹ����� �Է� ����");
		System.out.println();
	}

	// ��ü ������ ���
	public static void menu_2(Sangpum[] s) {
		System.out.printf("\t\t*** �Ǹ� ��Ȳ ***\n");
		System.out.println("=============================================");
		System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
		System.out.println("=============================================");
		Sangpum.tot_price = 0;
		for (int i = 0; i < Sangpum.cnt; i++) {
			s[i].output();
			s[i].processc_tot();
		}
		System.out.println("=============================================");
		System.out.printf("\t\t\t�Ǹž� �հ� : %d\n", Sangpum.tot_price);
		System.out.println();
	}
	
	// ��ǰ���� ��ȸ
	public static void menu_3(Sangpum[] s) {
		int i = Sangpum.search(s);
		System.out.printf("\t\t*** %s�� �Ǹ� ��Ȳ ***\n", s[i].code);
		System.out.println("=============================================");
		System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
		System.out.println("=============================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", s[i].code, s[i].irum, s[i].su, s[i].dan, s[i].price, s[i].grade);
		System.out.println("=============================================");
		System.out.println();
	}

}
