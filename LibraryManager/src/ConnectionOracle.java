import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionOracle {
	// ���� �޼ҵ� ����� ����õ�
	static Connection DB() {
		Connection con = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	        Class.forName(driver);
	        con = DriverManager.getConnection(url, "scott", "123456");	
		} catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		}
		return con;
	}
}
