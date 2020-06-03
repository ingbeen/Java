
public class EnumExample2 {
    public static void main(String args[]) { 
        printDay("MONDAY"); 
        printDay("WEDNESDAY"); 
        printDay("FRIDAY"); 
    } 
    
    static void printDay(String name) { 
        Day day = Day.valueOf(name); 
        System.out.println(day); 
    }
}
