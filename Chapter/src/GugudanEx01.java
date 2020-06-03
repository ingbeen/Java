import java.util.Scanner;

public class GugudanEx01 {
	public static void main(String[] args) {
		int num1, num2, min, max;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 입력 => ");
		num1 = scan.nextInt();
		System.out.print("두번째 숫자 입력 => ");
		num2 = scan.nextInt();
		
		
		
		if(num1 > num2) {
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		
		for(int i = num1; i <= num2; i++) {
			if(i == num2) {
				System.out.printf("*** %d ***\n", i);
			} else {
				System.out.printf("*** %d ***\t", i);
			}
			
		}
		
		min = 1;
		max = 9;
		
		for(int i = min; i <= max; i++) {
			for(int j = num1; j <= num2; j++) {
				if(j == num2) {
					System.out.printf("%d * %d = %2d\n", j, i, i*j);
				} else {
					System.out.printf("%d * %d = %2d\t", j, i, i*j);
				}
			}
		}
		
		scan.close();
	}

}
