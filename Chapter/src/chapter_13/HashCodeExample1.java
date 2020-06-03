package chapter_13;

public class HashCodeExample1 {

	public static void main(String[] args) {
        String obj1 = new String("헤르미온느");
        String obj2 = new String("헤르미온느");
        System.out.println(obj1 == obj2);
        int hash1 = obj1.hashCode();
        int hash2 = obj2.hashCode();
        System.out.println(hash1);
        System.out.println(hash2);
	}

}
