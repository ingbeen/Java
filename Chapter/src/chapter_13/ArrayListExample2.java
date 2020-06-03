package chapter_13;

import java.util.ArrayList;

public class ArrayListExample2 {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("사과");
		list.add("복숭아");
		list.add("자두");
		list.add("사과");
		int index1 = list.indexOf("사과");
		int index2 = list.lastIndexOf("사과");
		System.out.println("첫번째 사과 : " + index1);
		System.out.println("첫번째 사과 : " + index2);
		
	}
}
