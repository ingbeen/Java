
public class EnumExample4 {
	 public static void main(String args[]) {         
		 printSeason(Day.MONDAY);
		 printSeason(Day.SUNDAY);
	 }     
	 
	 // enum�� �Ķ���ͷ� �޴� �޼ҵ带 ���� name���� �����ؼ� ���
	 static void printSeason(Day day) {         
		 System.out.println(day.value());
	 }
}
