import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_infoControl {
	// 메인메소드에서 연결한 데이터베이스를 전달받음
	static Connection con = RunProgram.con;
	
	// 도서정보 입력
	static void insert() {
		// 입력값 받기
		Book_info obj = new Book_info();
		obj.inputData();
		
		CallableStatement cstmt = null;
		try {
			// 프로시저 호출
			// 입력받은 도서번호, 도서명, 저자, 출판사를 프로시저에 전달
			cstmt = con.prepareCall("{call book_insert(?, ?, ?, ?)}");
			cstmt.setString(1, obj.b_number);
			cstmt.setString(2, obj.b_name);
			cstmt.setString(3, obj.author);
			cstmt.setString(4, obj.publishing_company);
			cstmt.executeUpdate();
			System.out.println("도서정보 입력 성공!!\n");
		} catch(Exception e) {
			System.out.println("도서정보 입력 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 도서정보 출력
	static void select() {
		// 데이터 체크 프로시저
		CallableStatement cstmt_check = null;
		
		// 데이터 출력 프로시저
		CallableStatement cstmt_output = null;
		
		// 커서객체
		ResultSet rs = null;
		
		try {
			// 데이터 유무 체크
			// 전체 데이터 갯수를 전달받아 그 값이 0이면 메소드 종료
			cstmt_check = con.prepareCall("{call book_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("출력가능한 데이터가 없습니다\n");
				return;
			}
			
			// 데이터 출력
			// 전체 데이터를 커서객체로 받아서 출력
			Book_info obj = new Book_info();
			cstmt_output = con.prepareCall("{call book_select(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t          *** 도서정보 ***");
			System.out.println("=======================================================");
			System.out.printf("도서번호\t%-28s\t%-16s\t%s\t대출번호\n", "도서명", "저자", "출판사");
			System.out.println("=======================================================");
			while(rs.next()) {
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.author = rs.getString("author");
				obj.publishing_company = rs.getString("publishing_company");
				obj.lending_number = rs.getString("lending_number");
				obj.outputData();
			}
			System.out.println("=======================================================\n");
		} catch (Exception e) {
			System.out.println("도서정보 출력 실패!!\n" + e.getMessage());
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
	
	// 도서정보 조회
	static void search() {
		CallableStatement cstmt = null;
		try {
			// 조회하려는 도서번호 입력
			String choice = searchNumber("조회");
			
			// 프로시저 호출
			// 입력받은 도서번호로 해당 데이터를 받음
			cstmt = con.prepareCall("{call book_search(?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.registerOutParameter(2, OracleTypes.CHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(6, OracleTypes.VARCHAR);
			cstmt.executeQuery();
			
			// 데이터를 obj객체에 전달
			Book_info obj = new Book_info();
			obj.b_number = cstmt.getString(2);
			obj.b_name = cstmt.getString(3);
			obj.author = cstmt.getString(4);
			obj.publishing_company = cstmt.getString(5);
			obj.lending_number = cstmt.getString(6);
			
			// 데이터 출력
			System.out.println("\t\t          *** 도서정보 ***");
			System.out.println("=======================================================");
			System.out.printf("도서번호\t%-28s\t%-16s\t%s\t대출번호\n", "도서명", "저자", "출판사");
			System.out.println("=======================================================");
			obj.outputData();
			System.out.println("=======================================================\n");
		} catch(Exception e) {
			System.out.println("도서정보 조회 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 도서정보 수정
	static void update() {
		CallableStatement cstmt = null;
		try {
			// 수정하려는 도서번호 입력
			String choice = searchNumber("수정");
			
			// 수정값 입력
			Scanner scan = new Scanner(System.in);
			System.out.print("도서명 입력 => ");
			String b_name = scan.next();
			System.out.print("저자 입력 => ");
			String author = scan.next();
			System.out.print("출판사 입력 => ");
			String publishing_company = scan.next();
			System.out.println();
			
			// 프로시저 호출
			// 입력받은 수정값을 프로시저에 전달하여 update
			cstmt = con.prepareCall("{call book_update(?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.setString(2, b_name);
			cstmt.setString(3, author);
			cstmt.setString(4, publishing_company);
			cstmt.executeUpdate();
			System.out.println("도서정보 수정 성공!!\n");
		} catch(Exception e) {
			System.out.println("도서정보 수정 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 도서정보 삭제
	static void delete() {
		CallableStatement cstmt = null;
		try {
			// 삭제하려는 도서번호 입력
			String choice = searchNumber("삭제");
			
			// 프로시저 호출
			// 입력받은 도서번호로 해당 데이터 삭제
			cstmt = con.prepareCall("{call book_delete(?)}");
			cstmt.setString(1, choice);
			cstmt.executeUpdate();
			System.out.println("도서정보 삭제 성공!!\n");
		} catch(Exception e) {
			System.out.println("도서정보 삭제 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 조회, 수정, 삭제에 호출될 도서번호 선택기능
	static String searchNumber(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print(str + "할 도서번호를 입력하세요 => ");
		String choice = scan.next();
		System.out.println();
		return choice;
	}
}
