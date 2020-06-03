import java.util.Scanner;

public class Sungjuk extends Person implements Personable {
	int kor, eng, math, tot;
	double avg;
	String grade;
	
	public boolean input() 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("�й� �Է� => ");
		hakbun = in.next();
		if (hakbun.toLowerCase().equals("exit"))
			return true;
		
		System.out.print("�̸� �Է� => ");
		irum = in.next();
		System.out.print("���� �Է� => ");
		kor = in.nextInt();
		System.out.print("���� �Է� => ");
		eng = in.nextInt();
		System.out.print("���� �Է� => ");
		math = in.nextInt();

		return false;
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
	
	public void output()
	{
		System.out.printf("%4s  %3s  %3d  %3d  %3d  %3d  %5.2f  %2s\n", 
			hakbun, irum, kor, eng, math, tot, avg, grade);
	}
}