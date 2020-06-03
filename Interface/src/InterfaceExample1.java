
public class InterfaceExample1 {
    public static void main(String args[]) { 
        SeparateVolume obj1 = new SeparateVolume("863¤²774°³", "°³¹Ì", "º£¸£º£¸£"); 
        AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora"); 
        out(obj1, "±è¿µ¼÷", "20060315"); 
        out(obj2, "¹ÚÈñ°æ", "20060317");    
        in(obj1); 
        in(obj2);    
    }
    
    public static void out(Lendable obj, String borrower, String date) {
    	obj.checkOut(borrower, date);
    }
    
    public static void in(Lendable obj) {
    	obj.checkIn();
    }
    
}
