
public enum Season {
	// 생성자 생성할때마다 다른값을 지정해줄 때 파라미터 지정
	SPRING("봄", 1), SUMMER("여름", 2), FALL("가을", 3), WINTER("겨울", 4);

	final private String name;
	final private int num;
	
	// 생성자 초기화, 파라미터의 name을 위의 name에 저장
	Season(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	// name 반환
	String value() {
		return name;
	}
	
	int value2() {
		return num;
	}
}
