import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExam2 {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 입력되어야 하는 값을 '?'로 표시한다
		String sql = "insert into member"
				+ " values(?,?,?,?)";
		String hakbun, name, addr, phone;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 추가하기 ...");
			System.out.print("학번 입력 : ");
			hakbun = br.readLine();
			System.out.print("이름 입력 : ");
			name = br.readLine();
			System.out.print("주소 입력 : ");
			addr= br.readLine();
			System.out.print("전화번호 입력 : ");
			phone = br.readLine();
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			// 기존에 입력한 sql문을 실행시킬 준비를 한다
			pstmt = con.prepareStatement(sql);
			// ?로 입력 것에 값 대입
			pstmt.setString(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			System.out.println("데이터베이스 연결 성공!");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try{
				// 요거는 잘못된 방식임. JDBCExample3 클래스를 참조하자
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(br != null) {
					br.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
