import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	String phone;
	String addr;
	
	public boolean input() {
		Scanner in = new Scanner(System.in);
		System.out.print("�й� �Է� => ");
		hakbun = in.next();
		if (hakbun.toLowerCase().equals("exit"))
			return true;
		
		System.out.print("�̸� �Է� => ");
		irum = in.next();
		System.out.print("��ȭ��ȣ �Է� => ");
		phone = in.next();
		System.out.print("�ּ� �Է� => ");
		addr = in.next();
		
		return false;
	}

	public void output() {
		System.out.printf("%4s    %3s      %11s    %2s\n", 
				hakbun, irum, phone, addr);
	}
}