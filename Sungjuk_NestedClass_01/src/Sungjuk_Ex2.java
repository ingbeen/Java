
public class Sungjuk_Ex2 {
	public static void main(String[] args) {

		SungjukAlloc sa = new SungjukAlloc();
		sa.addSungjuk();
		sa.addSungjuk();
		sa.addSungjuk();
		SungjukAlloc.Sungjuk sungjuk1 = sa.new Sungjuk();
		sungjuk1.input();
		sungjuk1.process();
		sa.list.add(sungjuk1);
		print(sa);
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
