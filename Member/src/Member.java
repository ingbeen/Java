import java.util.Scanner;

public class Member {
	String irum;
	String gender;
	String email;
	String id;
	String passwd;
	static int member_cnt;
	
	boolean inputData(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		if(irum.equals("exit")) {
			return true;
		}
		System.out.print("���� �Է� => ");
		gender = scan.next();
		System.out.print("�̸��� �Է� => ");
		email = scan.next();
		System.out.print("���̵� �Է� => ");
		id = scan.next();
		System.out.print("�н����� �Է� => ");
		passwd = scan.next();
		System.out.println();
		member_cnt++;
		return false;
	}
	
	void outputData() {
		System.out.printf("%s\t%s\t%-20s\t%-10s\t%s\n", irum, gender, email, id, passwd);
	}
	
	static int getMemberCnt() {
		return member_cnt;
	}
}
