import java.util.Scanner;

public class Personinfo extends Person implements Personable {

	String phone;
	String addr;

	@Override
	public boolean input() {
		Scanner scan = new Scanner(System.in);

		System.out.println("### �������� �Է� ###");
		System.out.print("�й� �Է� => ");
		hakbun = scan.next();
		if (hakbun.toLowerCase().equals("exit")) {
			System.out.println();
			return true;
		}
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("��ȭ��ȣ �Է� => ");
		phone = scan.next();
		System.out.print("�ּ� �Է� => ");
		addr = scan.next();
		System.out.println();

		return false;
	}

	@Override
	public void output() {
		System.out.printf("%s\t%s\t%-13s\t%s\n", hakbun, irum, phone, addr);
	}

}
