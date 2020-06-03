import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	public static void main(String args[]) {
		// 3�� �� Ŭ��� �ʿ��ؼ� try�� �� ��������
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Class.forName�� ����
			// conn = DriverManager.getConnection�� ����
			// conn.close�� ����
			
			// ��ҹ��� ����, ����Ŭ�� ����Ҳ���� ����(����Ŭ�� ����ϱ� ���� �غ�)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// java�� oracle�� �����ϱ� ���� ��ü
			conn = DriverManager.getConnection(
					// 127.0.0.1 = ������
					// 1521 = ����Ŭ��Ʈ�ѹ�
					// orcl = ��Ʈ SID
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
			// sql������ �����ϴ� ����� ���� ��ü ����(sql������ �����ϱ� ���� �غ�)
			stmt = conn.createStatement();
			// Query�� select�� �����Ͽ� ����� rs�� ����(couser�� ��������)
			rs = stmt.executeQuery(
					"select code, name, price, maker"
					+ " from goodsinfo"
					+ " where price >= 300000");
			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
			System.out.println("----------------------------------------");
			// rs.next()�� �����ϰ� �Ǹ� ���������� �̵��ϸ� �����Ͱ� ������ true, ������ false
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�" + cnfe.getMessage());
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
