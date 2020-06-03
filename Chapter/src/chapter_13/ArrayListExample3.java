package chapter_13;

import java.util.ArrayList;

public class ArrayListExample3 {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("사과");
		list.add("복숭아");
		list.add("사과");
		list.add("머루");
		list.add("사과");
		list.add("다래");
		System.out.println(list.indexOf("사과"));
		System.out.println(list.lastIndexOf("사과"));
		
		StringBuffer index = new StringBuffer();
		int cnt = 0;
		for(String str : list) {
			if(str.equals("사과")) {
				index.append(cnt + "번 ");
			}
			cnt++;
		}
		
		System.out.println(index);
		
	}
}
