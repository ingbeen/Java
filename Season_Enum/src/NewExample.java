
public class NewExample {
	public static void main(String[] agrs) {
		ClothingInfo obj = new ClothingInfo("32919", "반팔 티셔츠", "면100%", ClothingInfo.Season.SUMMER);
		System.out.println("상품코드 : " + obj.code);
		System.out.println("상품코드 : " + obj.name);
		System.out.println("상품코드 : " + obj.material);
		System.out.println("상품코드 : " + obj.season);
	}
}
