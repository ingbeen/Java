import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_infoControl {
	// ���θ޼ҵ忡�� ������ �����ͺ��̽��� ���޹���
	static Connection con = RunProgram.con;
	
	// �������� �Է�
	static void insert() {
		// �Է°� �ޱ�
		Book_info obj = new Book_info();
		obj.inputData();
		
		CallableStatement cstmt = null;
		try {
			// ���ν��� ȣ��
			// �Է¹��� ������ȣ, ������, ����, ���ǻ縦 ���ν����� ����
			cstmt = con.prepareCall("{call book_insert(?, ?, ?, ?)}");
			cstmt.setString(1, obj.b_number);
			cstmt.setString(2, obj.b_name);
			cstmt.setString(3, obj.author);
			cstmt.setString(4, obj.publishing_company);
			cstmt.executeUpdate();
			System.out.println("�������� �Է� ����!!\n");
		} catch(Exception e) {
			System.out.println("�������� �Է� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// �������� ���
	static void select() {
		// ������ üũ ���ν���
		CallableStatement cstmt_check = null;
		
		// ������ ��� ���ν���
		CallableStatement cstmt_output = null;
		
		// Ŀ����ü
		ResultSet rs = null;
		
		try {
			// ������ ���� üũ
			// ��ü ������ ������ ���޹޾� �� ���� 0�̸� �޼ҵ� ����
			cstmt_check = con.prepareCall("{call book_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("��°����� �����Ͱ� �����ϴ�\n");
				return;
			}
			
			// ������ ���
			// ��ü �����͸� Ŀ����ü�� �޾Ƽ� ���
			Book_info obj = new Book_info();
			cstmt_output = con.prepareCall("{call book_select(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t          *** �������� ***");
			System.out.println("=======================================================");
			System.out.printf("������ȣ\t%-28s\t%-16s\t%s\t�����ȣ\n", "������", "����", "���ǻ�");
			System.out.println("=======================================================");
			while(rs.next()) {
				obj.b_number = rs.getString("b_number");
				obj.b_name = rs.getString("b_name");
				obj.author = rs.getString("author");
				obj.publishing_company = rs.getString("publishing_company");
				obj.lending_number = rs.getString("lending_number");
				obj.outputData();
			}
			System.out.println("=======================================================\n");
		} catch (Exception e) {
			System.out.println("�������� ��� ����!!\n" + e.getMessage());
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
	
	// �������� ��ȸ
	static void search() {
		CallableStatement cstmt = null;
		try {
			// ��ȸ�Ϸ��� ������ȣ �Է�
			String choice = searchNumber("��ȸ");
			
			// ���ν��� ȣ��
			// �Է¹��� ������ȣ�� �ش� �����͸� ����
			cstmt = con.prepareCall("{call book_search(?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.registerOutParameter(2, OracleTypes.CHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(6, OracleTypes.VARCHAR);
			cstmt.executeQuery();
			
			// �����͸� obj��ü�� ����
			Book_info obj = new Book_info();
			obj.b_number = cstmt.getString(2);
			obj.b_name = cstmt.getString(3);
			obj.author = cstmt.getString(4);
			obj.publishing_company = cstmt.getString(5);
			obj.lending_number = cstmt.getString(6);
			
			// ������ ���
			System.out.println("\t\t          *** �������� ***");
			System.out.println("=======================================================");
			System.out.printf("������ȣ\t%-28s\t%-16s\t%s\t�����ȣ\n", "������", "����", "���ǻ�");
			System.out.println("=======================================================");
			obj.outputData();
			System.out.println("=======================================================\n");
		} catch(Exception e) {
			System.out.println("�������� ��ȸ ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// �������� ����
	static void update() {
		CallableStatement cstmt = null;
		try {
			// �����Ϸ��� ������ȣ �Է�
			String choice = searchNumber("����");
			
			// ������ �Է�
			Scanner scan = new Scanner(System.in);
			System.out.print("������ �Է� => ");
			String b_name = scan.next();
			System.out.print("���� �Է� => ");
			String author = scan.next();
			System.out.print("���ǻ� �Է� => ");
			String publishing_company = scan.next();
			System.out.println();
			
			// ���ν��� ȣ��
			// �Է¹��� �������� ���ν����� �����Ͽ� update
			cstmt = con.prepareCall("{call book_update(?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.setString(2, b_name);
			cstmt.setString(3, author);
			cstmt.setString(4, publishing_company);
			cstmt.executeUpdate();
			System.out.println("�������� ���� ����!!\n");
		} catch(Exception e) {
			System.out.println("�������� ���� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// �������� ����
	static void delete() {
		CallableStatement cstmt = null;
		try {
			// �����Ϸ��� ������ȣ �Է�
			String choice = searchNumber("����");
			
			// ���ν��� ȣ��
			// �Է¹��� ������ȣ�� �ش� ������ ����
			cstmt = con.prepareCall("{call book_delete(?)}");
			cstmt.setString(1, choice);
			cstmt.executeUpdate();
			System.out.println("�������� ���� ����!!\n");
		} catch(Exception e) {
			System.out.println("�������� ���� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ��ȸ, ����, ������ ȣ��� ������ȣ ���ñ��
	static String searchNumber(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print(str + "�� ������ȣ�� �Է��ϼ��� => ");
		String choice = scan.next();
		System.out.println();
		return choice;
	}
}
