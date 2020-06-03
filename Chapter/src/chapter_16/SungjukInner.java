package chapter_16;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukInner {
	ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();
	
	void addSungjuk() {    
		Sungjuk obj = new Sungjuk();
		obj.input();
		obj.process();
        list.add(obj);
    }
	/*
	void removeSungjuk(Sungjuk obj) {      
        list.remove(obj);
    }
    */
    int getSungjukNum() {
        return list.size();
    }
    
    Sungjuk getSungjuk(int index) {
        return list.get(index);
    }
    
    double getTotalAvg() {   
    	double tot_avg = 0;
        for (Sungjuk obj : list)
        	tot_avg += obj.avg;
        return tot_avg;
    }
    
	class Sungjuk {
		String hakbun, irum;
		int kor, eng, math, tot;
		double avg;
		String grade;
		
		public Sungjuk() {
		}
		
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
	}
}
