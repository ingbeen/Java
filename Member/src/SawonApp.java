
public class SawonApp {
	final static int MAX = 100;
	public static void main(String[] args) {
		Sawon[] list = new Sawon[MAX];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new Sawon();
			if(list[i].inputData()) {
				print(list);
				break;
			}
		}
	}
	
	static void print(Sawon[] list) {
		System.out.printf("\t\t*** ������� ***\n");
		System.out.printf("====================================================\n");
		System.out.printf("�����ȣ\t�μ���\t�̸�\t����\t�̸���\n");
		System.out.printf("====================================================\n");
		int cnt = Sawon.getSawonCnt();
		for(int i = 0; i < cnt; i++) {
			list[i].outputData();
		}
		System.out.printf("====================================================\n");
		System.out.printf("\t\t�ѻ���� : %d\n", cnt);
	}
	
}
