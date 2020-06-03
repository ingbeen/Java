import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgram {
	// �����ͺ��̽� ����(�̱���)
	// ���� �޼ҵ� ����� ����õ�
	static Connection con = ConnectionOracle.DB();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int menu;
		
		main :
		while(true) {
			// ���θ޴�
			System.out.println("*** ���� �޴� ***");
			System.out.println("1. ȸ������");
			System.out.println("2. ��������");
			System.out.println("3. ������������");
			System.out.println("4. ���α׷� ����");
			System.out.print("�޴� ����  => ");
			
			// �޴����ð� ���� �˻�(���� ����)
			try {
				menu = scan.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
				
			// 1�� ȸ����������
			if(menu == 1) {
				while(true) {
					System.out.println("*** ȸ���������� ***");
					System.out.println("1. ȸ������ �Է�");
					System.out.println("2. ȸ������ ���");
					System.out.println("3. ȸ������ ��ȸ");
					System.out.println("4. ȸ������ ����");
					System.out.println("5. ȸ������ ����");
					System.out.println("6. ���� �޴�");
					System.out.print("�޴� ����  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_memberControl.insert();
					} else if(menu == 2) {
						Book_memberControl.select();
					} else if(menu == 3) {
						Book_memberControl.search(); 
					} else if(menu == 4) {
						Book_memberControl.update(); 
					} else if(menu == 5) {
						Book_memberControl.delete(); 
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
					}
				}
				
			// 2�� ������������
			} else if(menu == 2) {
				while(true) {
					System.out.println("*** ������������ ***");
					System.out.println("1. �������� �Է�");
					System.out.println("2. �������� ���");
					System.out.println("3. �������� ��ȸ");
					System.out.println("4. �������� ����");
					System.out.println("5. �������� ����");
					System.out.println("6. ���� �޴�");
					System.out.print("�޴� ����  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_infoControl.insert();
					} else if(menu == 2) {
						Book_infoControl.select();
					} else if(menu == 3) {
						Book_infoControl.search(); 
					} else if(menu == 4) {
						Book_infoControl.update(); 
					} else if(menu == 5) {
						Book_infoControl.delete(); 
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
					}
				}
				
			// 3�� �����������
			} else if(menu == 3) {
				while(true) {
					System.out.println("*** ����������� ***");
					System.out.println("1. ��������");
					System.out.println("2. �����ݳ�");
					System.out.println("3. ���� �������� ��ȸ");
					System.out.println("4. ���� �������� ����");
					System.out.println("5. ���� �������� ����");
					System.out.println("6. ���� �޴�");
					System.out.print("�޴� ����  => ");
					try {
						menu = scan.nextInt();
					} catch(InputMismatchException ime) {
						System.out.println("\n�߸��� ���� �Է��ϼ̽��ϴ�\n");
						scan.nextLine();
						continue;
					}
					System.out.println();
					if(menu == 1) {
						Book_borrowControl.bookLending();
					} else if(menu == 2) {
						Book_borrowControl.bookReturn();
					} else if(menu == 3) {
						Book_borrowControl.searchLending();
					} else if(menu == 4) {
						Book_borrowControl.lendingList();
					} else if(menu == 5) {
						Book_borrowControl.all_LendingList();
					} else if(menu == 6) {
						continue main;
					} else {
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
					}
				}
			
			// 4�� ���α׷� ����
			} else if(menu == 4) {
				System.out.println("�̿����ּż� �����մϴ�");
				break;
			} else {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
			}
		}
	}
}
