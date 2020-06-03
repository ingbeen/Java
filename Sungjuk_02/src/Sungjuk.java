import java.util.Scanner;

public class Sungjuk{

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
	public void input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		
		// 
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
		for(i = 0; i < cnt; i++) {
			if(s[i].number.equals(s[cnt].number)) {
				System.out.println("학번 입력 오류(중복)!!");
				System.out.println();
				s[cnt] = null;
				break;
			}
		}
		
		if (i == cnt) {
			System.out.println("성적 정보 입력 성공!!");
			System.out.println();
		}
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
	static double getTotal_avg() {
		return tot_avg / cnt;
	}
	
	// 성적정보 조회
	public static int menu_3_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("조회할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		// 선택한 학번의 인덱스 번호를 return
		// boolean으로 인덱스 찾아는지 확인
		int i;
		boolean k = true;
		for(i = 0 ; i < cnt; i++) {
			if(s[i].number.equals(choice)) {
				k = false;
				break;
			}
		}
		
		if(k) {
			System.out.println("성적정보 입력 실패!!");
			System.out.println();
			return Sungjuk_Ex.MAX+1;
		}
		
		return i;
	}
	
	// 성적정보 수정
	public static void menu_4_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		int kor;
		int eng;
		int math;
		
		System.out.print("수정할 학번 입력 => ");
		choice = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
		System.out.println();
		
		// 선택한 학번의 인덱스 번호에 새로운 데이터 입력
		// 수정된 데이터로 총점과 평점 재계산
		// boolean으로 인덱스 찾아는지 확인
		boolean k = true;
		for(int i = 0 ; i < cnt; i++) {
			if(s[i].number.equals(choice)) {
				
				s[i].kor = kor;
				s[i].eng = eng;
				s[i].math = math;
				s[i].processc();
				
				k = false;
				System.out.println("성적정보 입력 성공!!");
				System.out.println();
				break;
			}
		}
		
		if(k) {
			System.out.println("성적정보 입력 실패!!");
			System.out.println();
		}
		
	}
	
	//성적정보 삭제
	public static void menu_5_input(Sungjuk[] s) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("삭제할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		// 선택한 학번의 인덱스 번호에 다음 인덱스 의 데이터를 복사
		// 인덱스번호를 증가시켜 오른쪽으로 방향으로 계속 반복
		// 마지막 인덱스번호는 unll값으로 삭제후 cnt도 차감
		// boolean으로 인덱스 찾아는지 확인
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
				System.out.println("성적정보 삭제 성공!!");
				System.out.println();
				k = false;
				break;
			}
		}
		if(k) {
			System.out.println("성적정보 삭제 실패!!");
			System.out.println();
		}
	}
	
}
