
public class Sungjuk_Ex {
	public static void main(String[] args) {

		SungjukAlloc SA = new SungjukAlloc();
		SA.addSungjuk();
		SA.addSungjuk();
		SA.addSungjuk();
		print(SA);
	}
	
	// ��ü ������ ���
	public static void print(SungjukAlloc SA) {
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		for(int i = 0; i < SA.getSungjukNum(); i++) {
			SA.getSungjuk(i).output();
		}
		System.out.println("=======================================");
		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n", SA.getSungjukNum(), SA.getTotal_avg());
		
	}
}
