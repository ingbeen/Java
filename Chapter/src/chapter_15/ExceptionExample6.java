package chapter_15;

public class ExceptionExample6 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		try {
			int result = num1 - num2;
			if(result < 0) {
				throw new Exception("�߸��� ����Դϴ�");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
