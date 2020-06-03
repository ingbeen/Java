import java.util.Scanner;

public class Sungjuk {

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
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		// �й��� "exit" �Է��ϱ� ������ �л������� �Է�
		System.out.print("�й� �Է� => ");
		number = scan.next();
		if (number.equals("exit")) {
			return;
		}
		System.out.print("�̸� �Է� => ");
		name = scan.next();
		System.out.print("���� �Է� => ");
		kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		math = scan.nextInt();
		System.out.println();
		cnt++;
	}

	
	// ���ʵ����� ���
	public void processc() {
		sum = kor + eng + math;
		average = (double) sum / 3;
		tot_avg += average;

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
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
	}
	
	static double getTotal_avg() {
		return tot_avg / cnt;
	}

}
