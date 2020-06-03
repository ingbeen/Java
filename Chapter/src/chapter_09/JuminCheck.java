package chapter_09;
import java.util.Scanner;

public class JuminCheck {
	public static void main(String[] args) {
		int i, w=2, chk, hap=0;
		String ju;
		
		Scanner scan = new Scanner(System.in);
		
		while(true)  // �ֹι�ȣ �Է� �˻� ����------->
		{
			System.out.print("�ֹι�ȣ �Է� => ");
			ju = scan.next();  
			
			if (!input_check(ju))
			{
				System.out.println("�ֹι�ȣ �Է� ����!!!");
				continue;
			}
			else
				break;
		} //�ֹι�ȣ �Է� �˻� ��<---------------------
			
		for (i=0; i<ju.length()-1; i++)
		{
			if (i == 6)  // '-'�� �հ� ��꿡�� ��ŵ
				continue;
			
			hap += Integer.parseInt(ju.substring(i, i+1)) * w;  // w:����ġ
			w++;
			if (w == 10)
				w =2;  // w�� 9������ 2�̹Ƿ�....
		}
		
		chk = 11 - hap % 11;
		if (chk == 10)
			chk = 0;
		else if (chk == 11)
			chk = 1;
		
		if (chk == Integer.parseInt(ju.substring(13, 14)))
			System.out.println("�ֹι�ȣ : " + ju + "(O)");
		else
			System.out.println("�ֹι�ȣ : " + ju + "(X)");
	}
	
	static boolean input_check(String str)
	{
		char ch;
		
		if (str.length() != 14)  // �Է¹��� ���ڿ��� 14�ڸ����� �˻�
			return false;
		
		//���ڿ��� ���� �޾� ���ڿ� ���̸�ŭ �ѹ��ھ� �˻�
		for (int i=0; i<str.length(); i++) 
		{
			ch = str.charAt(i);  //���ڿ����� �ѹ��ھ� ����
			if (i == 6)  // '-'���� �˻�
			{
				if (ch != '-')
					return false;
			}
			else if(i == 7) // ���� �� �˻�
			{
				if (!(ch == '1' || ch == '2' || ch == '3' || ch == '4'))
					return false;
			}
			else if (ch < '0' || ch > '9') // ch�� �������� �˻�(�����ڵ�� ��)
				return false;
		}
		return true;
	}
}
