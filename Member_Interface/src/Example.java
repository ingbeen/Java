
public class Example {
	final static int MAX = 100;
	public static void main(String[] args) {
		Member[] list1 = new Member[MAX];
		Sawon[] list2 = new Sawon[MAX];
		
		System.out.println("### 학생정보 입력 ###");
		for(int i = 0; i < list1.length; i++) {
			list1[i] = new Member();
			if(list1[i].inputData()) {
				System.out.println();
				break;
			}
		}
		
		System.out.println("### 사원정보 입력 ###");
		for(int i = 0; i < list2.length; i++) {
			list2[i] = new Sawon();
			if(list2[i].inputData()) {
				System.out.println();
				break;
			}
		}
		print(list1);
		print(list2);
	}
	
	// instanceof 활용하여 Member클래스, Sawon클래스 출력
	static void print(Datable[] list) {
		int cnt = 0;
		if(list instanceof Member[]) {
			cnt = Member.getMemberCnt();
			System.out.printf("\t\t         *** 회원정보 ***\n");
			System.out.printf("===================================================================\n");
			System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
			System.out.printf("===================================================================\n");
			for(int i = 0; i < cnt; i++) {
				list[i].outputData();
			}
			System.out.printf("===================================================================\n");
			System.out.printf("\t\t                     총회원수 : %d\n\n", cnt);
		} else if(list instanceof Sawon[]) {
			cnt = Sawon.getSawonCnt();
			System.out.printf("\t\t*** 사원정보 ***\n");
			System.out.printf("====================================================\n");
			System.out.printf("사원번호\t부서명\t이름\t성별\t이메일\n");
			System.out.printf("====================================================\n");
			for(int i = 0; i < cnt; i++) {
				list[i].outputData();
			}
			System.out.printf("====================================================\n");
			System.out.printf("\t\t총사원수 : %d\n\n", cnt);
		}
	}
}
