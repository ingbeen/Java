
public class GoodsStock {
	String goodsCode;  
	int stockNum;
	
	// 클래스를 생성하면 컴파일 할때 아래와 같은 메소드가 생성
	// 이러한 것을 '디폴트 생성자' 라 한다
	// public GoodsStock() {
	// }
	
	GoodsStock(String code, int num){
		goodsCode = code;
		stockNum = num;
	}
	
	// 동일 패키지 내에서는 public 을 안 써도 참조가능                    
    void addStock(int amount) { 
        stockNum += amount;               
    } 
    int subtractStock(int amount) { 
        if (stockNum < amount) {
        	return 0;
        }
        stockNum -= amount;             
        return amount; 
    }
}
