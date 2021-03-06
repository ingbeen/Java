import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExam2 {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member"
				+ " set addr = ?, phone = ?"
				+ " where hakbun = ?";
		String hakbun, addr, phone;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 갱신하기 ...");
			System.out.print("갱신할 학번 입력 : ");
			hakbun = br.readLine();
			System.out.print("새 주소 입력 : ");
			addr= br.readLine();
			System.out.print("새 전화번호 입력 : ");
			phone = br.readLine();
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, phone);
			pstmt.setString(3, hakbun);
			pstmt.executeUpdate();
			System.out.println("데이터베이스 연결 성공!");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try{
				pstmt.close();
			} catch(Exception ignored) {
			}
			try{
				con.close();
			} catch(Exception ignored) {
			}
			try{
				br.close();
			} catch(Exception ignored) {
			}
		}
	}
}
