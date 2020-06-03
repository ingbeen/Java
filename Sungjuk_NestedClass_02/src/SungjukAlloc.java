import java.util.ArrayList;
import java.util.Scanner;

public class SungjukAlloc {
	ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();

	// �Է�
	void menu_1() {
		Sungjuk obj = new Sungjuk();

		obj.input(obj);
		for (Sungjuk obj2 : list) {
			if (obj2.number.equals(obj.number)) {
				System.out.println("�й��� �ߺ��Դϴ�\n");
				return;
			}
		}
		obj.processc();
		list.add(obj);
		System.out.println("�������� �Է� ����\n");
	}

	// ��ü ���
	void menu_2() {
		if (list.size() <= 0) {
			System.out.println("��ȸ�� ������ �����ϴ�\n");
			return;
		}
		System.out.printf("\t\t\t*** ����ǥ ***\n");
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		double tot_avg = 0;
		for (Sungjuk obj : list) {
			obj.output();
			tot_avg += obj.average;
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t�л��� : %d\t\t��ü��� : %.2f\n", list.size(), tot_avg / list.size());
		System.out.println();
	}

	// ���� ���
	void menu_3() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		System.out.printf("\t\t*** %s�� ����ǥ ***\n", obj.number);
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		obj.output();
		System.out.println("===========================================================");
		System.out.println();
	}

	// ���� ����
	void menu_4() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� => ");
		obj.kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		obj.eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		obj.math = scan.nextInt();
		System.out.println();
		obj.processc();
		System.out.println("�������� �Է� ����!!\n");
	}

	// ���� ����
	void menu_5() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		list.remove(obj);
		System.out.println("�������� ���� ����!!\n");
	}

	// ��ȸ, ����, ������ �� ��� ���ð�ü ��ȯ
	Sungjuk choice() {
		Scanner scan = new Scanner(System.in);

		System.out.print("������ �й� �Է� => ");
		String choice = scan.next();
		System.out.println();

		for (Sungjuk obj : list)
			if (obj.number.equals(choice)) {
				return obj;
			}

		System.out.println("�������� �ʴ� �й��Դϴ�\n");
		return null;
	}

	// �ʱ�޴�
	void printMenu() {
		System.out.println("*** �������� ***");
		System.out.println("1. �������� �Է�");
		System.out.println("2. �������� ���");
		System.out.println("3. �������� ��ȸ");
		System.out.println("4. �������� ����");
		System.out.println("5. �������� ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}

	class Sungjuk {

		String number;
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		double average;
		String rating;

		// ������ �Է�
		void input(Sungjuk obj) {
			Scanner scan = new Scanner(System.in);

			System.out.print("�й� �Է� => ");
			obj.number = scan.next();
			System.out.print("�̸� �Է� => ");
			obj.name = scan.next();
			System.out.print("���� �Է� => ");
			obj.kor = scan.nextInt();
			System.out.print("���� �Է� => ");
			obj.eng = scan.nextInt();
			System.out.print("���� �Է� => ");
			obj.math = scan.nextInt();
			System.out.println();
		}

		// ��� ���
		void processc() {
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
		void output() {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
		}
	}
}