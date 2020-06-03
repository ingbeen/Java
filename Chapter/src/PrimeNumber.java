import java.util.Scanner;

public class PrimeNumber {
	
	// ������ 2���� ���ڸ� �Է� �޾Ƽ� �� ������ ������ �Ҽ��� ���ϰ� ����Ͻÿ�
	// �Ҽ����� ����� 1���� �࿡ 10���� ���, ������ �Ҽ��� ���հ赵 ����Ͻÿ�
	
	public static void main(String[] args) {
		
		int[] val, res_val;
		val = input();
		
		res_val = process(val[0], val[1]);
		
		if(res_val[0] % 10 != 0) {
			System.out.println();
		}
		System.out.println("�ѼҼ��� ���� = " + res_val[0]);
		System.out.println("�ѼҼ��� �� = " + res_val[1]);
		
	}
	
	static int[] input() {
		int num1, num2;
		int input_val[] = new int[2];
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է� => ");
		num1 = in.nextInt();
		System.out.print("�ι�° ���� �Է� => ");
		num2 = in.nextInt();
		
		if(num1 > num2) {
			input_val[0] = num2;
			input_val[1] = num1;
		} else {
			input_val[0] = num1;
			input_val[1] = num2;
		}
		in.close();
		return input_val;
	}
	
	static int[] process(int min, int max) {
		int process_val[] = new int[2];
		int i, j;
		
		for(i = min; i <= max; i++) {
			for(j = 2; j<i; j++) {
				if(i % j == 0)
					break;
			}
			if (i == j) {
				System.out.printf("%5d", i);
				process_val[0]++;
				if(process_val[0] % 10 == 0) {
					System.out.println();
				}
				process_val[1] += i;
			}
		}
		return process_val;
	}
	
}
