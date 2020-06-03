/*
	create or replace procedure call_insert(
    hakbun member.hakbun%type,
    name member.name%type,
    addr member.addr%type,
    phone member.phone%type)
is
begin
    insert into member
    values (hakbun, name, addr, phone);
end;
/
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertExam_CALL {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �߰��ϱ�..");
			System.out.print("�й� �Է� => ");
			String hakbun = br.readLine();
			System.out.print("�̸� �Է� => ");
			String name = br.readLine();
			System.out.print("�ּ� �Է� => ");
			String addr = br.readLine();
			System.out.print("��ȭ��ȣ �Է� => ");
			String phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			cstmt = con.prepareCall("{call call_insert(?, ?, ?, ?)}");
			
			// �Է¹��� hakbun�� ���ν����� ����
			cstmt.setString(1, hakbun);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			
			// ���ν��� ����
			cstmt.executeUpdate();
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		} finally {
			try{
				br.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt.close();
			} catch(Exception ignored) {
			}
			try{
				con.close();
			} catch(Exception ignored) {
			}
		}
	}
}
