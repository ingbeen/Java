
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
	 
	 // enum(Season)�� �Ķ���ͷ� �޴� �޼ҵ带 ���� name���� �����ؼ� ���
	 static void printSeason(Season season) {         
		 System.out.println(season.value());
	 }
	 
	// enum(Season)�� �Ķ���ͷ� �޴� �޼ҵ带 ���� num���� �����ؼ� ���
	 static void printSeason2(Season season) {         
		 System.out.println(season.value2());
	 }
}
