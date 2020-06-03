import java.io.Serializable;
import java.util.Scanner;

public class Sangpum implements Serializable, Cloneable{

	// 상품코드에 exit 입력하면 종료
	// 입력가능한 데이터 건수는 100으로 제한

	String code;
	String irum;
	int su;
	int dan;
	int price;
	String grade;
	
	static int cnt = 0;
	static int tot_price = 0;
	
	public String toString() {
		String str = "상품코드 : " + code + "\n";
		str += "상품명 : " + irum + "\n";
		str += "수량 : " + su + "\n";
		str += "단가 : " + irum + "\n";
		str += "가격 : " + price + "\n";
		str += "등급 : " + grade + "\n";
		return str;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sangpum)) {
			return false;
		}
		Sangpum objA = (Sangpum) obj;
		if(code.equals(objA.code) && irum.equals(objA.irum) && su == objA.su && dan == objA.dan) {
			return true;
		}
		return false;
	}
	
	// 기초데이터 입력
	public void input(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		System.out.print("상품명 입력 => ");
		irum = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		System.out.println();
		
	}

	// 기초데이터 계산
	public void processc() {
		price = su * dan;

		if (su >= 100) {
			grade = "우수";
		} else if (su >= 70) {
			grade = "보통";
		} else {
			grade = "분발";
		}
	}
	
	// 판매액 합계 계산
	public void processc_tot() {
		tot_price += price;
	}

	// 전체 데이터 출력
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", code, irum, su, dan, price, grade);
	}
}
