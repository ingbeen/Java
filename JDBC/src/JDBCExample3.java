import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3 {
	// BufferedReader�� ����ϸ� 
	// ��Ʈ�����κ��� �̸� ���ۿ� ���� ���� ������ ���� ȿ������ ������� �����ϴ�
	// ����ƽ �Ⱦ��� ���θ޼ҵ� �ȿ��� �����Ҽ� ������ ��� try �ۿ� �����ϴ� ���� ����
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
			
			System.out.print("��ȸ�� ��ǰ�̸� �Է� => ");
			String irum = in.readLine();
			
			// Query�� select�� �����Ͽ� ����� rs�� ����(couser�� ��������)
			rs = stmt.executeQuery(
					"select code, name, price, maker"
					+ " from goodsinfo"
					+ " where name ='" + irum + "'");
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
		} catch (Exception e) {
			e.printStackTrace();
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
