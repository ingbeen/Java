package chapter_11;

public class ObjectExample2 {

	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		String str = obj.toString();
		System.out.println(obj);
		System.out.println(str);
	}

}
