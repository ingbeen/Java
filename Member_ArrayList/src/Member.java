import java.util.Scanner;

public class Member{
	String irum, gender, email, id, passwd;
	
	public void inputData(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		gender = scan.next();
		System.out.print("�̸��� �Է� => ");
		email = scan.next();
		System.out.print("���̵� �Է� => ");
		id = scan.next();
		System.out.print("�н����� �Է� => ");
		passwd = scan.next();
		System.out.println();
	}
	
	public void outputData() {
		System.out.printf("%s\t%s\t%-20s\t%-10s\t%s\n", irum, gender, email, id, passwd);
	}
}
