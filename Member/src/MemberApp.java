
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
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
		System.out.printf("====================================================================\n");
		int cnt = Member.getMemberCnt();
		for(int i = 0; i < cnt; i++) {
			list[i].outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    ��ȸ���� : %d\n", cnt);
	}
	
}
