/*
create table member(
    hakbun char(4) primary key,
    name varchar2(10),
    addr varchar2(10),
    phone char(13)
);

create or replace procedure call_select(
    -- 커서개체를 외부로 반환(전달)할 때
    v_member_cursor out sys_refcursor
)
is
begin
    -- select의 결과를 v_member_cousor로 오픈시킴 후에 out(전달)시킴, 동적커서
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
		// 오라클에 있는 함수나 프로시저를 호출하기 위한
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			// 드라이브 로드
			Class.forName(driver);
			// 연결객체 생성
			con = DriverManager.getConnection(url, "scott", "123456");
			
			// call 함수나 프로시저를 호출
			// call_select 함수 & 프로시저 이름
			cstmt = con.prepareCall("{call call_select(?)}");
			
			// 함수나 프로시저에서 전달받은 파라미터를 받기 위해서는
			// 1 위의 con.preoareCall의 ?
			// OracleTypes.CURSOR 'cursor타입을 받아 온다'라는 뜻
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			// 1번(커서)에 해당하는 객체를 받아와서 ResultSet 객체로 캐스팅 해서 저장
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
			System.out.println("데이터베이스 연결 실패!");
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
