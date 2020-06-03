package chapter_11;

public class ObjectExample8 {

	public static void main(String[] args) {
		Rectangle obj1 = new Rectangle(10, 20);
        Rectangle obj2 = (Rectangle) obj1.clone();
        System.out.println("obj1 = " + obj1.width + "x" + obj1.height);
        System.out.println("obj2 = " + obj2.width + "x" + obj2.height);

	}

}
