import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MemberExample {

	public static void main(String[] args) {
		HashMap<String, Member> list = new HashMap<String, Member>();

		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int menu;
			printMenu();
			System.out.print("메뉴 선택 => ");
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n다시 입력해주세요\n");
				scan.nextLine();
				continue;
			}

			System.out.println();

			if (menu == 6) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else if (menu == 1) {
				menu_1(list);
			} else if (menu == 2) {
				menu_2(list);
			} else if (menu == 3) {
				menu_3(list);
			} else if (menu == 4) {
				menu_4(list);
			} else if (menu == 5) {
				menu_5(list);
			} else {
				System.out.println("잘못된 입력입니다\n");
			}

		}

	}

	public static void printMenu() {
		System.out.println("*** 회원관리 ***");
		System.out.println("1. 회원정보 입력");
		System.out.println("2. 회원정보 출력");
		System.out.println("3. 회원정보 조회");
		System.out.println("4. 회원정보 수정");
		System.out.println("5. 회원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	public static Member Search(HashMap<String, Member> list) {
		System.out.print("이름 선택 => ");
		String choice = new Scanner(System.in).next();
		System.out.println();
		
		if(list.containsKey(choice)) {
			return list.get(choice);
		}
		System.out.println("입력하신 이름이 없습니다\n");
		return null;
	}

	public static void menu_1(HashMap<String, Member> list) {
		Member obj1 = new Member();
		obj1.inputData();
		if(list.containsKey(obj1.irum)) {
			System.out.println("이름값이 중복입니다\n");
			return;
		}
		list.put(obj1.irum, obj1);
		System.out.println("회원정보 입력 성공\n");
	}

	public static void menu_2(HashMap<String, Member> list) {
		if (list.size() == 0) {
			System.out.println("출력가능한 회원정보가 없습니다");
			return;
		}
		System.out.printf("\t\t         *** 회원정보 ***\n");
		System.out.printf("====================================================================\n");
		System.out.printf("이름\t성별\t               %-30s\t%-15s\t비밀번호\n", "이메일", "아이디");
		System.out.printf("====================================================================\n");
		Set<String> keyset = list.keySet();
		for (String key : keyset) {
			list.get(key).outputData();
		}
		System.out.printf("====================================================================\n");
		System.out.printf("\t\t                    총회원수 : %d\n\n", list.size());
	}

	public static void menu_3(HashMap<String, Member> list) {
		Member obj = Search(list);
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

	public static void menu_4(HashMap<String, Member> list) {
		Member obj = Search(list);
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

	public static void menu_5(HashMap<String, Member> list) {
		Member obj = Search(list);
		if (obj == null) {
			return;
		}
		System.out.println("회원정보 삭제 성공\n");
		list.remove(obj.irum);
	}

}
