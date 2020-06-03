import java.util.Scanner;


public class Sungjuk implements Cloneable {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	
	Sungjuk(){
	}
  
	Sungjuk(String hakbun, String irum, int kor, int eng, int math)
	{
	   this.hakbun = hakbun;
	   this.irum = irum;
	   this.kor = kor;
	   this.eng = eng;
	   this.math = math;
	}
  
	void input()
	{
		Scanner scan = new Scanner(System.in);
   
		System.out.print("�й� �Է� : ");
		hakbun = scan.next();
		System.out.print("�̸� �Է� : ");
		irum = scan.next();
		System.out.print("���� �Է� : ");
		kor = scan.nextInt();
		System.out.print("���� �Է� : ");
		eng = scan.nextInt();
		System.out.print("���� �Է� : ");
		math = scan.nextInt();
	}

	void process()
	{
		tot = kor + eng + math;
		avg = tot / 3.;
   
		switch ((int)avg / 10)
		{
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
		System.out.printf("%4s   %3s     %4d    %4d   %4d   %4d  %6.2f  %3s\n",
			hakbun, irum, kor, eng, math, tot, avg, grade);
	}
 }