package chapter_09;

import java.util.Random;

public class Lotto {
	
	public static void main(String[] gars) {
		int[] num = new int[6];
		
		Random ran = new Random();
		
		// 난수 입력
		for(int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(45) + 1;
			for(int j = i - 1; j >= 0; j--) {
				if(num[i] == num[j]) {
					i--;
				}
			}
		}
		
		// 출력
		System.out.print("[");
		for(int i = 0; i < num.length; i++) {
			if (i == num.length - 1) {
				System.out.print(num[i]);
			} else {
				System.out.print(num[i] + ", ");
			}
		}
		System.out.print("]");
	}
}
