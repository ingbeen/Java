
public class Sangpum_Ex {

	public static void main(String[] args) {
		Sangpum obj = new Sangpum() {
			void output()
			{
				System.out.println("\t\t*** 판매 현황 ***");
				System.out.println("===========================================");
				System.out.println("상품코드\t상품명\t수량\t단가\t금액\t평가");
				System.out.println("===========================================");
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%s\n",
						code, irum, su, dan, price, grade);
				System.out.println("===========================================");
				System.out.println();
			}
		};
		obj.input();
		obj.process();
		obj.output();
	}
}
