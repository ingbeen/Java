import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_borrowControl {
	// 메인메소드에서 연결한 데이터베이스를 전달받음
	static Connection con = RunProgram.con;
	
	// 도서대출
	static void bookLending() {
		// 입력값 받기
		Book_borrow obj = new Book_borrow();
		obj.inputData();
		
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		try {
			// 입력받은 회원번호로 회원이름 추출
			// 입력받은 도서번호로 도서명 추출
			cstmt1 = con.prepareCall("{call lending_namecheck(?, ?, ?, ?)}");
			cstmt1.setString(1, obj.m_number);
			cstmt1.setString(2, obj.b_number);
			cstmt1.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt1.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt1.executeUpdate();
			obj.m_name = cstmt1.getString(3);
			obj.b_name = cstmt1.getString(4);
			
			// (회원번호와 이름), (도서번호와 도서명) 일치하는지 사용자가 확인
			boolean key = false;
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("회원번호 : " + obj.m_number + " / 회원이름 : " + obj.m_name);
				System.out.println("도서번호 : " + obj.b_number + " / 도서명 : " + obj.b_name);
				System.out.print("위의 회원정보와 도서정보가 일치하나요? (Y / N) => ");
				String check = scan.next();
				System.out.println();
				if (check.toUpperCase().equals("Y")) {
					key = true;
					break;
				} else if(check.toUpperCase().equals("N")) {
					break;
				} else {
					System.out.println("\n잘못된 값을 입력하셨습니다\n");
				}
			}
			
			// 사용자가 입력한 값에 따라 진행여부 결정
			if(!key) {
				return;
			}
			
			// 확인된 회원과 도서가 대출이 가능한지 확인 후 대출정보 입력
			// 회원의 대출가능권수 차감, 도서의 대출번호 삽입
			cstmt2 = con.prepareCall("{call book_lending(?, ?, ?, ?)}");
			cstmt2.setString(1, obj.m_number);
			cstmt2.setString(2, obj.m_name);
			cstmt2.setString(3, obj.b_number);
			cstmt2.setString(4, obj.b_name);
			cstmt2.executeUpdate();
			System.out.println("도서대출 성공!!\n");
		} catch(Exception e) {
			System.out.println("도서대출 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt1.close();
			} catch (Exception ignored) {
			}
			try {
				cstmt2.close();
			} catch (Exception ignored) {
			}
		}
	}	
	
	
	// 도서반납
	static void bookReturn() {
		// 입력값 받기
		Book_borrow obj = new Book_borrow();
		obj.inputData();
		
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		try {
			// 입력받은 회원번호로 회원이름 추출
			// 입력받은 도서번호로 도서명 추출
			cstmt1 = con.prepareCall("{call lending_namecheck(?, ?, ?, ?)}");
			cstmt1.setString(1, obj.m_number);
			cstmt1.setString(2, obj.b_number);
			cstmt1.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt1.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt1.executeUpdate();
			obj.m_name = cstmt1.getString(3);
			obj.b_name = cstmt1.getString(4);
			
			// (회원번호와 이름), (도서번호와 도서명) 일치하는지 사용자가 확인
			boolean key = false;
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("회원번호 : " + obj.m_number + " / 회원이름 : " + obj.m_name);
				System.out.println("도서번호 : " + obj.b_number + " / 도서명 : " + obj.b_name);
				System.out.print("위의 회원정보와 도서정보가 일치하나요? (Y / N) => ");
				String check = scan.next();
				System.out.println();
				if (check.toUpperCase().equals("Y")) {
					key = true;
					break;
				} else if(check.toUpperCase().equals("N")) {
					break;
				} else {
					System.out.println("\n잘못된 값을 입력하셨습니다\n");
				}
			}
			
			// 사용자가 입력한 값에 따라 진행여부 결정
			if(!key) {
				return;
			}
			
			// 현재 대출중인 데이터 중 회원번호와 도서번호를 조합하여 대출번호 추출
			// 해당 회원의 반납하는 대출번호 삭제, 대출가능권수 증가
			// 해당 도서의 대출번호 삭제
			// 대출정보에 반납일 삽입
			cstmt2 = con.prepareCall("{call book_return(?, ?)}");
			cstmt2.setString(1, obj.m_number);
			cstmt2.setString(2, obj.b_number);
			cstmt2.executeUpdate();
			System.out.println("도서반납 성공!!\n");
		} catch(Exception e) {
			System.out.println("도서반납 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt1.close();
			} catch (Exception ignored) {
			}try {
				cstmt2.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	
	// 도서 대출정보 조회
	static void searchLending() {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			Scanner scan = new Scanner(System.in);
			int choice;
			String number;
			while(true) {
				// 검색에 사용하려는 항목 선택
				System.out.println("어떤 항목으로 검색하시겠습니까?");
				System.out.println("1. 대출번호");
				System.out.println("2. 회원번호");
				System.out.println("3. 도서번호");
				System.out.print("항목 선택 => ");
				
				// 항목선택값 오류 검사
				try {
					choice = scan.nextInt();
				} catch(InputMismatchException ime) {
					System.out.println("\n잘못된 값을 입력하셨습니다\n");
					scan.nextLine();
					continue;
				}
				
				// 선택한 항목에 따른 진행
				if (choice == 1) {
					System.out.print("대출번호 입력 => ");
					number = scan.next();
					System.out.println();
					break;
				} else if(choice == 2) {
					System.out.print("회원번호 입력 => ");
					number = scan.next();
					System.out.println();
					break;
				} else if(choice == 3) {
					System.out.print("도서번호 입력 => ");
					number = scan.next();
					System.out.println();
					break;
				}
				System.out.println("\n잘못된 값을 입력하셨습니다\n");
			}
			
			// in : 검색에 사용하려는 항목번호, 해당 항목에서 조회하려는 번호
			// out : 조회한 데이터의 행 갯수, 조회한 데이터값
			Book_borrow obj = new Book_borrow();
			cstmt = con.prepareCall("{call lending_search(?, ?, ?, ?)}");
			cstmt.setInt(1, choice);
			cstmt.setString(2, number);
			cstmt.registerOutParameter(3, OracleTypes.NUMBER);
			cstmt.registerOutParameter(4, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			// 데이터 갯수 체크
			if(cstmt.getInt(3) == 0) {
				System.out.println("출력가능한 데이터가 없습니다\n");
				return;
			}
			
			// 커서객체 할당
			rs = (ResultSet) cstmt.getObject(4);
			System.out.println("\t\t                 *** 도서대출정보 ***");
			System.out.println("==================================================================================");
			System.out.printf("%-10s\t회원번호\t이름\t도서번호\t%-28s\t%-15s\t반납일\n", "대출번호", "도서명", "대출일");
			System.out.println("==================================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.returndate = rs.getString("returndate");
				if (!(obj.returndate == null)) {
					obj.returndate = obj.returndate.substring(0, 10);
				}
				obj.outputData_all();
			}
			System.out.println("==================================================================================\n");
		} catch(Exception e) {
			System.out.println("도서대출정보 조회 실패!!\n" + e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {
			}
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	
	// 현재 대출중인 도서
	static void lendingList() {
		// 데이터 체크 프로시저
		CallableStatement cstmt_check = null;
		
		// 데이터 출력 프로시저
		CallableStatement cstmt_output = null;
		
		// 커서객체
		ResultSet rs = null;
		
		try {
			// 데이터 유무 체크
			// 전체 데이터 갯수를 전달받아 그 값이 0이면 메소드 종료
			cstmt_check = con.prepareCall("{call lending_list_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("출력가능한 데이터가 없습니다\n");
				return;
			}
			
			// 데이터 출력
			// 전체 데이터를 커서객체로 받아서 출력
			Book_borrow obj = new Book_borrow();
			cstmt_output = con.prepareCall("{call lending_list(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t       *** 대출중인 도서대출정보 ***");
			System.out.println("==================================================================");
			System.out.printf("%-10s\t회원번호\t이름\t도서번호\t%-28s\t대출일\n", "대출번호", "도서명");
			System.out.println("==================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.outputData();
			}
			System.out.println("==================================================================\n");
		} catch (Exception e) {
			System.out.println("도서대출정보 출력 실패!!\n" + e.getMessage());
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_check.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_output.close();
			} catch(Exception ignored) {
			}
		}
	}
	
	
	// 통합 도서대출 내역
	static void all_LendingList() {
		// 데이터 체크 프로시저
		CallableStatement cstmt_check = null;
		
		// 데이터 출력 프로시저
		CallableStatement cstmt_output = null;
		
		// 커서객체
		ResultSet rs = null;
		
		try {
			// 데이터 유무 체크
			// 전체 데이터 갯수를 전달받아 그 값이 0이면 메소드 종료
			cstmt_check = con.prepareCall("{call all_lending_list_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("출력가능한 데이터가 없습니다\n");
				return;
			}
			
			// 데이터 출력
			// 전체 데이터를 커서객체로 받아서 출력
			Book_borrow obj = new Book_borrow();
			cstmt_output = con.prepareCall("{call all_lending_list(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t                *** 통합 도서대출정보 ***");
			System.out.println("==================================================================================");
			System.out.printf("%-10s\t회원번호\t이름\t도서번호\t%-28s\t%-15s\t반납일\n", "대출번호", "도서명", "대출일");
			System.out.println("==================================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.returndate = rs.getString("returndate");
				if (!(obj.returndate == null)) {
					obj.returndate = obj.returndate.substring(0, 10);
				}
				obj.outputData_all();
			}
			System.out.println("==================================================================================\n");
		} catch (Exception e) {
			System.out.println("도서대출정보 출력 실패!!\n" + e.getMessage());
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_check.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_output.close();
			} catch(Exception ignored) {
			}
		}
	}
}
