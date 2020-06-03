
public class InheritanceExample7 {
    public static void main(String args[]) {         
    	Account obj1 = new Account("111-22-333333", "임꺽정", 10000);           
    	CheckingAccount obj2 = new CheckingAccount("444-55-666666", "홍길동", 20000, "5555-6666-7777-8888");         
    	CreditLineAccount obj3 = new CreditLineAccount("777-88-999999", "김선달", 30000, 20000000);         
    	BonusPointAccount obj4 = new BonusPointAccount("000-00-000000", "김미영", 0, 0);         
    	printAccountInfo(obj1);         
    	printAccountInfo(obj2);         
    	printAccountInfo(obj3);         
    	printAccountInfo(obj4);     
    	}     
    
    
    // 어떤 타입의 대한 instanceof 연산의 결과가 
    // true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.
    static void printAccountInfo(Account obj) {         
    	System.out.println("계좌번호:" + obj.accountNo);         
    	System.out.println("예금주 이름:" + obj.ownerName);         
    	System.out.println("잔액:" + obj.balance);   
    	if(obj instanceof CheckingAccount) {
    		CheckingAccount obj5 = (CheckingAccount)obj;
    		System.out.println("카드번호 : " + obj5.cardNo);
    	} else if(obj instanceof CreditLineAccount) {
    		CreditLineAccount obj5 = (CreditLineAccount)obj;
    		System.out.println("카드번호 : " + obj5.creditLine);
    	} else if(obj instanceof BonusPointAccount) {
    		BonusPointAccount obj5 = (BonusPointAccount)obj;
    		System.out.println("카드번호 : " + obj5.bonusPoint);
    	}
    	
    	System.out.println();     
	}
}
