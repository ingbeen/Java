import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionOracle {
	// 메인 메소드 실행시 연결시도
	static Connection DB() {
		Connection con = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	        Class.forName(driver);
	        con = DriverManager.getConnection(url, "scott", "123456");	
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}
}
