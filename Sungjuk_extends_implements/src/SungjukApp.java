
public class SungjukApp {

	final static int MAX = 100;

	public static void main(String[] args) {

		Sungjuk[] sungobj = new Sungjuk[MAX];
		Personinfo[] perobj = new Personinfo[MAX];

		// �����Է�
		for (int i = 0; i < MAX; i++) {
			sungobj[i] = new Sungjuk();
			boolean k = sungobj[i].input();
			if (k) {
				break;
			}
			sungobj[i].process();
		}

		// �������� �Է�
		for (int i = 0; i < MAX; i++) {
			perobj[i] = new Personinfo();
			boolean k = perobj[i].input();
			if (k) {
				break;
			}
		}

		// ����ǥ ���
		System.out.printf("\t\t\t*** ����ǥ ***\n");
		System.out.printf("===========================================================\n");
		System.out.printf("�й�\t�̸�\t����\t����\t����\t����\t���\t���\n");
		System.out.printf("===========================================================\n");
		out(sungobj, sungobj);
		System.out.printf("===========================================================\n");
		System.out.println();

		// �������� ���
		System.out.printf("\t\t*** �������� ***\n");
		System.out.printf("====================================\n");
		System.out.printf("�й�\t�̸�\t��ȭ��ȣ        \t�ּ�\n");
		System.out.printf("====================================\n");
		out(perobj, perobj);
		System.out.printf("====================================\n");

	}

	public static void out(Person[] obj, Personable[] sungobj) {
		for (int i = 0; i < MAX; i++) {
			if (obj[i].hakbun.equals("exit")) {
				break;
			} else {
				sungobj[i].output();
			}
		}

	}

}
