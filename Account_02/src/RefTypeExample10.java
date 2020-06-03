
public class RefTypeExample10 {
    public static void main(String args[]) {         
    	Account obj = new Account("111-22-33333333", "ȫ�浿", 100000);         
    	if (obj instanceof CheckingAccount)   {          
    		pay((CheckingAccount) obj); 
    	} else {        
    		System.out.println("ĳ��Ʈ�� �� ���� Ÿ���Դϴ�.");   
    	}
	}     
    
    static void pay(CheckingAccount obj)  {         
    	try {             
    		int amount = obj.pay("5555-6666-7777-8888", 47000);                  
    		System.out.println("�����: " + amount);             
    		System.out.println("ī���ȣ: " + obj.cardNo);        
    	}catch (Exception e) {                
    		System.out.println(e.getMessage());         
    	}     
	}
}
