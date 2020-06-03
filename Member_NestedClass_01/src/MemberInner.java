import java.util.ArrayList;
import java.util.Scanner;

public class MemberInner{
	ArrayList<Member> list = new ArrayList<Member>();
	
	void addMember() {
		Member obj = new Member();
		obj.inputData();
		list.add(obj);
	}
	
	int getMemberNum() {
		return list.size();
	}
	
	public class Member{
		String irum, gender, email, id, passwd;
		
		public void inputData(){
			Scanner scan = new Scanner(System.in);
			
			System.out.print("이름 입력 => ");
			irum = scan.next();
			System.out.print("성별 입력 => ");
			gender = scan.next();
			System.out.print("이메일 입력 => ");
			email = scan.next();
			System.out.print("아이디 입력 => ");
			id = scan.next();
			System.out.print("패스워드 입력 => ");
			passwd = scan.next();
			System.out.println();
		}
		
		public void outputData() {
			System.out.printf("%s\t%s\t%-20s\t%-10s\t%s\n", irum, gender, email, id, passwd);
		}
	}
}
