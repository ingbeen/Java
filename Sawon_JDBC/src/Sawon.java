/*
create table sawon (
    sabun varchar2(4) primary key,
    deptname varchar2(15),
    irum varchar2(10),
    gender varchar2(2),
    email varchar2(50)
);
*/
import java.util.Scanner;

public class Sawon {
	String sabun, deptname, irum, gender, email;
	static int sawon_cnt = 0;
	Sawon(){
	}
	
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("�����ȣ �Է� => ");
		sabun = scan.next();
		System.out.print("�μ��� �Է� => ");
		deptname = scan.next();
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		gender = scan.next();
		System.out.print("�̸��� �Է� => ");
		email = scan.next();
	}
	
	void outputData() {
		System.out.printf("%5s %6s %9s %9s %20s\n", 
			sabun, deptname, irum, gender, email);
	}
	
	static int getSawonCnt() {
		return sawon_cnt;
	}
	
}
