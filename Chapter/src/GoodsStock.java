
public class GoodsStock {
	String goodsCode;  
	int stockNum;
	
	// Ŭ������ �����ϸ� ������ �Ҷ� �Ʒ��� ���� �޼ҵ尡 ����
	// �̷��� ���� '����Ʈ ������' �� �Ѵ�
	// public GoodsStock() {
	// }
	
	GoodsStock(String code, int num){
		goodsCode = code;
		stockNum = num;
	}
	
	// ���� ��Ű�� �������� public �� �� �ᵵ ��������                    
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
