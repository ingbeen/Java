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
import java.util.Scanner;

public class Sungjuk {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	
	Sungjuk()
	{
	}
	
	void input()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학번 입력 => ");
		hakbun = scan.next();
		System.out.print("이름 입력 => ");
		irum = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
	}
	
	void process()
	{
		tot = kor + eng + math;
		avg = tot /3.;
		
		switch ((int)avg/10)
		{
			case 10:
			case 9:
				grade = "수";
				break;
			case 8:
				grade = "우";
				break;
			case 7:
				grade = "미";
				break;
			case 6:
				grade = "양";
				break;
			default:
				grade = "가";
				break;
		}
	}
	
	void output()
	{
		System.out.printf("%4s  %3s   %4d  %4d  %4d  %4d %6.2f %2s\n",
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
}
