import java.util.Scanner;

public class Sawon extends Person implements Datable {
	String sabun, deptname;
	static int sawon_cnt;
	
	public boolean inputData(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�����ȣ �Է� => ");
		sabun = scan.next();
		if(sabun.equals("exit")) {
			return true;
		}
		System.out.print("�μ��� �Է� => ");
		deptname = scan.next();
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		gender = scan.next();
		System.out.print("�̸��� �Է� => ");
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
