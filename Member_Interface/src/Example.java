
public class Example {
	final static int MAX = 100;
	public static void main(String[] args) {
		Member[] list1 = new Member[MAX];
		Sawon[] list2 = new Sawon[MAX];
		
		System.out.println("### �л����� �Է� ###");
		for(int i = 0; i < list1.length; i++) {
			list1[i] = new Member();
			if(list1[i].inputData()) {
				System.out.println();
				break;
			}
		}
		
		System.out.println("### ������� �Է� ###");
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
	
	// instanceof Ȱ���Ͽ� MemberŬ����, SawonŬ���� ���
	static void print(Datable[] list) {
		int cnt = 0;
		if(list instanceof Member[]) {
			cnt = Member.getMemberCnt();
			System.out.printf("\t\t         *** ȸ������ ***\n");
			System.out.printf("===================================================================\n");
			System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
			System.out.printf("===================================================================\n");
			for(int i = 0; i < cnt; i++) {
				list[i].outputData();
			}
			System.out.printf("===================================================================\n");
			System.out.printf("\t\t                     ��ȸ���� : %d\n\n", cnt);
		} else if(list instanceof Sawon[]) {
			cnt = Sawon.getSawonCnt();
			System.out.printf("\t\t*** ������� ***\n");
			System.out.printf("====================================================\n");
			System.out.printf("�����ȣ\t�μ���\t�̸�\t����\t�̸���\n");
			System.out.printf("====================================================\n");
			for(int i = 0; i < cnt; i++) {
				list[i].outputData();
			}
			System.out.printf("====================================================\n");
			System.out.printf("\t\t�ѻ���� : %d\n\n", cnt);
		}
	}
}
