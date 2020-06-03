import java.util.Scanner;

public class Sungjuk extends Person implements Personable {

	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	String grade;

	@Override
	public boolean input() {
		Scanner scan = new Scanner(System.in);

		System.out.println("### �������� �Է� ###");
		System.out.print("�й� �Է� => ");
		hakbun = scan.next();
		if (hakbun.toLowerCase().equals("exit")) {
			System.out.println();
			return true;
		}
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		math = scan.nextInt();
		System.out.println();
		return false;
	}

	@Override
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", hakbun, irum, kor, eng, math, tot, avg, grade);
	}

	public void process() {
		tot = kor + eng + math;
		avg = (double) tot / 3;

		if (avg >= 90) {
			grade = "��";
		} else if (avg >= 80) {
			grade = "��";
		} else if (avg >= 70) {
			grade = "��";
		} else if (avg >= 60) {
			grade = "��";
		} else {
			grade = "��";
		}
	}

}
