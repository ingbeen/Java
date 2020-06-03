
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
		System.out.printf("\t\t*** 사원정보 ***\n");
		System.out.printf("====================================================\n");
		System.out.printf("사원번호\t부서명\t이름\t성별\t이메일\n");
		System.out.printf("====================================================\n");
		int cnt = Sawon.getSawonCnt();
		for(int i = 0; i < cnt; i++) {
			list[i].outputData();
		}
		System.out.printf("====================================================\n");
		System.out.printf("\t\t총사원수 : %d\n", cnt);
	}
	
}
