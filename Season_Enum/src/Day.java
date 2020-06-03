
public enum Day {
	MONDAY("������"), TUESDAY("ȭ����"), WEDNESDAY("������"), THURSDAY("�����"), 
	FRIDAY("�ݿ���"), SATURDAY("�����"), SUNDAY("�Ͽ���");
	
	final private String name;
	
	Day(String name){
		this.name = name;
	}
	
	public String value() {
		return name;
	}
}
