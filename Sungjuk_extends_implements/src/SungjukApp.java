
public class SungjukApp {

	final static int MAX = 100;

	public static void main(String[] args) {

		Sungjuk[] sungobj = new Sungjuk[MAX];
		Personinfo[] perobj = new Personinfo[MAX];

		// 성적입력
		for (int i = 0; i < MAX; i++) {
			sungobj[i] = new Sungjuk();
			boolean k = sungobj[i].input();
			if (k) {
				break;
			}
			sungobj[i].process();
		}

		// 개인정보 입력
		for (int i = 0; i < MAX; i++) {
			perobj[i] = new Personinfo();
			boolean k = perobj[i].input();
			if (k) {
				break;
			}
		}

		// 성적표 출력
		System.out.printf("\t\t\t*** 성적표 ***\n");
		System.out.printf("===========================================================\n");
		System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
		System.out.printf("===========================================================\n");
		out(sungobj, sungobj);
		System.out.printf("===========================================================\n");
		System.out.println();

		// 개인정보 출력
		System.out.printf("\t\t*** 개인정보 ***\n");
		System.out.printf("====================================\n");
		System.out.printf("학번\t이름\t전화번호        \t주소\n");
		System.out.printf("====================================\n");
		out(perobj, perobj);
		System.out.printf("====================================\n");

	}

	public static void out(Person[] obj, Personable[] sungobj) {
		for (int i = 0; i < MAX; i++) {
			if (obj[i].hakbun.equals("exit")) {
				break;
			} else {
				sungobj[i].output();
			}
		}

	}

}
