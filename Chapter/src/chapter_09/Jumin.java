package chapter_09;
import java.util.Scanner;

public class Jumin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num;
		
		while(true) {
			
			while(true) {
				// �ֹι�ȣ �Է�
				System.out.print("�ֹι�ȣ �Է� => ");
				num = scan.next();
				
				// ���� �˻�
				if(!input_check(num)) {
					break;
				}
				
			}
			
			// �ֹι�ȣ �հ�
			int numsum = 0, j = 0;
			int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
			for(int i = 0; i < num.length() - 2; i++) {
				if (j == 6) {
					i--;
					j++;
					continue;
				} else {
					numsum += Character.getNumericValue(num.charAt(j)) * value[i];
					j++;
				}
			}
			
			// �ֹι�ȣ üũ�� ���
			int check;
			if(11 - (numsum % 11) == 11) {
				check = 1;
			} else if(11 - (numsum % 11) == 10) {
				check = 0;
			} else {
				check = 11 - (numsum % 11);
			}
			
			// ���� ���
			if(Character.getNumericValue(num.charAt(13)) == check) {
				System.out.println(num.concat("(O)"));
				break;
			} else {
				System.out.println(num.concat("(X)"));
				break;
			}
		}
		
	}
	
	public static boolean input_check(String num) {
		// 14�ڸ� �˻�
		if (num.length() != 14) {
			System.out.println("������ ��ȣ ���� 14�ڸ��� �Է����ּ���");
			System.out.println();
			return true;
		}
		
		// ���ڸ��� �����Ͽ� �˻�
		for(int i = 0; i < num.length(); i++) {
			
			// ���ڸ��� ����
			char check = num.charAt(i);
		
			// ������ ��ȣ �˻�
			if(i == 6) {
				if (check != '-') {
					System.out.println("\"123456-1234567\"�������� �ٽ� �Է����ּ���");
					System.out.println();
					return true;
				}
			} else if(i == 7) {
				// ���� �˻�
				if (!(49 <= check && check <= 52)) {
					System.out.println("���ڸ� ù��° ��ȣ�� 1 ~ 4 ���̰��� �Է����ּ���");
					System.out.println();
					return true;
				}
			} else {
				// ���� �˻�
				if (!(48 <= check && check <= 57)) {
					System.out.println("1 ~ 9 ���̰��� �Է����ּ���");
					System.out.println();
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}
}
