import java.util.Scanner;

public class PrimeNumber {
	
	// 임의의 2개의 숫자를 입력 받아서 그 숫자의 사이의 소수를 구하고 출력하시오
	// 소수들의 출력은 1개의 행에 10개씩 출력, 구해진 소수의 총합계도 출력하시오
	
	public static void main(String[] args) {
		
		int[] val, res_val;
		val = input();
		
		res_val = process(val[0], val[1]);
		
		if(res_val[0] % 10 != 0) {
			System.out.println();
		}
		System.out.println("총소수의 갯수 = " + res_val[0]);
		System.out.println("총소수의 합 = " + res_val[1]);
		
	}
	
	static int[] input() {
		int num1, num2;
		int input_val[] = new int[2];
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 입력 => ");
		num1 = in.nextInt();
		System.out.print("두번째 숫자 입력 => ");
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
