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
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
		System.out.printf("====================================================================\n");
		for (MemberInner.Member member : obj.list) {
			member.outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    ��ȸ���� : %d\n\n", obj.getMemberNum());
	}
}
