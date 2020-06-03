import java.util.Scanner;

public class Member extends Person implements Datable {
	String id, passwd, irum, gender, email;
	static int member_cnt = 0;
	
	public boolean inputData(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 => ");
		irum = scan.next();
		if(irum.equals("exit")) {
			return true;
		}
		System.out.print("성별 입력 => ");
		gender = scan.next();
		System.out.print("이메일 입력 => ");
		email = scan.next();
		System.out.print("아이디 입력 => ");
		id = scan.next();
		System.out.print("패스워드 입력 => ");
		passwd = scan.next();
		System.out.println();
		return false;
	}
	
	public void outputData() {
		System.out.printf("%s\t%s\t%-20s\t%-10s\t%s\n", irum, gender, email, id, passwd);
	}
	
	static int getMemberCnt() {
		return member_cnt;
	}
}
