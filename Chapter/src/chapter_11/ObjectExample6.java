package chapter_11;

public class ObjectExample6 {

	public static void main(String[] args) {
		Circle obj1 = new Circle(5);
		Circle obj2 = new Circle(5);
		if (obj1.equals(obj2)) {
			System.out.println("����");
			System.out.println(obj1);
		} else {
			System.out.println("�ٸ�");
			System.out.println(obj2);
		}
	}

}
