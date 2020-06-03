
public class EnumExample4 {
	 public static void main(String args[]) {         
		 printSeason(Day.MONDAY);
		 printSeason(Day.SUNDAY);
	 }     
	 
	 // enum을 파라미터로 받는 메소드를 만들어서 name값을 리턴해서 출력
	 static void printSeason(Day day) {         
		 System.out.println(day.value());
	 }
}
