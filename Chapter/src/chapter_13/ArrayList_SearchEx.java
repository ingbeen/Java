package chapter_13;

import java.util.ArrayList;

public class ArrayList_SearchEx {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Æ÷µµ");
		list.add("µþ±â");
		list.add("º¹¼þ¾Æ");
		System.out.println(1);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.add(2, "Å°À§");
		System.out.println(2);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.set(0, "¿À·»Áö");
		list.add("Å°À§");
		System.out.println(3);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		list.remove("Å°À§");
		System.out.println(4);
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
	}
}
