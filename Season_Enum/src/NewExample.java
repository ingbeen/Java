
public class NewExample {
	public static void main(String[] agrs) {
		ClothingInfo obj = new ClothingInfo("32919", "���� Ƽ����", "��100%", ClothingInfo.Season.SUMMER);
		System.out.println("��ǰ�ڵ� : " + obj.code);
		System.out.println("��ǰ�ڵ� : " + obj.name);
		System.out.println("��ǰ�ڵ� : " + obj.material);
		System.out.println("��ǰ�ڵ� : " + obj.season);
	}
}
