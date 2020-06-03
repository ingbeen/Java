import java.util.Scanner;

/*
-- 도서 테이블
-- 도서번호, 도서명, 저자, 출판사, 대출번호
create table book_info(
    b_number char(7) constraint book_info_b_number_pk primary key,
    b_name varchar2(40) not null,
    author varchar2(20),
    publishing_company varchar2(20),
    lending_number varchar2(10)
);
 */

// 도서 테이블
// 도서번호, 도서명, 저자, 출판사, 대출번호
public class Book_info {
	String b_number, b_name, author, publishing_company, lending_number;
	
	// 도서정보 입력
	// 도서번호, 도서명, 저자, 출판사 입력
	// 대출번호는 대출데이터 발생시 삽입
	void inputData() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("도서번호 입력 => ");
		b_number = scan.next();
		System.out.print("도서명 입력 => ");
		b_name = scan.next();
		System.out.print("저자 입력 => ");
		author = scan.next();
		System.out.print("출판사 입력 => ");
		publishing_company = scan.next();
		System.out.println();
	}
	
	// 도서정보 출력, 도서정보 조회
	void outputData() {
		System.out.printf("%s\t%-25s\t%-12s\t%s\t%s\n", 
			b_number, b_name, author, publishing_company, lending_number);
	}
}
