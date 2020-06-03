package chapter_15;

public class ExceptionExample7 {
	public static void main(String[] args) {
		try {
			int[] arr = new int[0];
			System.out.println("합계 " + getTotal(arr));
			System.out.println("평균" + getAverage(arr));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static double getAverage(int[] arr) throws Exception{
		if(arr.length == 0) {
			throw new Exception("비어있는 배열입니다(1)");
		}
		return getTotal(arr) / arr.length;
	}
	
	static int getTotal(int[] arr) throws Exception{
		if(arr.length == 0) {
			throw new Exception("비어있는 배열입니다(2)");
		}
		int total = 0;
		for(int num : arr) {
			total += num;
		}
		return total;
	}
}
