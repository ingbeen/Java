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
 
	// 기초데이터 입력
	public void input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("학번 입력 => ");
		number = scan.next();
		System.out.print("이름 입력 => ");
		name = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
		System.out.println();
		
		int i;
		for(i = 0; i < s.size() - 1; i++) {
			if(s.get(i).number.equals(s.get(s.size() - 1).number)) {
				System.out.println("학번 입력 오류(중복)!!\n");
				s.remove(i);
				return;
			}
		}
		System.out.println("성적 정보 입력 성공!!\n");
	}
	
	
	// 기초데이터 계산
	public void processc() {
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
	public void all_output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", number, name, kor, eng, math, sum, average, rating);
	}
	
	// 학생 전체평균 누적
	public void processc_tot() {
		tot_avg += average;
	}
		
	// 학생 전체평균
	static double getTotal_avg(ArrayList<Sungjuk> s) {
		return tot_avg / s.size();
	}
	
	// 성적정보 조회
	public static int menu_3_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("조회할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		// 선택한 학번의 인덱스 번호를 return
		// boolean으로 인덱스 찾아는지 확인
		int i;
		boolean k = true;
		for(i = 0 ; i < s.size(); i++) {
			if(s.get(i).number.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if(k) {
			System.out.println("성적정보 입력 실패!!\n");
			return s.size()+1;
		}
		
		return i;
	}
	
	// 성적정보 수정
	public static void menu_4_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("수정할 학번 입력 => ");
		choice = scan.next();
		for(Sungjuk dat : s) {
			if(dat.number.equals(choice)) {
				System.out.print("국어 입력 => ");
				dat.kor = scan.nextInt();
				System.out.print("영어 입력 => ");
				dat.eng = scan.nextInt();
				System.out.print("수학 입력 => ");
				dat.math = scan.nextInt();
				System.out.println();
				
				dat.processc();
				System.out.println("성적정보 수정 성공!!\n");
				return;
			}
		}
		System.out.println("성적정보 수정 실패!!\n");
		
	}
	
	//성적정보 삭제
	public static void menu_5_input(ArrayList<Sungjuk> s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("삭제할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		for(Sungjuk dat : s) {
			if(dat.number.equals(choice)) {
				s.remove(dat);
				System.out.println("성적정보 삭제 성공!!\n");
				return;
			}
		}
		System.out.println("성적정보 삭제 실패!!\n");
	}
}
