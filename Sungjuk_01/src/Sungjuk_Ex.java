public class Sungjuk_Ex {
	
	// 최대 학생 수
	final static int MAX = 100;
	
	public static void main(String[] args) {

		// 학번에 exit 입력하면 종료
		// 입력가능한 데이터 건수는 100으로 제한
		// 마지막에 학생수와 전체평균 구하기
		
		Sungjuk[] s = new Sungjuk[MAX];
		
		// 데이터 입력 및 계산, 총학생수 리턴
		input_2(s);
		
		// 데이터 출력
		output_2(s);
		
	}
	
	
	// 기초데이터 입력 및 계산
	public static void input_2(Sungjuk[] s) {
		for (int i = 0; i < s.length; i++) {
			s[i] = new Sungjuk();
			s[i].input();
			if (s[i].number.equals("exit")) {
				break;
			}
			s[i].processc();
		}
	}

	// 데이터 출력
	public static void output_2(Sungjuk[] s) {
		System.out.printf("\t\t\t*** 성적표 ***\n");
		System.out.println("===========================================================");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.println("===========================================================");
		for (int i = 0; i < Sungjuk.cnt; i++) {
			s[i].output();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t학생수 : %d\t\t전체평균 : %.2f\n", Sungjuk.cnt, Sungjuk.getTotal_avg());
	}

}
