package chapter_13;

import java.util.ArrayList;

public class ArrayList_SearchEx {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("������");
		System.out.println(1);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.add(2, "Ű��");
		System.out.println(2);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.set(0, "������");
		list.add("Ű��");
		System.out.println(3);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.remove("Ű��");
		System.out.println(4);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
	}
}
