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

		System.out.println("### 성적정보 입력 ###");
		System.out.print("학번 입력 => ");
		hakbun = scan.next();
		if (hakbun.toLowerCase().equals("exit")) {
			System.out.println();
			return true;
		}
		System.out.print("이름 입력 => ");
		irum = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
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
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		} else {
			grade = "가";
		}
	}

}
