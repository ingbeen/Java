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
		
		System.out.print("�й� �Է� => ");
		hakbun = scan.next();
		System.out.print("�̸� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		math = scan.nextInt();
	}
	
	void process()
	{
		tot = kor + eng + math;
		avg = tot / 3.;
				
		switch ((int)avg / 10) {
			case 10:
			case 9:
				grade = "��";
				break;
			case 8:
				grade = "��";
				break;
			case 7:
				grade = "��";
				break;
			case 6:
				grade = "��";
				break;
			default:
				grade = "��";
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
		String str = "�й� : " + hakbun + "\n";
		
		str += "�̸� : " + irum + "\n";
		str += "���� : " + kor + "\n";
		str += "���� : " + eng + "\n";
		str += "���� : " + math+ "\n";
		str += "���� : " + tot + "\n";
		str += "��� : " + avg + "\n";
		str += "��� : " + grade + "\n";
	
		return str;
	}
	
	// clone�� �����ϱ� ���� Cloneable�������̽��� implements�Ѵ�
	// ObjectŸ���� �����ؾߵǸ� super.clone()�� ObjectŸ���̴�
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