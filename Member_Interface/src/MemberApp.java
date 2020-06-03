
public class MemberApp {
	final static int MAX = 100;
	public static void main(String[] args) {
		Member[] list = new Member[MAX];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new Member();
			if(list[i].inputData()) {
				print(list);
				break;
			}
		}
	}
	
	static void print(Member[] list) {
		System.out.printf("\t\t         *** 회원정보 ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
		System.out.printf("====================================================================\n");
		int cnt = Member.getMemberCnt();
		for(int i = 0; i < cnt; i++) {
			list[i].outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    총회원수 : %d\n", cnt);
	}
}
