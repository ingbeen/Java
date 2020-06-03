/*
create table member(
    hakbun char(4) primary key,
    name varchar2(10),
    addr varchar2(10),
    phone char(13)
);


create or replace procedure call_search(
    vhakbun in out varchar2,
    vname out varchar2,
    vaddr out varchar2,
    vphone out varchar2)
is
begin
    select hakbun, name, addr, phone
    into vhakbun, vname, vaddr, vphone
    from member
    // 선언을 char으로 했기에 trim으로 공백제거 
    // char형태의 4자리로 받았기에 공백제거를 해야된다
    where trim(hakbun) = vhakbun;
end;
/
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.OracleTypes;

public class SearchExam_CALL {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			
			System.out.print("조회할 학번 입력 => ");
			String hakbun = br.readLine();
			
			cstmt = con.prepareCall("{call call_search(?, ?, ?, ?)}");
			
			// 입력받은 hakbun을 프로시저에 전달
			cstmt.setString(1, hakbun);
			
			// 전달받을 데이터타입 지정
			cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			
			// 프로시저 실행
			cstmt.executeQuery();
			
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("----------------------------------------");
			System.out.println(cstmt.getString(1)
					+ "\t" + cstmt.getString(2)
					+ "\t" + cstmt.getString(3)
					+ "\t" + cstmt.getString(4)
					);
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		} finally {
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
