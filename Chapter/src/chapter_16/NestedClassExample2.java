package chapter_16;

public class NestedClassExample2 {
	public static void main(String[] gars) {
		Cart cart = new Cart();
		cart.addItem("���ݷ�", 3, 1000);
		cart.addItem("����ũ", 1, 25000);
		cart.addItem("������", 1, 7000);
		Cart.Item item = new Cart.Item("�ɴٹ�", 1, 50000); 
		cart.list.add(item);
		printCart(cart);
	}
	
	static void printCart(Cart cart) {
		int num = cart.getItemNum();
		System.out.printf("             ��ǰ��   ����        �ܰ�           �ݾ�\n");        
        System.out.println("----------------------------------");        
        for(int i = 0; i < num; i++) {
        	Cart.Item item = cart.getItem(i);
        	System.out.printf("%3d %5s %5d %7d %7d \n", i+1, 
                    item.name, item.num, item.unitPrice, item.getPrice());
        }
        System.out.println("----------------------------------");        
        System.out.printf("          ��ǰ�� %d         �Ѱ�  %10d %n", Cart.Item.cnt, cart.getTotalPrice());
	}
}
