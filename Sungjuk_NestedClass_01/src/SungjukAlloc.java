import java.util.ArrayList;
import java.util.Scanner;

public class SungjukAlloc{
	ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();
	void addSungjuk() {
		Sungjuk obj = new Sungjuk();
		obj.input();
		if(!checkInput(obj)) {
			addSungjuk();
		}
		obj.process();
		list.add(obj);
	}
	
	Sungjuk getSungjuk(int index) {
		return list.get(index);
	}
	
	int getSungjukNum() {
		return list.size();
	}
	
	void removeSungjuk(int index) {
		list.remove(index);
	}
	
	boolean checkInput(Sungjuk obj1) {
		for(Sungjuk obj2 : list) {
			if(obj2.hakbun.equals(obj1.hakbun)) {
				System.out.println("학번이 중복입니다");
				return false;
			}
		}
		return true;
	}
	
	double getTotal_avg() {
		double totAvg = 0.0;
		for(Sungjuk obj : list) {
			totAvg += obj.avg;
		}
		totAvg /= list.size();
		return totAvg;
	}
	
	class Sungjuk {
		String hakbun, irum;
		int kor, eng, math, tot;
		double avg;
		String grade;
		
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
			System.out.println();
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
	}
}