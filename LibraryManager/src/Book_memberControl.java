import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Book_memberControl {
	// ���θ޼ҵ忡�� ������ �����ͺ��̽��� ���޹���
	static Connection con = RunProgram.con;
	
	// ȸ������ �Է�
	static void insert() {
		// �Է°� �ޱ�
		Book_member obj = new Book_member();
		obj.inputData();
		
		CallableStatement cstmt = null;
		try {
			// ���ν��� ȣ��
			// �Է¹��� ȸ����ȣ, �̸�, ����ó, �̸����� ���ν����� ����
			cstmt = con.prepareCall("{call member_insert(?, ?, ?, ?)}");
			cstmt.setString(1, obj.m_number);
			cstmt.setString(2, obj.m_name);
			cstmt.setString(3, obj.phone);
			cstmt.setString(4, obj.email);
			cstmt.executeUpdate();
			System.out.println("ȸ������ �Է� ����!!\n");
		} catch(Exception e) {
			System.out.println("ȸ������ �Է� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ȸ������ ���
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
			cstmt_check = con.prepareCall("{call member_check(?)}");
			cstmt_check.registerOutParameter(1, OracleTypes.NUMBER);
			cstmt_check.executeQuery();
			if(cstmt_check.getInt(1) == 0) {
				System.out.println("��°����� �����Ͱ� �����ϴ�\n");
				return;
			}
			
			// ������ ���
			// ��ü �����͸� Ŀ����ü�� �޾Ƽ� ���
			Book_member obj = new Book_member();
			cstmt_output = con.prepareCall("{call member_select(?)}");
			cstmt_output.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt_output.executeQuery();
			rs = (ResultSet) cstmt_output.getObject(1);
			System.out.println("\t\t\t               *** ȸ������ ***");
			System.out.println("==================================================================================================");
			System.out.printf("ȸ����ȣ\t�̸�\t%-13s\t%-30s\t���Ⱑ�ɱǼ�\t%-13s\t�����ȣ(2)\n", "����ó", "�̸���", "�����ȣ(1)");
			System.out.println("==================================================================================================");
			while(rs.next()) {
				obj.m_number = rs.getString("m_number");
				obj.m_name = rs.getString("m_name");
				obj.phone = rs.getString("phone");
				obj.email = rs.getString("email");
				obj.lending_max = rs.getInt("lending_max");
				obj.first_lending_number = rs.getString("first_lending_number");
				obj.second_lending_number = rs.getString("second_lending_number");
				obj.outputData();
			}
			System.out.println("==================================================================================================\n");
		} catch (Exception e) {
			System.out.println("ȸ������ ��� ����!!\n" + e.getMessage());
			e.printStackTrace();
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
	
	// ȸ������ ��ȸ
	static void search() {
		CallableStatement cstmt = null;
		try {
			// ��ȸ�Ϸ��� ȸ����ȣ �Է�
			String choice = searchNumber("��ȸ");
			
			// ���ν��� ȣ��
			// �Է¹��� ȸ����ȣ�� �ش� �����͸� ����
			cstmt = con.prepareCall("{call member_search(?, ?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.registerOutParameter(2, OracleTypes.CHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(6, OracleTypes.NUMBER);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.VARCHAR);
			cstmt.executeQuery();
			
			// �����͸� obj��ü�� ����
			Book_member obj = new Book_member();
			obj.m_number = cstmt.getString(2);
			obj.m_name = cstmt.getString(3);
			obj.phone = cstmt.getString(4);
			obj.email = cstmt.getString(5);
			obj.lending_max = cstmt.getInt(6);
			obj.first_lending_number = cstmt.getString(7);
			obj.second_lending_number = cstmt.getString(8);
			
			// ������ ���
			System.out.printf("\t\t\t               *** %s���� ���� ***\n", obj.m_name);
			System.out.println("==================================================================================================");
			System.out.printf("ȸ����ȣ\t�̸�\t%-13s\t%-30s\t���Ⱑ�ɱǼ�\t%-13s\t�����ȣ(2)\n", "����ó", "�̸���", "�����ȣ(1)");
			System.out.println("==================================================================================================");
			obj.outputData();
			System.out.println("==================================================================================================\n");
		} catch(Exception e) {
			System.out.println("ȸ������ ��ȸ ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ȸ������ ����
	static void update() {
		CallableStatement cstmt = null;
		try {
			// �����Ϸ��� ȸ����ȣ �Է�
			String choice = searchNumber("����");
			
			// ������ �Է�
			Scanner scan = new Scanner(System.in);
			System.out.print("�̸� �Է� => ");
			String m_name = scan.next();
			System.out.print("����ó �Է� => ");
			String phone = scan.next();
			System.out.print("�̸��� �Է� => ");
			String email = scan.next();
			System.out.println();
			
			// ���ν��� ȣ��
			// �Է¹��� �������� ���ν����� �����Ͽ� update
			cstmt = con.prepareCall("{call member_update(?, ?, ?, ?)}");
			cstmt.setString(1, choice);
			cstmt.setString(2, m_name);
			cstmt.setString(3, phone);
			cstmt.setString(4, email);
			cstmt.executeUpdate();
			System.out.println("ȸ������ ���� ����!!\n");
		} catch(Exception e) {
			System.out.println("ȸ������ ���� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ȸ������ ����
	static void delete() {
		CallableStatement cstmt = null;
		try {
			// �����Ϸ��� ȸ����ȣ �Է�
			String choice = searchNumber("����");
			
			// ���ν��� ȣ��
			// �Է¹��� ȸ����ȣ�� �ش� ������ ����
			cstmt = con.prepareCall("{call member_delete(?)}");
			cstmt.setString(1, choice);
			cstmt.executeUpdate();
			System.out.println("ȸ������ ���� ����!!\n");
		} catch(Exception e) {
			System.out.println("ȸ������ ���� ����!!\n" + e.getMessage());
		} finally {
			try {
				cstmt.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	// ��ȸ, ����, ������ ȣ��� ȸ����ȣ ���ñ��
	static String searchNumber(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print(str + "�� ȸ����ȣ�� �Է��ϼ��� => ");
		String choice = scan.next();
		System.out.println();
		return choice;
	}
}
