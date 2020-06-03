/*
	create or replace procedure call_insert(
    hakbun member.hakbun%type,
    name member.name%type,
    addr member.addr%type,
    phone member.phone%type)
is
begin
    insert into member
    values (hakbun, name, addr, phone);
end;
/
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertExam_CALL {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 추가하기..");
			System.out.print("학번 입력 => ");
			String hakbun = br.readLine();
			System.out.print("이름 입력 => ");
			String name = br.readLine();
			System.out.print("주소 입력 => ");
			String addr = br.readLine();
			System.out.print("전화번호 입력 => ");
			String phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			cstmt = con.prepareCall("{call call_insert(?, ?, ?, ?)}");
			
			// 입력받은 hakbun을 프로시저에 전달
			cstmt.setString(1, hakbun);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			
			// 프로시저 실행
			cstmt.executeUpdate();
			System.out.println("데이터베이스 연결 성공!");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		} finally {
			try{
				br.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt.close();
			} catch(Exception ignored) {
			}
			try{
				con.close();
			} catch(Exception ignored) {
			}
		}
	}
}
