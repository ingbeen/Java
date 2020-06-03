import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			// ��ҹ��� ����
			// Class.forName�� ����
			// conn = DriverManager.getConnection�� ����
			// conn.close�� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					// 127.0.0.1 = ������
					// 1521 = ����Ŭ��Ʈ�ѹ�
					// orcl = ��Ʈ SID
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
			System.out.println("�����ͺ��̽��� �����߽��ϴ�.");
			conn.close();	
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
