public class Sungjuk_Ex {
	
	// �ִ� �л� ��
	final static int MAX = 100;
	
	public static void main(String[] args) {

		// �й��� exit �Է��ϸ� ����
		// �Է°����� ������ �Ǽ��� 100���� ����
		// �������� �л����� ��ü��� ���ϱ�
		
		Sungjuk[] s = new Sungjuk[MAX];
		
		// ������ �Է� �� ���, ���л��� ����
		input_2(s);
		
		// ������ ���
		output_2(s);
		
	}
	
	
	// ���ʵ����� �Է� �� ���
	public static void input_2(Sungjuk[] s) {
		for (int i = 0; i < s.length; i++) {
			s[i] = new Sungjuk();
			s[i].input();
			if (s[i].number.equals("exit")) {
				break;
			}
			s[i].processc();
		}
	}

	// ������ ���
	public static void output_2(Sungjuk[] s) {
		System.out.printf("\t\t\t*** ����ǥ ***\n");
		System.out.println("===========================================================");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.println("===========================================================");
		for (int i = 0; i < Sungjuk.cnt; i++) {
			s[i].output();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t�л��� : %d\t\t��ü��� : %.2f\n", Sungjuk.cnt, Sungjuk.getTotal_avg());
	}

}
