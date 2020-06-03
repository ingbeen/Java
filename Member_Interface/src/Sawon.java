import java.util.Scanner;

public class Sawon extends Person implements Datable {
	String sabun, deptname;
	static int sawon_cnt;
	
	public boolean inputData(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("사원번호 입력 => ");
		sabun = scan.next();
		if(sabun.equals("exit")) {
			return true;
		}
		System.out.print("부서명 입력 => ");
		deptname = scan.next();
		System.out.print("이름 입력 => ");
		irum = scan.next();
		System.out.print("성별 입력 => ");
		gender = scan.next();
		System.out.print("이메일 입력 => ");
		email = scan.next();
		System.out.println();
		sawon_cnt++;
		return false;
	}
	
	public void outputData() {
		System.out.printf("%s\t%s\t%s\t%s\t%s\n", sabun, deptname, irum, gender, email);
	}
	
	static int getSawonCnt() {
		return sawon_cnt;
	}
}
