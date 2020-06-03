import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExam2 {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// �ԷµǾ�� �ϴ� ���� '?'�� ǥ���Ѵ�
		String sql = "insert into member"
				+ " values(?,?,?,?)";
		String hakbun, name, addr, phone;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �߰��ϱ� ...");
			System.out.print("�й� �Է� : ");
			hakbun = br.readLine();
			System.out.print("�̸� �Է� : ");
			name = br.readLine();
			System.out.print("�ּ� �Է� : ");
			addr= br.readLine();
			System.out.print("��ȭ��ȣ �Է� : ");
			phone = br.readLine();
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			// ������ �Է��� sql���� �����ų �غ� �Ѵ�
			pstmt = con.prepareStatement(sql);
			// ?�� �Է� �Ϳ� �� ����
			pstmt.setString(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try{
				// ��Ŵ� �߸��� �����. JDBCExample3 Ŭ������ ��������
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(br != null) {
					br.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
