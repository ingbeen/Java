import java.util.Scanner;

/*
-- ���� ���̺�
-- ������ȣ, ������, ����, ���ǻ�, �����ȣ
create table book_info(
    b_number char(7) constraint book_info_b_number_pk primary key,
    b_name varchar2(40) not null,
    author varchar2(20),
    publishing_company varchar2(20),
    lending_number varchar2(10)
);
 */

// ���� ���̺�
// ������ȣ, ������, ����, ���ǻ�, �����ȣ
public class Book_info {
	String b_number, b_name, author, publishing_company, lending_number;
	
	// �������� �Է�
	// ������ȣ, ������, ����, ���ǻ� �Է�
	// �����ȣ�� ���ⵥ���� �߻��� ����
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("������ȣ �Է� => ");
		b_number = scan.next();
		System.out.print("������ �Է� => ");
		b_name = scan.next();
		System.out.print("���� �Է� => ");
		author = scan.next();
		System.out.print("���ǻ� �Է� => ");
		publishing_company = scan.next();
		System.out.println();
	}
	
	// �������� ���, �������� ��ȸ
	void outputData() {
		System.out.printf("%s\t%-25s\t%-12s\t%s\t%s\n", 
			b_number, b_name, author, publishing_company, lending_number);
	}
}
