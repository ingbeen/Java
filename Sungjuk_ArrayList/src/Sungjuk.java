import java.util.ArrayList;
import java.util.Scanner;

public class Sungjuk{
	String number;
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double average;
	String rating;
	
	static int tot_avg = 0;
 
	// ���ʵ����� �Է�
	public void input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("�й� �Է� => ");
		number = scan.next();
		System.out.print("�̸� �Է� => ");
		name = scan.next();
		System.out.print("���� �Է� => ");
		kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		math = scan.nextInt();
		System.out.println();
		
		int i;
		for(i = 0; i < s.size() - 1; i++) {
			if(s.get(i).number.equals(s.get(s.size() - 1).number)) {
				System.out.println("�й� �Է� ����(�ߺ�)!!\n");
				s.remove(i);
				return;
			}
		}
		System.out.println("���� ���� �Է� ����!!\n");
	}
	
	
	// ���ʵ����� ���
	public void processc() {
		sum = kor + eng + math;
		average = (double) sum / 3;

		if (average >= 90) {
			rating = "��";
		} else if (average >= 80) {
			rating = "��";
		} else if (average >= 70) {
			rating = "��";
		} else if (average >= 60) {
			rating = "��";
		} else {
			rating = "��";
		}
	}

	// ������ ���
	public void all_output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
	}
	
	// �л� ��ü��� ����
	public void processc_tot() {
		tot_avg += average;
	}
		
	// �л� ��ü���
	static double getTotal_avg(ArrayList<Sungjuk> s) {
		return tot_avg / s.size();
	}
	
	// �������� ��ȸ
	public static int menu_3_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("��ȸ�� �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		// ������ �й��� �ε��� ��ȣ�� return
		// boolean���� �ε��� ã�ƴ��� Ȯ��
		int i;
		boolean k = true;
		for(i = 0 ; i < s.size(); i++) {
			if(s.get(i).number.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if(k) {
			System.out.println("�������� �Է� ����!!\n");
			return s.size()+1;
		}
		
		return i;
	}
	
	// �������� ����
	public static void menu_4_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		for(Sungjuk dat : s) {
			if(dat.number.equals(choice)) {
				System.out.print("���� �Է� => ");
				dat.kor = scan.nextInt();
				System.out.print("���� �Է� => ");
				dat.eng = scan.nextInt();
				System.out.print("���� �Է� => ");
				dat.math = scan.nextInt();
				System.out.println();
				
				dat.processc();
				System.out.println("�������� ���� ����!!\n");
				return;
			}
		}
		System.out.println("�������� ���� ����!!\n");
		
	}
	
	//�������� ����
	public static void menu_5_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		for(Sungjuk dat : s) {
			if(dat.number.equals(choice)) {
				s.remove(dat);
				System.out.println("�������� ���� ����!!\n");
				return;
			}
		}
		System.out.println("�������� ���� ����!!\n");
	}
}
