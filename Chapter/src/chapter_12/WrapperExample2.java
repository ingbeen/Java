package chapter_12;

public class WrapperExample2 {

	public static void main(String[] args) {
		int total = 0;
		for(int i = 0; i < args.length; i++) {
			Integer obj = new Integer(args[i]);
			total += obj.intValue();
		}
		System.out.println(total);

	}

}
