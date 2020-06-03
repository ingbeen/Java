import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			// 대소문자 주의
			// Class.forName는 고정
			// conn = DriverManager.getConnection는 고정
			// conn.close는 고정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					// 127.0.0.1 = 루프백
					// 1521 = 오라클포트넘버
					// orcl = 포트 SID
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
			System.out.println("데이터베이스에 접속했습니다.");
			conn.close();	
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
