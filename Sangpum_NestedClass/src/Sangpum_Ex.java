
public class Sangpum_Ex {

	public static void main(String[] args) {
		Sangpum obj = new Sangpum() {
			void output()
			{
				System.out.println("\t\t*** �Ǹ� ��Ȳ ***");
				System.out.println("===========================================");
				System.out.println("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t��");
				System.out.println("===========================================");
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%s\n",
						code, irum, su, dan, price, grade);
				System.out.println("===========================================");
				System.out.println();
			}
		};
		obj.input();
		obj.process();
		obj.output();
	}
}
