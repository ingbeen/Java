import java.util.ArrayList;
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
	
	static int tot_price = 0;

	// ���ʵ����� �Է�
	public void input() {
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
	public static int search(ArrayList<Sangpum> list) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("��ȸ�� ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		int i;
		boolean k = true;
		for(i = 0; i < list.size(); i++) {
			if(list.get(i).code.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if (k) {
			System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�\n");
			return i;
		}
		
		return i;
	}
	
	// ��ǰ���� ����
	public static void menu_4(ArrayList<Sangpum> list) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		
		for(Sangpum dat : list) {
			if(dat.code.equals(choice)) {
				System.out.print("���� �Է� => ");
				dat.su = scan.nextInt();
				System.out.print("�ܰ� �Է� => ");
				dat.dan = scan.nextInt();
				System.out.println();
				dat.processc();
				
				System.out.println("�Ǹ����� ���� ����");
				System.out.println();
				return;
			}
		}
		System.out.println("\n�������� �ʴ� ��ǰ�ڵ��Դϴ�\n");
	}
	
	// ��ǰ���� ����
	public static void menu_5(ArrayList<Sangpum> list) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		for(Sangpum dat : list) {
			if(dat.code.equals(choice)) {
				list.remove(dat);
				System.out.println("�Ǹ����� ���� ����\n");
				return;
			}
		}
		System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�\n");
	}
}
