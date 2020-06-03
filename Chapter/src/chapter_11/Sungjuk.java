package chapter_11;

import java.util.Scanner;

public class Sungjuk implements Cloneable{
	String hakbun, irum;
	int kor, eng, math, tot;
	double avg;
	String grade;
	
	static int cnt = 0;
	static double tot_avg = 0.0;
	
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
		avg = tot / 3.;
				
		switch ((int)avg / 10) {
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
		System.out.printf("%4s %3s  %3d  %3d  %3d  %3d %6.2f %2s\n",
			hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sungjuk)) {
			return false;
		}
		Sungjuk objA = (Sungjuk) obj;
		if(hakbun.equals(objA.hakbun) && irum.equals(objA.irum) && kor == objA.kor && eng == objA.eng && math == objA.math) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String str = "학번 : " + hakbun + "\n";
		
		str += "이름 : " + irum + "\n";
		str += "국어 : " + kor + "\n";
		str += "영어 : " + eng + "\n";
		str += "수학 : " + math+ "\n";
		str += "총점 : " + tot + "\n";
		str += "평균 : " + avg + "\n";
		str += "등급 : " + grade + "\n";
	
		return str;
	}
	
	// clone을 생성하기 위해 Cloneable인터페이스를 implements한다
	// Object타입을 리턴해야되며 super.clone()는 Object타입이다
	public Object clone() {
		try {
			return super.clone();
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	static double getTotal_avg()
	{
		return tot_avg / cnt;
	}
}