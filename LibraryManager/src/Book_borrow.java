import java.util.Scanner;

/*
-- ���� ���̺�
-- �����ȣ, ȸ����ȣ, �̸� , ������ȣ, ������ , ������, �ݳ���
create table book_borrow(
    lending_number varchar2(10) constraint book_borrow_lending_number_pk primary key,
    m_number char(4) constraint book_borrow_m_number_fk references book_member(m_number),
    m_name varchar2(10),
    b_number char(7) constraint book_borrow_b_number_fk references book_info(b_number),
    b_name varchar2(40),
    loandate date default sysdate,
    returndate date
);
 */

// ���� ���̺�
// �����ȣ, ȸ����ȣ, �̸� , ������ȣ, ������ , ������, �ݳ���
public class Book_borrow {
	String lending_number, m_number, m_name, 
		b_number, b_name, loandate, returndate;
	
	// ��������
	// ȸ����ȣ�� ������ȣ �Է�
	// ȸ���̸��� �������� lending_namecheck ���ν������� ���޹���
	// �����ȣ :  '���糯¥-������(200101-1)'���·� �ڵ��Է�
	// ������ : default��(���糯¥) ����
	// �ݳ��� : ���� �ݳ� ���ν������� default��(�ݳ������ ���糯¥) ����
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("ȸ����ȣ �Է� => ");
		m_number = scan.next();
		System.out.print("������ȣ �Է� => ");
		b_number = scan.next();
		System.out.println();
	}
	
	// ���� �������� ����
	void outputData() {
		System.out.printf("%s\t%s\t%s\t%s\t%-25s\t%s\n", 
				lending_number, m_number, m_name, b_number, b_name, 
				loandate);
	}
	
	// ���� �������� ��ȸ, ���� �������� ����
	void outputData_all() {
		System.out.printf("%s\t%s\t%s\t%s\t%-25s\t%s\t%s\n", 
				lending_number, m_number, m_name, b_number, b_name, 
				loandate, returndate);
	}
}
