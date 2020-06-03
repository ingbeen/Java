/*
create table sungjuk (
    hakbun varchar2(4) primary key, 
    irum varchar2(15),
    kor number(3),
    eng number(3),
    math number(3),
    tot number(3),
    avg number(5, 2),
    grade varchar2(4)
);
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SawonArrayList {
	
	// 데이터베이스 연결(싱글톤)
	static Connection con = connectionDB();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//메뉴선택
		while(true) {
			
			// 메뉴 출력
			int menu;
			System.out.println("*** 메뉴 ***");
			System.out.println("1. 사원정보 입력");
			System.out.println("2. 사원정보 출력");
			System.out.println("3. 사원정보 조회");
			System.out.println("4. 사원정보 수정");
			System.out.println("5. 사원정보 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("메뉴 선택 => ");
			
			// 메뉴선택값 오류검사
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n다시 입력해주세요\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
			
			// 메뉴선택값 실행
			if(menu == 6) {
				System.out.println("이용해 주셔서 감사합니다");
				try {
					con.close();
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			} else if (menu == 1){
				input_sawon();
			} else if (menu == 2){
				output_sawon();
			} else if (menu == 3){
				search_sawon();
			} else if (menu == 4){
				update_sawon();
			} else if (menu == 5){
				delete_sawon();
			}
		}
	}

	// 데이터베이스 연결
	private static Connection connectionDB() {
		Connection con = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
	        Class.forName(driver);
	        con = DriverManager.getConnection(url, "scott", "123456");	
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}
	
	// 사원정보 입력
	private static void input_sawon() {
		Sawon obj = new Sawon();
		obj.inputData();
		
		PreparedStatement pstmt = null;
		String insert_sql = "insert into sawon"
				+ " values (?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(insert_sql);
			pstmt.setString(1, obj.sabun);
			pstmt.setString(2, obj.deptname);
			pstmt.setString(3, obj.irum);
			pstmt.setString(4, obj.gender);
			pstmt.setString(5, obj.email);
			int check = pstmt.executeUpdate();
			if (check == 1) {
				System.out.println("\n사원정보 입력 성공!!\n");
			}
		} catch(Exception e) {
			System.out.println("\n데이터 입력 실패! = " + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// 사원정보 출력
	private static void output_sawon() {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		String check_sql = "select count(*) as \"cnt\" from sawon";
		String Allsearch_sql = "select * from sawon"
							+ " order by sabun";
		
		try {
			Sawon obj = new Sawon();
			pstmt1 = con.prepareStatement(check_sql);
			rs1 = pstmt1.executeQuery();
			rs1.next();
			if(rs1.getInt("cnt") == 0) {
				System.out.println("출력할 데이터가 없습니다!!\n");
			} else {
				pstmt2 = con.prepareStatement(Allsearch_sql);
				rs2 = pstmt2.executeQuery();
				
				System.out.printf("\t\t*** 사원정보 ***\n");
				System.out.println("==============================================");
				System.out.printf("사번\t부서명\t이름\t성별\t이메일\n");
				System.out.println("==============================================");
				while(rs2.next())
		        {
		        	obj.sabun = rs2.getString("sabun");
		        	obj.deptname = rs2.getString("deptname");
		        	obj.irum = rs2.getString("irum");
		        	obj.gender = rs2.getString("gender");
		        	obj.email = rs2.getString("email");
		        	obj.outputData();
		        }
				System.out.println("==============================================\n");
			}
		} catch(Exception e) {
            System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
        } finally {
            try {
            	rs1.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
            try {
            	rs2.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
            try {
            	pstmt1.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
            try {
            	pstmt2.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
	
	// 사원정보 조회
	static void search_sawon()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("조회할 사번 입력  => ");
			String sabun = scan.next();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	System.out.println();
				System.out.println("학번 : " + rs.getString("sabun"));
				System.out.println("이름 : " + rs.getString("deptname"));
				System.out.println("국어 : " + rs.getString("irum"));
				System.out.println("영어 : " + rs.getString("gender"));
				System.out.println("수학 : " + rs.getString("email") + "\n");
	        }
	        else {
	        	System.out.println("\n출력할 데이터가 없습니다!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
        }
        finally {
        	try {
            	rs.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
            try {
            	pstmt.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
	
	// 사원정보 수정
	static void update_sawon()
	{
		Sawon obj = new Sawon();
		
		PreparedStatement pstmt = null;
		String sql = "update sawon set deptname=?, irum=?, gender=?, email=?"
				   + " where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("수정할 사번 입력  => ");
			obj.sabun = scan.next();
			System.out.print("부서명입력 => ");
			obj.deptname = scan.next();
			System.out.print("이름 입력 => ");
			obj.irum = scan.next();
			System.out.print("성별 입력 => ");
			obj.gender = scan.next();
			System.out.print("이메일 입력 => ");
			obj.email = scan.next();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.deptname);
			pstmt.setString(2, obj.irum);
			pstmt.setString(3, obj.gender);
			pstmt.setString(4, obj.email);
			pstmt.setString(5, obj.sabun);
	        int res = pstmt.executeUpdate();
	        if (res == 1) {
	        	System.out.println("\n" + obj.sabun + " 사번 수정 완료!!!\n");
	        }
	        else {
	        	System.out.println("\n존재하지 않는 사번입니다!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
        }
        finally {
        	try {
            	pstmt.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
	
	// 사원정보 삭제
	static void delete_sawon()
	{
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where sabun=?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("삭제할 사번 입력  => ");
			String sabun = scan.next();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
	        int res = pstmt.executeUpdate();
	        if (res == 1) {
	        	System.out.println("\n" + sabun + " 사번 삭제 완료!!!\n");
	        }
	        else {
	        	System.out.println("\n존재하지 않는 사번입니다!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
        }
        finally {
        	try {
            	pstmt.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage( ));
            }
        }
	}
}