
public class Sungjuk_Ex {
	public static void main(String[] args) {

		SungjukAlloc SA = new SungjukAlloc();
		SA.addSungjuk();
		SA.addSungjuk();
		SA.addSungjuk();
		print(SA);
	}
	
	// 전체 데이터 출력
	public static void print(SungjukAlloc SA) {
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		for(int i = 0; i < SA.getSungjukNum(); i++) {
			SA.getSungjuk(i).output();
		}
		System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n", SA.getSungjukNum(), SA.getTotal_avg());
		
	}
}
