import java.util.ArrayList;
import java.util.Scanner;

public class MemberInner{
	ArrayList<Member> list = new ArrayList<Member>();
	
	public void printMenu() {
		System.out.println("*** ȸ������ ***");
		System.out.println("1. ȸ������ �Է�");
		System.out.println("2. ȸ������ ���");
		System.out.println("3. ȸ������ ��ȸ");
		System.out.println("4. ȸ������ ����");
		System.out.println("5. ȸ������ ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}

	public Member Search() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�̸� ���� => ");
		String choice = scan.next();
		System.out.println();
		for(Member member : list) {
			if(choice.equals(member.irum)) {
				return member;
			}
		}
		System.out.println("�Է��Ͻ� �̸��� �����ϴ�\n");
		return null;
	}

	public void menu_1() {
		Member obj = new Member();
		obj.inputData();
		for(Member member : list) {
			if(obj.irum.equals(member.irum)) {
				System.out.println("�̸����� �ߺ��Դϴ�\n");
				return;
			}
		}
		list.add(obj);
		System.out.println("ȸ������ �Է� ����\n");
	}

	public void menu_2() {
		if (list.size() == 0) {
			System.out.println("��°����� ȸ�������� �����ϴ�");
			return;
		}
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
		System.out.printf("====================================================================\n");
		for (Member member : list) {
			member.outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    ��ȸ���� : %d\n\n", list.size());
	}

	public void menu_3() {
		Member obj = Search();
		if (obj == null) {
			return;
		}
		System.out.printf("\t\t         *** ȸ������ ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("�̸�\t����\t               %-30s\t%-15s\t��й�ȣ\n", "�̸���", "���̵�");
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
		System.out.print("���� �Է� => ");
		obj.gender = scan.next();
		System.out.print("�̸��� �Է� => ");
		obj.email = scan.next();
		System.out.print("���̵� �Է� => ");
		obj.id = scan.next();
		System.out.print("�н����� �Է� => ");
		obj.passwd = scan.next();
		System.out.println();
		System.out.println("ȸ������ ���� ����\n");
	}

	public void menu_5() {
		Member obj = Search();
		if (obj == null) {
			return;
		}
		System.out.println("ȸ������ ���� ����\n");
		list.remove(obj);
	}
	
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
}
