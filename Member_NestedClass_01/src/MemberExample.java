import java.util.Scanner;

public class MemberExample {

	public static void main(String[] args) {
		MemberInner obj = new MemberInner();

		Scanner scan = new Scanner(System.in);

		obj.addMember();
		obj.addMember();
		obj.addMember();
		printMember(obj);

	}

	public static void printMember(MemberInner obj) {
		System.out.printf("\t\t         *** 회원정보 ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
		System.out.printf("====================================================================\n");
		for (MemberInner.Member member : obj.list) {
			member.outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    총회원수 : %d\n\n", obj.getMemberNum());
	}
}
