package chapter_13;

import java.util.ArrayList;

public class ArrayListExample2 {
	public static void main(String[] agrs) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("����");
		list.add("���");
		list.add("������");
		list.add("�ڵ�");
		list.add("���");
		int index1 = list.indexOf("���");
		int index2 = list.lastIndexOf("���");
		System.out.println("ù��° ��� : " + index1);
		System.out.println("ù��° ��� : " + index2);
		
	}
}
