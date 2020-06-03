import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam2 {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String sql = "select *"
					+ " from member"
					+ " order by hakbun";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("----------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("hakbun")
						+ "\t" + rs.getString("name")
						+ "\t" + rs.getString("addr")
						+ "\t" + rs.getString("phone") + "\n");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				pstmt.close();
			} catch(Exception ignored) {
			}
			try{
				conn.close();
			} catch(Exception ignored) {
			}
			try{
				in.close();
			} catch(Exception ignored) {
			}
		}
	}
}
