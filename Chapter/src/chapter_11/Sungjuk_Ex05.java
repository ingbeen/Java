package chapter_11;

public class Sungjuk_Ex05 {
	public static void main(String[] args) {
		Sungjuk obj1 = new Sungjuk();
		
		obj1.input();
		obj1.process();
		Sungjuk obj2 = (Sungjuk) obj1.clone();
		
		System.out.println();
		
		// �������̵��� equals�� toString���
		// toString�� ��ø� �����൵ ����ȴ�
		if(obj1.equals(obj2)) {
			System.out.println("����");
			System.out.println(obj1);
		} else {
			System.out.println("�ٸ���");
			System.out.println(obj2);
		}
	}
}
