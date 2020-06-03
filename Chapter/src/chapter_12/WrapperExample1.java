package chapter_12;

public class WrapperExample1 {

	public static void main(String[] args) {
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum);

	}

}
