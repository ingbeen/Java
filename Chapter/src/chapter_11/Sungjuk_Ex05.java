package chapter_11;

public class Sungjuk_Ex05 {
	public static void main(String[] args) {
		Sungjuk obj1 = new Sungjuk();
		
		obj1.input();
		obj1.process();
		Sungjuk obj2 = (Sungjuk) obj1.clone();
		
		System.out.println();
		
		// 오버라이딩한 equals와 toString사용
		// toString은 명시를 안해줘도 적용된다
		if(obj1.equals(obj2)) {
			System.out.println("같다");
			System.out.println(obj1);
		} else {
			System.out.println("다르다");
			System.out.println(obj2);
		}
	}
}
