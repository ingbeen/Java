import java.util.Scanner;

public class Sungjuk {

	// 학번에 exit 입력하면 종료
	// 입력가능한 데이터 건수는 100으로 제한
	// 마지막에 학생수와 전체평균 구하기

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

	// 기초데이터 입력
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		// 학번에 "exit" 입력하기 전까지 학생데이터 입력
		System.out.print("학번 입력 => ");
		number = scan.next();
		if (number.equals("exit")) {
			return;
		}
		System.out.print("이름 입력 => ");
		name = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
		System.out.println();
		cnt++;
	}

	
	// 기초데이터 계산
	public void processc() {
		sum = kor + eng + math;
		average = (double) sum / 3;
		tot_avg += average;

		if (average >= 90) {
			rating = "수";
		} else if (average >= 80) {
			rating = "우";
		} else if (average >= 70) {
			rating = "미";
		} else if (average >= 60) {
			rating = "양";
		} else {
			rating = "가";
		}
	}

	// 데이터 출력
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
	}
	
	static double getTotal_avg() {
		return tot_avg / cnt;
	}

}
