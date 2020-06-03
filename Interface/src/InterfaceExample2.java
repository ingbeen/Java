
public class InterfaceExample2 {
    public static void main(String args[]) { 
    	// 인터페이스인 laendable을 클래스라 생각해보자
    	// 클래스형 배열을 만들어서 메소드를 적용시킨다
    	// 단, Lendable은 checkout, chcekin만 접근 가능하다
        Lendable[] arr = new Lendable[3]; 
        arr[0] = new SeparateVolume("883ㅇ", "푸코의 진자", "에코"); 
        arr[1] = new SeparateVolume("609.2", "서양미술사", "곰브리치"); 
        arr[2] = new AppCDInfo("02-17", "XML을 위한 자바 프로그래밍"); 
        checkOutAll(arr, "윤지혜", "20060315");      
    } 
    
    static void checkOutAll(Lendable[] arr, String borrower, String date) { 
        for (int cnt = 0; cnt < arr.length; cnt++) 
            arr[cnt].checkOut(borrower, date);      
    } 
}
