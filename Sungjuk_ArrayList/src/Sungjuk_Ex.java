import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sungjuk_Ex {

	public static void main(String[] args) {
		ArrayList<Sungjuk> s = new ArrayList<Sungjuk>();

		Scanner scan = new Scanner(System.in);

		// ���α׷� ���Ḧ �Է¹��������� ���ѷ���
		while (true) {
			int menu;
			printMenu();
			System.out.print("�޴� ���� => ");
			// ���� ���� ���� �Է¹����� ���๮�� ����ְ� �ٽ�
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n�ٽ� �Է����ּ���\n");
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
				menu_1(s);
			} else if (menu == 2) {
				if (s.size() == 0) {
					System.out.println("��ȸ�� ������ �����ϴ�\n");
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
				System.out.println("�߸��� �Է��Դϴ�\n");
			}
		}

	}

	// �޴� ���
	public static void printMenu() {
		System.out.println("*** �������� ***");
		System.out.println("1. �������� �Է�");
		System.out.println("2. �������� ���");
		System.out.println("3. �������� ��ȸ");
		System.out.println("4. �������� ����");
		System.out.println("5. �������� ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}

	// ���ʵ����� �Է� �� ���
	public static void menu_1(ArrayList<Sungjuk> s) {
		s.add(new Sungjuk());
		s.get(s.size() - 1).input(s);
		if (s.get(s.size() - 1) == null) {
			return;
		}
		s.get(s.size() - 1).processc();
	}

	// ��ü ������ ���
	public static void menu_2(ArrayList<Sungjuk> s) {
		System.out.printf("\t\t\t*** ����ǥ ***\n");
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		// ����Ҷ����� ��ü �л������ �ʱ�ȭ���Ѽ� ����
		Sungjuk.tot_avg = 0;
		for (Sungjuk dat : s) {
			dat.all_output();
			dat.processc_tot();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t�л��� : %d\t\t��ü��� : %.2f\n", s.size(), Sungjuk.getTotal_avg(s));
		System.out.println();
	}

	// �л��� ������ ��ȸ
	public static void menu_3(ArrayList<Sungjuk> s) {
		// �Է¹��� ������ �ε��� ���� �����Ͽ� ���
		int i = Sungjuk.menu_3_input(s);
		if (i == s.size() + 1) {
			return;
		}
		System.out.printf("\t\t*** %s�� ����ǥ ***\n", s.get(i).number);
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s.get(i).number, s.get(i).name, s.get(i).kor,
				s.get(i).eng, s.get(i).math, s.get(i).sum, s.get(i).average, s.get(i).rating);
		System.out.println("===========================================================");
		System.out.println();
	}

}
