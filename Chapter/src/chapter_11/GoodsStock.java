package chapter_11;

public class GoodsStock {
	String goodsCode;
	int stockNum;
	GoodsStock(String goodsCode, int stockNum){
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}
	public String toString() {
		String str = "��ǰ�ڵ� : " + goodsCode + " ������� : " + stockNum;
		return str;
	}
}