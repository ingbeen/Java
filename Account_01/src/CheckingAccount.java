
public class CheckingAccount extends Account {
	
	// 아래는 자동으로 생성되는 디폴트 생성자인데
	// super() 를 통해서 자동으로 부모클래스도 생성된다
	//	CheckingAccount(){
	//		super();
	//	}
	
	String cardNo; 
	
    CheckingAccount(String accountNo, String ownerName,  int balance, String cardNo) {
    	super(accountNo, ownerName, balance);
		this.cardNo = cardNo; 
	} 
    
    int pay(String cardNo, int amount) throws Exception {   
        if (!cardNo.equals(this.cardNo) || (balance < amount)) 
            throw new Exception("지불이 불가능합니다."); 
        return withdraw(amount); 
    }
}
