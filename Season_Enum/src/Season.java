
public enum Season {
	// ������ �����Ҷ����� �ٸ����� �������� �� �Ķ���� ����
	SPRING("��", 1), SUMMER("����", 2), FALL("����", 3), WINTER("�ܿ�", 4);

	final private String name;
	final private int num;
	
	// ������ �ʱ�ȭ, �Ķ������ name�� ���� name�� ����
	Season(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	// name ��ȯ
	String value() {
		return name;
	}
	
	int value2() {
		return num;
	}
}
