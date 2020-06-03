import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExam {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		
		String sql = "delete from member";
		String hakbun;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 삭제하기 ...");
			System.out.print("삭제할 학번 입력 : ");
			hakbun = br.readLine();
			
			sql += " where hakbun = '" + hakbun + "'";
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			// 자동으로 커밋되는 것을 방지
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터베이스 연결 성공!");
			// 커밋 실행
			con.commit();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try{
				stmt.close();
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
