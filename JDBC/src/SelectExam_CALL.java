/*
create table member(
    hakbun char(4) primary key,
    name varchar2(10),
    addr varchar2(10),
    phone char(13)
);

create or replace procedure call_select(
    -- Ŀ����ü�� �ܺη� ��ȯ(����)�� ��
    v_member_cursor out sys_refcursor
)
is
begin
    -- select�� ����� v_member_cousor�� ���½�Ŵ �Ŀ� out(����)��Ŵ, ����Ŀ��
    open v_member_cursor
    for
    select * from member
    order by hakbun;
end;
/
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class SelectExam_CALL {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		// ����Ŭ�� �ִ� �Լ��� ���ν����� ȣ���ϱ� ����
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			// ����̺� �ε�
			Class.forName(driver);
			// ���ᰴü ����
			con = DriverManager.getConnection(url, "scott", "123456");
			
			// call �Լ��� ���ν����� ȣ��
			// call_select �Լ� & ���ν��� �̸�
			cstmt = con.prepareCall("{call call_select(?)}");
			
			// �Լ��� ���ν������� ���޹��� �Ķ���͸� �ޱ� ���ؼ���
			// 1 ���� con.preoareCall�� ?
			// OracleTypes.CURSOR 'cursorŸ���� �޾� �´�'��� ��
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			// 1��(Ŀ��)�� �ش��ϴ� ��ü�� �޾ƿͼ� ResultSet ��ü�� ĳ���� �ؼ� ����
			rs = (ResultSet) cstmt.getObject(1);
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("----------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("hakbun")
						+ "\t" + rs.getString("name")
						+ "\t" + rs.getString("addr")
						+ "\t" + rs.getString("phone"));
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		} finally {
			try{
				rs.close();
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
