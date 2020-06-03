import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_memberControl {
	// 메인메소드에서 연결한 데이터베이스를 전달받음
	static Connection con = RunProgram.con;
	
	// 회원정보 입력
	static void insert() {
		// 입력값 받기
		Book_member obj = new Book_member();
		obj.inputData();
		
		CallableStatement cstmt = null;
		try {
			// 프로시저 호출
			// 입력받은 회원번호, 이름, 연락처, 이메일을 프로시저에 전달
			cstmt = con.prepareCall("{call member_insert(?, ?, ?, ?)}");
			cstmt.setString(1, obj.m_number);
			cstmt.setString(2, obj.m_name);
			cstmt.setString(3, obj.phone);
			cstmt.setString(4, obj.email);
			cstmt.executeUpdate();
			System.out.println("회원정보 입력 성공!!\n");
		} catch(Exception e) {
			System.out.println("회원정보 입력 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 회원정보 출력
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
			cstmt_check = con.prepareCall("{call member_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("출력가능한 데이터가 없습니다\n");
				return;
			}
			
			// 데이터 출력
			// 전체 데이터를 커서객체로 받아서 출력
			Book_member obj = new Book_member();
			cstmt_output = con.prepareCall("{call member_select(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t\t               *** 회원정보 ***");
			System.out.println("==================================================================================================");
			System.out.printf("회원번호\t이름\t%-13s\t%-30s\t대출가능권수\t%-13s\t대출번호(2)\n", "연락처", "이메일", "대출번호(1)");
			System.out.println("==================================================================================================");
			while(rs.next()) {
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.phone = rs.getString("phone");
				obj.email = rs.getString("email");
				obj.lending_max = rs.getInt("lending_max");
				obj.first_lending_number = rs.getString("first_lending_number");
				obj.second_lending_number = rs.getString("second_lending_number");
				obj.outputData();
			}
			System.out.println("==================================================================================================\n");
		} catch (Exception e) {
			System.out.println("회원정보 출력 실패!!\n" + e.getMessage());
			e.printStackTrace();
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
	
	// 회원정보 조회
	static void search() {
		CallableStatement cstmt = null;
		try {
			// 조회하려는 회원번호 입력
			String choice = searchNumber("조회");
			
			// 프로시저 호출
			// 입력받은 회원번호로 해당 데이터를 받음
			cstmt = con.prepareCall("{call member_search(?, ?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.registerOutParameter(2, OracleTypes.CHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(6, OracleTypes.NUMBER);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR);
			cstmt.executeQuery();
			
			// 데이터를 obj객체에 전달
			Book_member obj = new Book_member();
			obj.m_number = cstmt.getString(2);
			obj.m_name = cstmt.getString(3);
			obj.phone = cstmt.getString(4);
			obj.email = cstmt.getString(5);
			obj.lending_max = cstmt.getInt(6);
			obj.first_lending_number = cstmt.getString(7);
			obj.second_lending_number = cstmt.getString(8);
			
			// 데이터 출력
			System.out.printf("\t\t\t               *** %s님의 정보 ***\n", obj.m_name);
			System.out.println("==================================================================================================");
			System.out.printf("회원번호\t이름\t%-13s\t%-30s\t대출가능권수\t%-13s\t대출번호(2)\n", "연락처", "이메일", "대출번호(1)");
			System.out.println("==================================================================================================");
			obj.outputData();
			System.out.println("==================================================================================================\n");
		} catch(Exception e) {
			System.out.println("회원정보 조회 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 회원정보 수정
	static void update() {
		CallableStatement cstmt = null;
		try {
			// 수정하려는 회원번호 입력
			String choice = searchNumber("수정");
			
			// 수정값 입력
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 입력 => ");
			String m_name = scan.next();
			System.out.print("연락처 입력 => ");
			String phone = scan.next();
			System.out.print("이메일 입력 => ");
			String email = scan.next();
			System.out.println();
			
			// 프로시저 호출
			// 입력받은 수정값을 프로시저에 전달하여 update
			cstmt = con.prepareCall("{call member_update(?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.setString(2, m_name);
			cstmt.setString(3, phone);
			cstmt.setString(4, email);
			cstmt.executeUpdate();
			System.out.println("회원정보 수정 성공!!\n");
		} catch(Exception e) {
			System.out.println("회원정보 수정 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 회원정보 삭제
	static void delete() {
		CallableStatement cstmt = null;
		try {
			// 삭제하려는 회원번호 입력
			String choice = searchNumber("삭제");
			
			// 프로시저 호출
			// 입력받은 회원번호로 해당 데이터 삭제
			cstmt = con.prepareCall("{call member_delete(?)}");
			cstmt.setString(1, choice);
			cstmt.executeUpdate();
			System.out.println("회원정보 삭제 성공!!\n");
		} catch(Exception e) {
			System.out.println("회원정보 삭제 실패!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 조회, 수정, 삭제에 호출될 회원번호 선택기능
	static String searchNumber(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print(str + "할 회원번호를 입력하세요 => ");
		String choice = scan.next();
		System.out.println();
		return choice;
	}
}
