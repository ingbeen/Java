import java.util.Scanner;

public class Sangpum {

	// ��ǰ�ڵ忡 exit �Է��ϸ� ����
	// �Է°����� ������ �Ǽ��� 100���� ����

	String code;
	String irum;
	int su;
	int dan;
	int price;
	String grade;
	
	static int cnt = 0;
	static int tot_price = 0;

	// ���ʵ����� �Է�
	public void input(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("��ǰ�ڵ� �Է� => ");
		code = scan.next();
		System.out.print("��ǰ�� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		System.out.println();
		
		for(int i = 0; i < cnt; i++) {
			if (s[i].code.equals(code)) {
				s[cnt] = null;
				System.out.println("�Է¿��� : ��ǰ�ڵ尡 �ߺ��Դϴ�");
				System.out.println();
			}
		}
	}

	// ���ʵ����� ���
	public void processc() {
		price = su * dan;

		if (su >= 100) {
			grade = "���";
		} else if (su >= 70) {
			grade = "����";
		} else {
			grade = "�й�";
		}
	}
	
	// �Ǹž� �հ� ���
	public void processc_tot() {
		tot_price += price;
	}

	// ��ü ������ ���
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", code, irum, su, dan, price, grade);
	}
	
	// ��ǰ���� ��ȸ
	public static int search(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("��ȸ�� ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if (k) {
			System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
			System.out.println();
		}
		return i;
	}
	
	// ��ǰ���� ����
	public static void menu_4(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		int su;
		int dan;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				
				s[i].su = su;
				s[i].dan = dan;
				s[i].processc();
				
				System.out.println("�Ǹ����� ���� ����");
				System.out.println();
				
				break;
			}
		}
		
		if (k) {
			System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
			System.out.println();
		}
	}
	
	// ��ǰ���� ����
	public static void menu_5(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < cnt; i++) {
			if(s[i].code.equals(choice)) {
				k = false;
				for(int j = i + 1; j < cnt; j++) {
					s[i] = s[j];
					i++;
				}
				s[i] = null;
				System.out.println("�Ǹ����� ���� ����");
				System.out.println();
				cnt--;
				break;
			}
		}
		
		if (k) {
			System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
			System.out.println();
		}
	}

}
