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
			System.out.println("Member ���̺� �� �����ϱ� ...");
			System.out.print("������ �й� �Է� : ");
			hakbun = br.readLine();
			
			sql += " where hakbun = '" + hakbun + "'";
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			// �ڵ����� Ŀ�ԵǴ� ���� ����
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("�����ͺ��̽� ���� ����!");
			// Ŀ�� ����
			con.commit();
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
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
