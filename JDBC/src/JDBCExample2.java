import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	public static void main(String args[]) {
		// 3개 다 클로즈가 필요해서 try문 밖 선언했음
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Class.forName는 고정
			// conn = DriverManager.getConnection는 고정
			// conn.close는 고정
			
			// 대소문자 주의, 오라클을 사용할께라는 선언(오라클을 사용하기 위한 준비)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// java와 oracle를 연결하기 위한 객체
			conn = DriverManager.getConnection(
					// 127.0.0.1 = 루프백
					// 1521 = 오라클포트넘버
					// orcl = 포트 SID
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
			// sql구문을 실행하는 기능을 가진 객체 생성(sql구문을 실행하기 위한 준비)
			stmt = conn.createStatement();
			// Query는 select을 실행하여 결과를 rs에 저장(couser를 생각하자)
			rs = stmt.executeQuery(
					"select code, name, price, maker"
					+ " from goodsinfo"
					+ " where price >= 300000");
			System.out.println("상품코드 상품명 \t\t 가격 제조사");
			System.out.println("----------------------------------------");
			// rs.next()를 실행하게 되면 다음행으로 이동하며 데이터가 있으면 true, 없으면 false
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				stmt.close();
			} catch(Exception ignored) {
			}
			try{
				conn.close();
			} catch(Exception ignored) {
			}
		}
	}
}
