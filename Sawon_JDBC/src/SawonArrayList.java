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
	
	// �����ͺ��̽� ����(�̱���)
	static Connection con = connectionDB();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//�޴�����
		while(true) {
			
			// �޴� ���
			int menu;
			System.out.println("*** �޴� ***");
			System.out.println("1. ������� �Է�");
			System.out.println("2. ������� ���");
			System.out.println("3. ������� ��ȸ");
			System.out.println("4. ������� ����");
			System.out.println("5. ������� ����");
			System.out.println("6. ���α׷� ����");
			System.out.print("�޴� ���� => ");
			
			// �޴����ð� �����˻�
			try {
				menu = scan.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n�ٽ� �Է����ּ���\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
			
			// �޴����ð� ����
			if(menu == 6) {
				System.out.println("�̿��� �ּż� �����մϴ�");
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

	// �����ͺ��̽� ����
	private static Connection connectionDB() {
		Connection con = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
	        Class.forName(driver);
	        con = DriverManager.getConnection(url, "scott", "123456");	
		} catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		}
		return con;
	}
	
	// ������� �Է�
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
				System.out.println("\n������� �Է� ����!!\n");
			}
		} catch(Exception e) {
			System.out.println("\n������ �Է� ����! = " + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ������� ���
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
				System.out.println("����� �����Ͱ� �����ϴ�!!\n");
			} else {
				pstmt2 = con.prepareStatement(Allsearch_sql);
				rs2 = pstmt2.executeQuery();
				
				System.out.printf("\t\t*** ������� ***\n");
				System.out.println("==============================================");
				System.out.printf("���\t�μ���\t�̸�\t����\t�̸���\n");
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
            System.out.println("�����ͺ��̽� ���� ����! = "+e.getMessage());
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
	
	// ������� ��ȸ
	static void search_sawon()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("��ȸ�� ��� �Է�  => ");
			String sabun = scan.next();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	System.out.println();
				System.out.println("�й� : " + rs.getString("sabun"));
				System.out.println("�̸� : " + rs.getString("deptname"));
				System.out.println("���� : " + rs.getString("irum"));
				System.out.println("���� : " + rs.getString("gender"));
				System.out.println("���� : " + rs.getString("email") + "\n");
	        }
	        else {
	        	System.out.println("\n����� �����Ͱ� �����ϴ�!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����! = "+e.getMessage());
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
	
	// ������� ����
	static void update_sawon()
	{
		Sawon obj = new Sawon();
		
		PreparedStatement pstmt = null;
		String sql = "update sawon set deptname=?, irum=?, gender=?, email=?"
				   + " where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("������ ��� �Է�  => ");
			obj.sabun = scan.next();
			System.out.print("�μ����Է� => ");
			obj.deptname = scan.next();
			System.out.print("�̸� �Է� => ");
			obj.irum = scan.next();
			System.out.print("���� �Է� => ");
			obj.gender = scan.next();
			System.out.print("�̸��� �Է� => ");
			obj.email = scan.next();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.deptname);
			pstmt.setString(2, obj.irum);
			pstmt.setString(3, obj.gender);
			pstmt.setString(4, obj.email);
			pstmt.setString(5, obj.sabun);
	        int res = pstmt.executeUpdate();
	        if (res == 1) {
	        	System.out.println("\n" + obj.sabun + " ��� ���� �Ϸ�!!!\n");
	        }
	        else {
	        	System.out.println("\n�������� �ʴ� ����Դϴ�!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����! = "+e.getMessage());
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
	
	// ������� ����
	static void delete_sawon()
	{
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where sabun=?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("������ ��� �Է�  => ");
			String sabun = scan.next();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
	        int res = pstmt.executeUpdate();
	        if (res == 1) {
	        	System.out.println("\n" + sabun + " ��� ���� �Ϸ�!!!\n");
	        }
	        else {
	        	System.out.println("\n�������� �ʴ� ����Դϴ�!!!\n");
	        }
		}
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����! = "+e.getMessage());
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