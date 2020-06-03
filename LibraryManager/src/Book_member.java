import java.util.Scanner;

/*
-- ȸ�� ���̺�
-- ȸ����ȣ, �̸�, ����ó, �̸���, ���Ⱑ�ɱǼ�, ù��°�����ȣ, �ι�°�����ȣ
create table book_member(
    m_number char(4) constraint book_member_m_number_pk primary key,
    m_name varchar2(10) not null,
    phone varchar2(15) not null,
    email varchar2(20),
    book_max number(1) default 2,
    first_lending_number varchar2(10),
    second_slending_number varchar2(10)
);
 */

// ȸ�� ���̺�
// ȸ����ȣ, �̸�, ����ó, �̸���, ���Ⱑ�ɱǼ�, ù��°�����ȣ, �ι�°�����ȣ
public class Book_member {
	String m_number, m_name, phone, email,
		first_lending_number, second_lending_number;
	int lending_max;
	
	// ȸ������ �Է�
	// ȸ����ȣ, �̸�, ����ó, �̸��� �Է�
	// ���Ⱑ�ɱǼ��� default�� ����
	// ù��°�����ȣ, �ι�°�����ȣ�� ���ⵥ���� �߻��� ����
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("ȸ����ȣ �Է� => ");
		m_number = scan.next();
		System.out.print("�̸� �Է� => ");
		m_name = scan.next();
		System.out.print("����ó �Է� => ");
		phone = scan.next();
		System.out.print("�̸��� �Է� => ");
		email = scan.next();
		System.out.println();
	}
	
	// ȸ������ ���, ȸ������ ��ȸ
	void outputData() {
		System.out.printf("%s\t%s\t%-13s\t%-20s\t%-10d\t%-10s\t%s\n", 
			m_number, m_name, phone, email, lending_max, 
			first_lending_number, second_lending_number);
	}
}
