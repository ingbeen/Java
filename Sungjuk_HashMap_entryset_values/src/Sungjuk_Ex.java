import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Sungjuk_Ex {
	public static void main(String[] args) {
		HashMap<String, Sungjuk> hashmap = new HashMap<String, Sungjuk>();
		Scanner scan = new Scanner(System.in);

		while(true) {
			int menu;
			printMenu();
			System.out.print("�޴� ���� => ");
			
			// ���� ���� ���� �Է¹����� ���๮�� ����ְ� �ٽ�
			try {
				menu = scan.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
			
			// �޴� ���ú� ���� �޼ҵ�
			if(menu == 6) {
				System.out.println("The End...");
				break;
			} else if(menu == 1) {
				menu_1(hashmap);
			} else if(menu == 2) {
				if (hashmap.size() > 0) {
					menu_2(hashmap);
				} else {
					System.out.println("��ȸ�� ������ �����ϴ�\n");
				}
			} else if(menu == 3) {
				menu_3(hashmap);
			} else if(menu == 4) {
				menu_4(hashmap);
			} else if(menu == 5) {
				menu_5(hashmap);
			} else {			
				System.out.println("�߸��� �Է��Դϴ�\n");
			}
		}
		
	}

	
	// �޴� ���
	public static void printMenu() {
		System.out.println("*** �������� ***");
		System.out.println("1. �������� �Է�");
		System.out.println("2. �������� ���");
		System.out.println("3. �������� ��ȸ");
		System.out.println("4. �������� ����");
		System.out.println("5. �������� ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}
	
	
	// �й� ����
	// ������ȸ, ���������� ����� �޼ҵ�
	// �Է¹޴� �й��� �����ϴ��� �˻��Ͽ� �����Ѵٸ� �ش� ������ü ��ȯ
	// ���ٸ� null ������ ��ȯ
	public static Sungjuk choice(HashMap<String, Sungjuk> hashmap) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		if(hashmap.containsKey(choice)) {
			return hashmap.get(choice);
		}
		
		System.out.println("�������� �ʴ� �й��Դϴ�\n");
		return null;
	}


	// �Է� �� ���
	public static void menu_1(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = new Sungjuk();
		obj.input();
		if(hashmap.containsKey(obj.hakbun)) {
			System.out.println("\n�й� �Է� ����(�ߺ�)!!\n");
			return;
		}
		obj.process();
		hashmap.put(obj.hakbun, obj);
		System.out.println("\n���� ���� �Է� ����!!\n");
	}
	

	// ��ü ������ ���
	public static void menu_2(HashMap<String, Sungjuk> hashmap) {
		// keyset ����
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		Set<String> keyset = hashmap.keySet();
		for(String key : keyset) {
			hashmap.get(key).output();
			Sungjuk.tot_avg += hashmap.get(key).avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
		
		// entryset ����
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		// hashmap�� key�� ��ü�� �ִ� (HashMap)
		// entryset���� ��� Key�� ��ü�� �ű�� (Set)
		// it_entry���� �ѽ��� key�� ��ü�� �������� ���� �ű�� (Iterator)
		// �Ʒ����� �ݺ�
		// Map.Entry e���� �ѽ��� key�� ��ü�� �ű�� (Map.Entry)
		// obj�� e�� �ִ� ��ü�� �ű�� (Sungjuk)
		Set entryset = hashmap.entrySet();
		Iterator it_entry = entryset.iterator();
		while(it_entry.hasNext()) {
			// Ű�� ���� Map.Entry�� ĳ��Ʈ ������
			// ĳ��Ʈ�� ���ִ� ������ 
			Map.Entry e = (Map.Entry) it_entry.next();
			// ĳ��Ʈ�� ���ִ� ������ Map.Entry�� �Ҷ� <String, Sungjuk>�� �����༭
			Sungjuk obj = (Sungjuk) e.getValue();
			obj.output();
			Sungjuk.tot_avg += obj.avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n", entryset.size(), Sungjuk.getTotal_avg() / entryset.size());

		// entryset ���� 2
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		for(Map.Entry<String, Sungjuk> e : hashmap.entrySet()) {
			e.getValue().output();
			Sungjuk.tot_avg += e.getValue().avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
		
		// values ����
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		for(Sungjuk obj : hashmap.values()) {
			obj.output();
			Sungjuk.tot_avg += obj.avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
	}
	
	
	
	// �л��� ������ ��ȸ
	public static void menu_3(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = choice(hashmap);
		if(obj == null) {
			return;
		}
		
		System.out.println("             *** ����ǥ ***");
		System.out.println("=======================================");
		System.out.println("�й�     �̸�     ����     ����      ����     ����       ���      ���");
		System.out.println("=======================================");
		obj.output();
		System.out.println("=======================================\n");
	}
	
	
	// �������� ����
	public static void menu_4(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = choice(hashmap);
		if(obj == null) {
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� => ");
		obj.kor = scan.nextInt();
		System.out.print("���� �Է� => ");
		obj.eng = scan.nextInt();
		System.out.print("���� �Է� => ");
		obj.math = scan.nextInt();
		System.out.println();
		
		obj.process();
		System.out.println("\n�������� ���� ����!!\n");
	}
	
	
	//�������� ����
	public static void menu_5(HashMap<String, Sungjuk> hashmap) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ �й� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		if(hashmap.containsKey(choice)) {
			hashmap.remove(choice);
			System.out.println("�������� ���� ����!!\n");
			return;
		}
		System.out.println("�������� �ʴ� �й��Դϴ�\n");
	}

}
