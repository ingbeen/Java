
public class EnumExample3 {
	 public static void main(String args[]) {         
		 printSeason(Season.SPRING);         
		 printSeason(Season.SUMMER);         
		 printSeason(Season.FALL);         
		 printSeason(Season.WINTER);   
		 
		 printSeason2(Season.SPRING);
		 printSeason2(Season.SUMMER);
		 printSeason2(Season.FALL);
		 printSeason2(Season.WINTER);
	 }     
	 
	 // enum(Season)을 파라미터로 받는 메소드를 만들어서 name값을 리턴해서 출력
	 static void printSeason(Season season) {         
		 System.out.println(season.value());
	 }
	 
	// enum(Season)을 파라미터로 받는 메소드를 만들어서 num값을 리턴해서 출력
	 static void printSeason2(Season season) {         
		 System.out.println(season.value2());
	 }
}
