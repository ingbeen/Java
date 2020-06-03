package chapter_13;

public class HashCodeExample2 {

	public static void main(String[] args) {
        Name obj1 = new Name("헤르미온느", "그레인져");
        Name obj2 = new Name("헤르미온느", "그레인져");
        int hash1 = obj1.hashCode();
        int hash2 = obj2.hashCode();
        System.out.println(hash1);
        System.out.println(hash2);
	}

}
