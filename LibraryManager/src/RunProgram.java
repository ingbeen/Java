import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgram {
	// 데이터베이스 연결(싱글톤)
	// 메인 메소드 실행시 연결시도
	static Connection con = ConnectionOracle.DB();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int menu;
		
		main :
		while(true) {
			// 메인메뉴
			System.out.println("*** 메인 메뉴 ***");
			System.out.println("1. 회원정보");
			System.out.println("2. 도서정보");
			System.out.println("3. 도서대출정보");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택  => ");
			
			// 메뉴선택값 오류 검사(이하 동일)
			try {
				menu = scan.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("\n잘못된 값을 입력하셨습니다\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
				
			// 1번 회원정보관리
			if(menu == 1) {
				while(true) {
					System.out.println("*** 회원정보관리 ***");
					System.out.println("1. 회원정보 입력");
					System.out.println("2. 회원정보 출력");
					System.out.println("3. 회원정보 조회");
					System.out.println("4. 회원정보 수정");
					System.out.println("5. 회원정보 삭제");
					System.out.println("6. 상위 메뉴");
					System.out.print("메뉴 선택  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n잘못된 값을 입력하셨습니다\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_memberControl.insert();
					} else if(menu == 2) {
						Book_memberControl.select();
					} else if(menu == 3) {
						Book_memberControl.search(); 
					} else if(menu == 4) {
						Book_memberControl.update(); 
					} else if(menu == 5) {
						Book_memberControl.delete(); 
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("잘못된 값을 입력하셨습니다\n");
					}
				}
				
			// 2번 도서정보관리
			} else if(menu == 2) {
				while(true) {
					System.out.println("*** 도서정보관리 ***");
					System.out.println("1. 도서정보 입력");
					System.out.println("2. 도서정보 출력");
					System.out.println("3. 도서정보 조회");
					System.out.println("4. 도서정보 수정");
					System.out.println("5. 도서정보 삭제");
					System.out.println("6. 상위 메뉴");
					System.out.print("메뉴 선택  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n잘못된 값을 입력하셨습니다\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_infoControl.insert();
					} else if(menu == 2) {
						Book_infoControl.select();
					} else if(menu == 3) {
						Book_infoControl.search(); 
					} else if(menu == 4) {
						Book_infoControl.update(); 
					} else if(menu == 5) {
						Book_infoControl.delete(); 
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("잘못된 값을 입력하셨습니다\n");
					}
				}
				
			// 3번 도서대출관리
			} else if(menu == 3) {
				while(true) {
					System.out.println("*** 도서대출관리 ***");
					System.out.println("1. 도서대출");
					System.out.println("2. 도서반납");
					System.out.println("3. 도서 대출정보 조회");
					System.out.println("4. 현재 대출중인 도서");
					System.out.println("5. 통합 도서대출 내역");
					System.out.println("6. 상위 메뉴");
					System.out.print("메뉴 선택  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n잘못된 값을 입력하셨습니다\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_borrowControl.bookLending();
					} else if(menu == 2) {
						Book_borrowControl.bookReturn();
					} else if(menu == 3) {
						Book_borrowControl.searchLending();
					} else if(menu == 4) {
						Book_borrowControl.lendingList();
					} else if(menu == 5) {
						Book_borrowControl.all_LendingList();
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("잘못된 값을 입력하셨습니다\n");
					}
				}
			
			// 4번 프로그램 종료
			} else if(menu == 4) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다\n");
			}
		}
	}
}
