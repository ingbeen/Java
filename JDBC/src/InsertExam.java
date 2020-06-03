import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExam {
	public static void main(String args[]) {
		// 고정된 값은 따로 저장
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		
		String sql = "insert into member"
				+ " values";
		String hakbun, name, addr, phone;
		// ResultSet rs = null;는 select일때만 사용(반환은값 결과값(테이블))
		// update, delete, insert의 반환값은 정수임
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 추가하기 ...");
			System.out.print("학번 입력 : ");
			hakbun = br.readLine();
			System.out.print("이름 입력 : ");
			name = br.readLine();
			System.out.print("주소 입력 : ");
			addr= br.readLine();
			System.out.print("전화번호 입력 : ");
			phone = br.readLine();
			
			sql += "('" + hakbun + "', '" + name + "', '" + addr + "', '" + phone + "')";
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, "scott", "123456");
			stmt = con.createStatement();
			// insert를 실행한 행 갯수를 반환
			int res = stmt.executeUpdate(sql);
			if (res == 1) {
				System.out.println("데이터베이스 연결 성공!");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try{
				// 요거는 잘못된 방식임. JDBCExample3 클래스를 참조하자
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
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
