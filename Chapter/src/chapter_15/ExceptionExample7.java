package chapter_15;

public class ExceptionExample7 {
	public static void main(String[] args) {
		try {
			int[] arr = new int[0];
			System.out.println("�հ� " + getTotal(arr));
			System.out.println("���" + getAverage(arr));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static double getAverage(int[] arr) throws Exception{
		if(arr.length == 0) {
			throw new Exception("����ִ� �迭�Դϴ�(1)");
		}
		return getTotal(arr) / arr.length;
	}
	
	static int getTotal(int[] arr) throws Exception{
		if(arr.length == 0) {
			throw new Exception("����ִ� �迭�Դϴ�(2)");
		}
		int total = 0;
		for(int num : arr) {
			total += num;
		}
		return total;
	}
}
