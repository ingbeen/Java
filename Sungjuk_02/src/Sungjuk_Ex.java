import java.util.Scanner;

public class Sungjuk_Ex {
	
	// �ִ� �л� ��
	final static int MAX = 100;
	
	public static void main(String[] args) {

		// �й��� exit �Է��ϸ� ����
		// �Է°����� ������ �Ǽ��� 100���� ����
		// �������� �л����� ��ü��� ���ϱ�
		
		Sungjuk[] s = new Sungjuk[MAX];
		
		Scanner scan = new Scanner(System.in);

		// ���α׷� ���Ḧ �Է¹��������� ���ѷ���
		while(true) {
			int menu;
			printMenu();
			System.out.print("�޴� ���� => ");
			// ���� ���� ���� �Է¹����� ���๮�� ����ְ� �ٽ�
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
			
			// �޴� ���ú� ���� �޼ҵ�
			if(menu == 1) {
				menu_1(s);
			} else if(menu == 2) {
				if (Sungjuk.cnt > 0) {
					menu_2(s);
				} else {
					System.out.println("��ȸ�� ������ �����ϴ�");
					System.out.println();
				}
			} else if(menu == 3) {
				menu_3(s);
			} else if(menu == 4) {
				Sungjuk.menu_4_input(s);
			} else if(menu == 5) {
				Sungjuk.menu_5_input(s);
			} else {			
				System.out.println("�߸��� �Է��Դϴ�");
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
	public static void menu_1(Sungjuk[] s) {
		s[Sungjuk.cnt] = new Sungjuk();
		s[Sungjuk.cnt].input(s);
		if(s[Sungjuk.cnt] == null) {
			return;
		}
		s[Sungjuk.cnt].processc();
		Sungjuk.cnt++;
	}

	// ��ü ������ ���
	public static void menu_2(Sungjuk[] s) {
		System.out.printf("\t\t\t*** ����ǥ ***\n");
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		// ����Ҷ����� ��ü �л������ �ʱ�ȭ���Ѽ� ����
		Sungjuk.tot_avg = 0;
		for (int i = 0; i < Sungjuk.cnt; i++) {
			s[i].all_output();
			s[i].processc_tot();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t�л��� : %d\t\t��ü��� : %.2f\n", Sungjuk.cnt, Sungjuk.getTotal_avg());
		System.out.println();
	}
	
	// �л��� ������ ��ȸ
	public static void menu_3(Sungjuk[] s) {
		// �Է¹��� ������ �ε��� ���� �����Ͽ� ���
		int i = Sungjuk.menu_3_input(s);
		if(i == MAX+1) {
			return;
		}
		System.out.printf("\t\t*** %s�� ����ǥ ***\n", s[i].number);
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s[i].number, s[i].name, s[i].kor, s[i].eng, s[i].math, s[i].sum, s[i].average, s[i].rating);
		System.out.println("===========================================================");
		System.out.println();
	}
	
	

}
