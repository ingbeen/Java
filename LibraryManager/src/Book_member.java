import java.util.Scanner;

/*
-- 회원 테이블
-- 회원번호, 이름, 연락처, 이메일, 대출가능권수, 첫번째대출번호, 두번째대출번호
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

// 회원 테이블
// 회원번호, 이름, 연락처, 이메일, 대출가능권수, 첫번째대출번호, 두번째대출번호
public class Book_member {
	String m_number, m_name, phone, email,
		first_lending_number, second_lending_number;
	int lending_max;
	
	// 회원정보 입력
	// 회원번호, 이름, 연락처, 이메일 입력
	// 대출가능권수는 default값 삽입
	// 첫번째대출번호, 두번째대출번호는 대출데이터 발생시 삽입
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("회원번호 입력 => ");
		m_number = scan.next();
		System.out.print("이름 입력 => ");
		m_name = scan.next();
		System.out.print("연락처 입력 => ");
		phone = scan.next();
		System.out.print("이메일 입력 => ");
		email = scan.next();
		System.out.println();
	}
	
	// 회원정보 출력, 회원정보 조회
	void outputData() {
		System.out.printf("%s\t%s\t%-13s\t%-20s\t%-10d\t%-10s\t%s\n", 
			m_number, m_name, phone, email, lending_max, 
			first_lending_number, second_lending_number);
	}
}
