import java.util.Scanner;

/*
-- 대출 테이블
-- 대출번호, 회원번호, 이름 , 도서번호, 도서명 , 대출일, 반납일
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

// 대출 테이블
// 대출번호, 회원번호, 이름 , 도서번호, 도서명 , 대출일, 반납일
public class Book_borrow {
	String lending_number, m_number, m_name, 
		b_number, b_name, loandate, returndate;
	
	// 도서대출
	// 회원번호와 도서번호 입력
	// 회원이름과 도서명은 lending_namecheck 프로시저에서 전달받음
	// 대출번호 :  '현재날짜-시퀀스(200101-1)'형태로 자동입력
	// 대출일 : default값(현재날짜) 삽입
	// 반납일 : 추후 반납 프로시저에서 default값(반납당시의 현재날짜) 삽입
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("회원번호 입력 => ");
		m_number = scan.next();
		System.out.print("도서번호 입력 => ");
		b_number = scan.next();
		System.out.println();
	}
	
	// 현재 대출중인 도서
	void outputData() {
		System.out.printf("%s\t%s\t%s\t%s\t%-25s\t%s\n", 
				lending_number, m_number, m_name, b_number, b_name, 
				loandate);
	}
	
	// 도서 대출정보 조회, 통합 도서대출 내역
	void outputData_all() {
		System.out.printf("%s\t%s\t%s\t%s\t%-25s\t%s\t%s\n", 
				lending_number, m_number, m_name, b_number, b_name, 
				loandate, returndate);
	}
}
