package chapter_13;

import java.util.ArrayList;

public class ArrayListExample1 {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("������");
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}
}
