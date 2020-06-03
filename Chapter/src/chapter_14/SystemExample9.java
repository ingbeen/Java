package chapter_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemExample9 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = reader.readLine();
			System.out.println("입력된 문자열 : " + str);
		} catch(IOException e) {
			System.err.println("키보드 입력 에러");
		}
	}
}
