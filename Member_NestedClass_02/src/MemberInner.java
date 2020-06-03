import java.util.ArrayList;
import java.util.Scanner;

public class MemberInner{
	ArrayList<Member> list = new ArrayList<Member>();
	
	public void printMenu() {
		System.out.println("*** 회원관리 ***");
		System.out.println("1. 회원정보 입력");
		System.out.println("2. 회원정보 출력");
		System.out.println("3. 회원정보 조회");
		System.out.println("4. 회원정보 수정");
		System.out.println("5. 회원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	public Member Search() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 선택 => ");
		String choice = scan.next();
		System.out.println();
		for(Member member : list) {
			if(choice.equals(member.irum)) {
				return member;
			}
		}
		System.out.println("입력하신 이름이 없습니다\n");
		return null;
	}

	public void menu_1() {
		Member obj = new Member();
		obj.inputData();
		for(Member member : list) {
			if(obj.irum.equals(member.irum)) {
				System.out.println("이름값이 중복입니다\n");
				return;
			}
		}
		list.add(obj);
		System.out.println("회원정보 입력 성공\n");
	}

	public void menu_2() {
		if (list.size() == 0) {
			System.out.println("출력가능한 회원정보가 없습니다");
			return;
		}
		System.out.printf("\t\t         *** 회원정보 ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
		System.out.printf("====================================================================\n");
		for (Member member : list) {
			member.outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    총회원수 : %d\n\n", list.size());
	}

	public void menu_3() {
		Member obj = Search();
		if (obj == null) {
			return;
		}
		System.out.printf("\t\t         *** 회원정보 ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
		System.out.printf("====================================================================\n");
		obj.outputData();
		System.out.printf("====================================================================\n\n");
	}

	public void menu_4() {
		Member obj = Search();
		if (obj == null) {
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("성별 입력 => ");
		obj.gender = scan.next();
		System.out.print("이메일 입력 => ");
		obj.email = scan.next();
		System.out.print("아이디 입력 => ");
		obj.id = scan.next();
		System.out.print("패스워드 입력 => ");
		obj.passwd = scan.next();
		System.out.println();
		System.out.println("회원정보 수정 성공\n");
	}

	public void menu_5() {
		Member obj = Search();
		if (obj == null) {
			return;
		}
		System.out.println("회원정보 삭제 성공\n");
		list.remove(obj);
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
