package chapter_15;

public class ExceptionExample4 {
	public static void main(String[] args) {
		try {
			int result = devide(3, 0);
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}
	
	static int devide(int a, int b) {
		int result = a / b;
		return result;
	}
}
