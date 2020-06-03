import java.util.Scanner;

public class Sangpum {
	String code, irum;
	int su, dan, price;
	String grade;
	static int total_price = 0;
	
	public Sangpum() {
	}
	
	void input()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("��ǰ�ڵ� �Է� => ");
		code = scan.next();
		System.out.print("��ǰ�� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
	}
	
	void update()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\n���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		process();
	}
	
	void process()
	{
		price = su * dan;
		
		if (su >= 100)
			grade = "���";
		else if (su >= 70)
			grade = "����";
		else
			grade = "�й�";
	}
	
	void output()
	{
		System.out.printf("%6s %6s      %4d  %7d %8d   %2s\n",
				code, irum, su, dan, price, grade);
	}
	
	static int print_total_price()
	{
		return total_price;
	}
}
