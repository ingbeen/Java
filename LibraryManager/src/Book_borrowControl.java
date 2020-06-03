import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_borrowControl {
	// ���θ޼ҵ忡�� ������ �����ͺ��̽��� ���޹���
	static Connection con = RunProgram.con;
	
	// ��������
	static void bookLending() {
		// �Է°� �ޱ�
		Book_borrow obj = new Book_borrow();
		obj.inputData();
		
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		try {
			// �Է¹��� ȸ����ȣ�� ȸ���̸� ����
			// �Է¹��� ������ȣ�� ������ ����
			cstmt1 = con.prepareCall("{call lending_namecheck(?, ?, ?, ?)}");
			cstmt1.setString(1, obj.m_number);
			cstmt1.setString(2, obj.b_number);
			cstmt1.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt1.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt1.executeUpdate();
			obj.m_name = cstmt1.getString(3);
			obj.b_name = cstmt1.getString(4);
			
			// (ȸ����ȣ�� �̸�), (������ȣ�� ������) ��ġ�ϴ��� ����ڰ� Ȯ��
			boolean key = false;
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("ȸ����ȣ : " + obj.m_number + " / ȸ���̸� : " + obj.m_name);
				System.out.println("������ȣ : " + obj.b_number + " / ������ : " + obj.b_name);
				System.out.print("���� ȸ�������� ���������� ��ġ�ϳ���? (Y / N) => ");
				String check = scan.next();
				System.out.println();
				if (check.toUpperCase().equals("Y")) {
					key = true;
					break;
				} else if(check.toUpperCase().equals("N")) {
					break;
				} else {
					System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
				}
			}
			
			// ����ڰ� �Է��� ���� ���� ���࿩�� ����
			if(!key) {
				return;
			}
			
			// Ȯ�ε� ȸ���� ������ ������ �������� Ȯ�� �� �������� �Է�
			// ȸ���� ���Ⱑ�ɱǼ� ����, ������ �����ȣ ����
			cstmt2 = con.prepareCall("{call book_lending(?, ?, ?, ?)}");
			cstmt2.setString(1, obj.m_number);
			cstmt2.setString(2, obj.m_name);
			cstmt2.setString(3, obj.b_number);
			cstmt2.setString(4, obj.b_name);
			cstmt2.executeUpdate();
			System.out.println("�������� ����!!\n");
		} catch(Exception e) {
			System.out.println("�������� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt1.close();
			} catch (Exception ignored) {
			}
			try {
				cstmt2.close();
			} catch (Exception ignored) {
			}
		}
	}	
	
	
	// �����ݳ�
	static void bookReturn() {
		// �Է°� �ޱ�
		Book_borrow obj = new Book_borrow();
		obj.inputData();
		
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		try {
			// �Է¹��� ȸ����ȣ�� ȸ���̸� ����
			// �Է¹��� ������ȣ�� ������ ����
			cstmt1 = con.prepareCall("{call lending_namecheck(?, ?, ?, ?)}");
			cstmt1.setString(1, obj.m_number);
			cstmt1.setString(2, obj.b_number);
			cstmt1.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt1.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt1.executeUpdate();
			obj.m_name = cstmt1.getString(3);
			obj.b_name = cstmt1.getString(4);
			
			// (ȸ����ȣ�� �̸�), (������ȣ�� ������) ��ġ�ϴ��� ����ڰ� Ȯ��
			boolean key = false;
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("ȸ����ȣ : " + obj.m_number + " / ȸ���̸� : " + obj.m_name);
				System.out.println("������ȣ : " + obj.b_number + " / ������ : " + obj.b_name);
				System.out.print("���� ȸ�������� ���������� ��ġ�ϳ���? (Y / N) => ");
				String check = scan.next();
				System.out.println();
				if (check.toUpperCase().equals("Y")) {
					key = true;
					break;
				} else if(check.toUpperCase().equals("N")) {
					break;
				} else {
					System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
				}
			}
			
			// ����ڰ� �Է��� ���� ���� ���࿩�� ����
			if(!key) {
				return;
			}
			
			// ���� �������� ������ �� ȸ����ȣ�� ������ȣ�� �����Ͽ� �����ȣ ����
			// �ش� ȸ���� �ݳ��ϴ� �����ȣ ����, ���Ⱑ�ɱǼ� ����
			// �ش� ������ �����ȣ ����
			// ���������� �ݳ��� ����
			cstmt2 = con.prepareCall("{call book_return(?, ?)}");
			cstmt2.setString(1, obj.m_number);
			cstmt2.setString(2, obj.b_number);
			cstmt2.executeUpdate();
			System.out.println("�����ݳ� ����!!\n");
		} catch(Exception e) {
			System.out.println("�����ݳ� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt1.close();
			} catch (Exception ignored) {
			}try {
				cstmt2.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	
	// ���� �������� ��ȸ
	static void searchLending() {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			Scanner scan = new Scanner(System.in);
			int choice;
			String number;
			while(true) {
				// �˻��� ����Ϸ��� �׸� ����
				System.out.println("� �׸����� �˻��Ͻðڽ��ϱ�?");
				System.out.println("1. �����ȣ");
				System.out.println("2. ȸ����ȣ");
				System.out.println("3. ������ȣ");
				System.out.print("�׸� ���� => ");
				
				// �׸��ð� ���� �˻�
				try {
					choice = scan.nextInt();
				} catch(InputMismatchException ime) {
					System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
					scan.nextLine();
					continue;
				}
				
				// ������ �׸� ���� ����
				if (choice == 1) {
					System.out.print("�����ȣ �Է� => ");
					number = scan.next();
					System.out.println();
					break;
				} else if(choice == 2) {
					System.out.print("ȸ����ȣ �Է� => ");
					number = scan.next();
					System.out.println();
					break;
				} else if(choice == 3) {
					System.out.print("������ȣ �Է� => ");
					number = scan.next();
					System.out.println();
					break;
				}
				System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
			}
			
			// in : �˻��� ����Ϸ��� �׸��ȣ, �ش� �׸񿡼� ��ȸ�Ϸ��� ��ȣ
			// out : ��ȸ�� �������� �� ����, ��ȸ�� �����Ͱ�
			Book_borrow obj = new Book_borrow();
			cstmt = con.prepareCall("{call lending_search(?, ?, ?, ?)}");
			cstmt.setInt(1, choice);
			cstmt.setString(2, number);
			cstmt.registerOutParameter(3, OracleTypes.NUMBER);
			cstmt.registerOutParameter(4, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			// ������ ���� üũ
			if(cstmt.getInt(3) == 0) {
				System.out.println("��°����� �����Ͱ� �����ϴ�\n");
				return;
			}
			
			// Ŀ����ü �Ҵ�
			rs = (ResultSet) cstmt.getObject(4);
			System.out.println("\t\t                 *** ������������ ***");
			System.out.println("==================================================================================");
			System.out.printf("%-10s\tȸ����ȣ\t�̸�\t������ȣ\t%-28s\t%-15s\t�ݳ���\n", "�����ȣ", "������", "������");
			System.out.println("==================================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.returndate = rs.getString("returndate");
				if (!(obj.returndate == null)) {
					obj.returndate = obj.returndate.substring(0, 10);
				}
				obj.outputData_all();
			}
			System.out.println("==================================================================================\n");
		} catch(Exception e) {
			System.out.println("������������ ��ȸ ����!!\n" + e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {
			}
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	
	// ���� �������� ����
	static void lendingList() {
		// ������ üũ ���ν���
		CallableStatement cstmt_check = null;
		
		// ������ ��� ���ν���
		CallableStatement cstmt_output = null;
		
		// Ŀ����ü
		ResultSet rs = null;
		
		try {
			// ������ ���� üũ
			// ��ü ������ ������ ���޹޾� �� ���� 0�̸� �޼ҵ� ����
			cstmt_check = con.prepareCall("{call lending_list_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("��°����� �����Ͱ� �����ϴ�\n");
				return;
			}
			
			// ������ ���
			// ��ü �����͸� Ŀ����ü�� �޾Ƽ� ���
			Book_borrow obj = new Book_borrow();
			cstmt_output = con.prepareCall("{call lending_list(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t       *** �������� ������������ ***");
			System.out.println("==================================================================");
			System.out.printf("%-10s\tȸ����ȣ\t�̸�\t������ȣ\t%-28s\t������\n", "�����ȣ", "������");
			System.out.println("==================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.outputData();
			}
			System.out.println("==================================================================\n");
		} catch (Exception e) {
			System.out.println("������������ ��� ����!!\n" + e.getMessage());
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_check.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_output.close();
			} catch(Exception ignored) {
			}
		}
	}
	
	
	// ���� �������� ����
	static void all_LendingList() {
		// ������ üũ ���ν���
		CallableStatement cstmt_check = null;
		
		// ������ ��� ���ν���
		CallableStatement cstmt_output = null;
		
		// Ŀ����ü
		ResultSet rs = null;
		
		try {
			// ������ ���� üũ
			// ��ü ������ ������ ���޹޾� �� ���� 0�̸� �޼ҵ� ����
			cstmt_check = con.prepareCall("{call all_lending_list_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("��°����� �����Ͱ� �����ϴ�\n");
				return;
			}
			
			// ������ ���
			// ��ü �����͸� Ŀ����ü�� �޾Ƽ� ���
			Book_borrow obj = new Book_borrow();
			cstmt_output = con.prepareCall("{call all_lending_list(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t                *** ���� ������������ ***");
			System.out.println("==================================================================================");
			System.out.printf("%-10s\tȸ����ȣ\t�̸�\t������ȣ\t%-28s\t%-15s\t�ݳ���\n", "�����ȣ", "������", "������");
			System.out.println("==================================================================================");
			while(rs.next()) {
				obj.lending_number = rs.getString("lending_number");
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.loandate = rs.getString("loandate").substring(0, 10);
				obj.returndate = rs.getString("returndate");
				if (!(obj.returndate == null)) {
					obj.returndate = obj.returndate.substring(0, 10);
				}
				obj.outputData_all();
			}
			System.out.println("==================================================================================\n");
		} catch (Exception e) {
			System.out.println("������������ ��� ����!!\n" + e.getMessage());
		} finally {
			try{
				rs.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_check.close();
			} catch(Exception ignored) {
			}
			try{
				cstmt_output.close();
			} catch(Exception ignored) {
			}
		}
	}
}
