package chapter_13;

import java.util.ArrayList;

public class ArrayListExample3 {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("����");
		list.add("���");
		list.add("������");
		list.add("���");
		list.add("�ӷ�");
		list.add("���");
		list.add("�ٷ�");
		System.out.println(list.indexOf("���"));
		System.out.println(list.lastIndexOf("���"));
		
		StringBuffer index = new StringBuffer();
		int cnt = 0;
		for(String str : list) {
			if(str.equals("���")) {
				index.append(cnt + "�� ");
			}
			cnt++;
		}
		
		System.out.println(index);
		
	}
}
