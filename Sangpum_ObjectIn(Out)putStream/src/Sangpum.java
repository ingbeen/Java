import java.io.Serializable;
import java.util.Scanner;

public class Sangpum implements Serializable, Cloneable{

	// ��ǰ�ڵ忡 exit �Է��ϸ� ����
	// �Է°����� ������ �Ǽ��� 100���� ����

	String code;
	String irum;
	int su;
	int dan;
	int price;
	String grade;
	
	static int cnt = 0;
	static int tot_price = 0;
	
	public String toString() {
		String str = "��ǰ�ڵ� : " + code + "\n";
		str += "��ǰ�� : " + irum + "\n";
		str += "���� : " + su + "\n";
		str += "�ܰ� : " + irum + "\n";
		str += "���� : " + price + "\n";
		str += "��� : " + grade + "\n";
		return str;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sangpum)) {
			return false;
		}
		Sangpum objA = (Sangpum) obj;
		if(code.equals(objA.code) && irum.equals(objA.irum) && su == objA.su && dan == objA.dan) {
			return true;
		}
		return false;
	}
	
	// ���ʵ����� �Է�
	public void input(Sangpum[] s) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("��ǰ�ڵ� �Է� => ");
		code = scan.next();
		System.out.print("��ǰ�� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		System.out.println();
		
	}

	// ���ʵ����� ���
	public void processc() {
		price = su * dan;

		if (su >= 100) {
			grade = "���";
		} else if (su >= 70) {
			grade = "����";
		} else {
			grade = "�й�";
		}
	}
	
	// �Ǹž� �հ� ���
	public void processc_tot() {
		tot_price += price;
	}

	// ��ü ������ ���
	public void output() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t   %s\n", code, irum, su, dan, price, grade);
	}
}
