package chapter_12;

public class WrapperExample5 {
    public static void main(String args[]) {
        printDouble(new Double(123.45));
        printDouble(123.45);         
    }
    
    static void printDouble(Double obj) {
        System.out.println(obj); // System.out.println(obj.toString());
        System.out.println(obj.intValue() + 10); // System.out.println(obj.intValue() + 10);
    }
}
