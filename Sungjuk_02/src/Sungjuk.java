import java.util.Scanner;

public class Sungjuk{

	// �й��� exit �Է��ϸ� ����
	// �Է°����� ������ �Ǽ��� 100���� ����
	// �������� �л����� ��ü��� ���ϱ�

	String number;
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double average;
	String rating;
	
	static int cnt = 0;
	static int tot_avg = 0;

	// ���ʵ����� �Է�
	public void input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		
		// 
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
		for(i = 0; i < cnt; i++) {
			if(s[i].number.equals(s[cnt].number)) {
				System.out.println("�й� �Է� ����(�ߺ�)!!");
				System.out.println();
				s[cnt] = null;
				break;
			}
		}
		
		if (i == cnt) {
			System.out.println("���� ���� �Է� ����!!");
			System.out.println();
		}
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
	static double getTotal_avg() {
		return tot_avg / cnt;
	}
	
	// �������� ��ȸ
	public static int menu_3_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("��ȸ�� �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		// ������ �й��� �ε��� ��ȣ�� return
		// boolean���� �ε��� ã�ƴ��� Ȯ��
		int i;
		boolean k = true;
		for(i = 0 ; i < cnt; i++) {
			if(s[i].number.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if(k) {
			System.out.println("�������� �Է� ����!!");
			System.out.println();
			return Sungjuk_Ex.MAX+1;
		}
		
		return i;
	}
	
	// �������� ����
	public static void menu_4_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		int kor;
		int eng;
		int math;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		System.out.print("���� �Է� => ");
		kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		math = scan.nextInt();
		System.out.println();
		
		// ������ �й��� �ε��� ��ȣ�� ���ο� ������ �Է�
		// ������ �����ͷ� ������ ���� ����
		// boolean���� �ε��� ã�ƴ��� Ȯ��
		boolean k = true;
		for(int i = 0 ; i < cnt; i++) {
			if(s[i].number.equals(choice)) {
				
				s[i].kor = kor;
				s[i].eng = eng;
				s[i].math = math;
				s[i].processc();
				
				k = false;
				System.out.println("�������� �Է� ����!!");
				System.out.println();
				break;
			}
		}
		
		if(k) {
			System.out.println("�������� �Է� ����!!");
			System.out.println();
		}
		
	}
	
	//�������� ����
	public static void menu_5_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		// ������ �й��� �ε��� ��ȣ�� ���� �ε��� �� �����͸� ����
		// �ε�����ȣ�� �������� ���������� �������� ��� �ݺ�
		// ������ �ε�����ȣ�� unll������ ������ cnt�� ����
		// boolean���� �ε��� ã�ƴ��� Ȯ��
		boolean k = true;
		for(int i = 0 ; i < cnt; i++) {
			if(s[i].number.equals(choice)) {
				if(cnt > 1) {
					for(int j = i + 1; j < cnt; j++) {
						s[i].number = s[j].number;
						s[i].name = s[j].name;
						s[i].kor = s[j].kor;
						s[i].eng = s[j].eng;
						s[i].math = s[j].math;
						i++;
					}
				}
				
				s[i] = null;
				cnt--;
				System.out.println("�������� ���� ����!!");
				System.out.println();
				k = false;
				break;
			}
		}
		if(k) {
			System.out.println("�������� ���� ����!!");
			System.out.println();
		}
	}
	
}
