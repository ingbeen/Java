import java.util.ArrayList;
import java.util.Scanner;

public class SungjukAlloc {
	ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();

	// 입력
	void menu_1() {
		Sungjuk obj = new Sungjuk();

		obj.input(obj);
		for (Sungjuk obj2 : list) {
			if (obj2.number.equals(obj.number)) {
				System.out.println("학번이 중복입니다\n");
				return;
			}
		}
		obj.processc();
		list.add(obj);
		System.out.println("성적정보 입력 성공\n");
	}

	// 전체 출력
	void menu_2() {
		if (list.size() <= 0) {
			System.out.println("조회할 성적이 없습니다\n");
			return;
		}
		System.out.printf("\t\t\t*** 성적표 ***\n");
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		double tot_avg = 0;
		for (Sungjuk obj : list) {
			obj.output();
			tot_avg += obj.average;
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t학생수 : %d\t\t전체평균 : %.2f\n", list.size(), tot_avg / list.size());
		System.out.println();
	}

	// 선택 출력
	void menu_3() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		System.out.printf("\t\t*** %s의 성적표 ***\n", obj.number);
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		obj.output();
		System.out.println("===========================================================");
		System.out.println();
	}

	// 선택 수정
	void menu_4() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 입력 => ");
		obj.kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		obj.eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		obj.math = scan.nextInt();
		System.out.println();
		obj.processc();
		System.out.println("성적정보 입력 성공!!\n");
	}

	// 선택 삭제
	void menu_5() {
		Sungjuk obj = choice();
		if (obj == null) {
			return;
		}
		list.remove(obj);
		System.out.println("성적정보 삭제 성공!!\n");
	}

	// 조회, 수정, 삭제를 할 경우 선택객체 반환
	Sungjuk choice() {
		Scanner scan = new Scanner(System.in);

		System.out.print("선택할 학번 입력 => ");
		String choice = scan.next();
		System.out.println();

		for (Sungjuk obj : list)
			if (obj.number.equals(choice)) {
				return obj;
			}

		System.out.println("존재하지 않는 학번입니다\n");
		return null;
	}

	// 초기메뉴
	void printMenu() {
		System.out.println("*** 성적관리 ***");
		System.out.println("1. 성적정보 입력");
		System.out.println("2. 성적정보 출력");
		System.out.println("3. 성적정보 조회");
		System.out.println("4. 성적정보 수정");
		System.out.println("5. 성적정보 삭제");
		System.out.println("6. 프로그램 종료");
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

		// 데이터 입력
		void input(Sungjuk obj) {
			Scanner scan = new Scanner(System.in);

			System.out.print("학번 입력 => ");
			obj.number = scan.next();
			System.out.print("이름 입력 => ");
			obj.name = scan.next();
			System.out.print("국어 입력 => ");
			obj.kor = scan.nextInt();
			System.out.print("영어 입력 => ");
			obj.eng = scan.nextInt();
			System.out.print("수학 입력 => ");
			obj.math = scan.nextInt();
			System.out.println();
		}

		// 등급 계산
		void processc() {
			sum = kor + eng + math;
			average = (double) sum / 3;

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
		void output() {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
		}
	}
}