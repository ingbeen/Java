package chapter_16;

public class NestedClassExample7 {
    public static void main(String args[]) {
        MessageSender obj = new MessageSender() {
        	void send(String message) {
        		System.out.println("�߽� : ���̴ٽ�");
        		System.out.println("���� : ��������");
        		System.out.println("�޽��� : " + message);
        		System.out.println();
        	}
        };
        obj.send("�¸��");
    }
}

