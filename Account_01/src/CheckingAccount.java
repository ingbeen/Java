
public class CheckingAccount extends Account {
	
	// �Ʒ��� �ڵ����� �����Ǵ� ����Ʈ �������ε�
	// super() �� ���ؼ� �ڵ����� �θ�Ŭ������ �����ȴ�
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
            throw new Exception("������ �Ұ����մϴ�."); 
        return withdraw(amount); 
    }
}
