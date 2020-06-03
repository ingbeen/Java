import java.util.Scanner;

public class Personinfo extends Person implements Personable {

	String phone;
	String addr;

	@Override
	public boolean input() {
		Scanner scan = new Scanner(System.in);

		System.out.println("### 개인정보 입력 ###");
		System.out.print("학번 입력 => ");
		hakbun = scan.next();
		if (hakbun.toLowerCase().equals("exit")) {
			System.out.println();
			return true;
		}
		System.out.print("이름 입력 => ");
		irum = scan.next();
		System.out.print("전화번호 입력 => ");
		phone = scan.next();
		System.out.print("주소 입력 => ");
		addr = scan.next();
		System.out.println();

		return false;
	}

	@Override
	public void output() {
		System.out.printf("%s\t%s\t%-13s\t%s\n", hakbun, irum, phone, addr);
	}

}
