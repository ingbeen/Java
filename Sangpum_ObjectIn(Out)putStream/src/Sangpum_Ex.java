import java.io.*;
import java.util.Scanner;

public class Sangpum_Ex {

	// �ִ� �Ǹ� �Ǽ�
	final static int MAX = 100;

	public static void main(String[] args) {

		Sangpum[] obj = new Sangpum[MAX];
		Scanner scan = new Scanner(System.in);

		while (true) {
			
			int menu;
			menu();

			try {
				menu = scan.nextInt();
				System.out.println();
			} catch (Exception e) {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�\n");
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("�̿����ּż� �����մϴ�");
				break;
			} else if (menu == 1) {
				menu_1(obj);
			} else if (menu == 2) {
				if (Sangpum.cnt > 0) {
					menu_2(obj);
				} else {
					System.out.println("�Էµ� ���� �����ϴ�");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(obj);
			} else if (menu == 4) {
				menu_4(obj);
			} else if (menu == 5) {
				menu_5(obj);
			} else {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�");
				System.out.println();
			}
		}
		
	}
	

	public static void menu() {
		System.out.println("*** �Ǹ� ��Ȳ ***");
		System.out.println("1. �Ǹ����� �Է�");
		System.out.println("2. �Ǹ����� ���");
		System.out.println("3. �Ǹ����� ��ȸ");
		System.out.println("4. �Ǹ����� ����");
		System.out.println("5. �Ǹ����� ����");
		System.out.println("6. �Ǹ����� ����");
		System.out.println();
		System.out.print("�޴���ȣ �Է� => ");
	}

	// ���ʵ����� �Է� �� ���
	public static void menu_1(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		// ���Ͼ����� ����
		File file = new File("sangpum.dat");
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("���ϻ����� �����߽��ϴ�\n");
			}
		}
		
		try {
			
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			obj[Sangpum.cnt] = new Sangpum();
			obj[Sangpum.cnt].input(obj);
			for(int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if(obj[i].code.equals(obj[Sangpum.cnt].code)) {
					System.out.println("�ڵ���� �ߺ��Ǿ����ϴ�\n");
					return;
				}
			}
			obj[Sangpum.cnt].processc();
			Sangpum.cnt++;
			
			// �Էµ� obj��ü�� sangpum.dat�� ����
			out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
			for (int i = 0; i < Sangpum.cnt; i++) {
				out.writeObject(obj[i]);
			}
			System.out.println("��ǰ���� �Է� ����\n");
		} catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�\n");
        } catch (EOFException eofe) {
            System.out.println("��");
        } catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�\n");
        } finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
	}
	

	// ��ü ������ ���
	public static void menu_2(Sangpum[] obj) {
		ObjectInputStream in = null;

		if (Sangpum.cnt == 0)
		{
			System.out.println("����� ��ǰ������ �����ϴ�!!\n");
			return;
		}
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			System.out.printf("\t\t*** �Ǹ� ��Ȳ ***\n");
			System.out.println("=============================================");
			System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
			System.out.println("=============================================");
			Sangpum.tot_price = 0;
			for (int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				obj[i].output();
				obj[i].processc_tot();
			}
			System.out.println("=============================================");
			System.out.printf("\t\t\t�Ǹž� �հ� : %d\n", Sangpum.tot_price);
			System.out.println();
			
		} catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�\n");
        } catch (EOFException eofe) {
            System.out.println("��");
        } catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�\n");
        } finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
		
	
	// ��ǰ���� ��ȸ
	public static void menu_3(Sangpum[] obj) {
		ObjectInputStream in = null;
		
		if (Sangpum.cnt == 0)
		{
			System.out.println("����� ��ǰ������ �����ϴ�!!\n");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("��ȸ�� ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			boolean k = true;
			for (int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if (obj[i].code.equals(choice))
				System.out.printf("\t\t*** %s�� �Ǹ� ��Ȳ ***\n", obj[i].code);
				System.out.println("=============================================");
				System.out.printf("��ǰ�ڵ�\t��ǰ��\t����\t�ܰ�\t�ݾ�\t   ��\n");
				System.out.println("=============================================");
				obj[i].output();
				System.out.println("=============================================");
				System.out.println();
				k = false;
				return;
			}
			if (k) {
				System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
				System.out.println();
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�\n");
        } catch (EOFException eofe) {
            System.out.println("��");
        } catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�\n");
        } finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	
	// ��ǰ���� ����
	public static void menu_4(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		Scanner scan = new Scanner(System.in);
		String choice;
		int su;
		int dan;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		System.out.println();
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			boolean k = true;
			for(int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if(obj[i].code.equals(choice)) {
					obj[i].su = su;
					obj[i].dan = dan;
					obj[i].processc();
					
					System.out.println("�Ǹ����� ���� ����");
					System.out.println();
					k = false;
				}
			}
			if (k) {
				System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
				System.out.println();
			}
			
			// �Էµ� obj��ü�� sangpum.dat�� ����
			if(!(k)) {
				out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
				for (int i = 0; i < Sangpum.cnt; i++) {
					out.writeObject(obj[i]);
				}
				System.out.println("��ǰ���� �Է� ����\n");
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�\n");
        } catch (EOFException eofe) {
            System.out.println("��");
        } catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�\n");
        } finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
		
	}

	
	// ��ǰ���� ����
	public static void menu_5(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("������ ��ǰ�ڵ� �Է� => ");
		choice = scan.next();
		System.out.println();
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			boolean k = true;
			for(int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if(obj[i].code.equals(choice)) {
					for(int j = i + 1; j < Sangpum.cnt; j++) {
						obj[i] = obj[j];
						i++;
					}
					obj[i] = null;
					Sangpum.cnt--;
					k = false;
				}
			}
			if (k) {
				System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�");
				System.out.println();
			}
			
			// �Էµ� obj��ü�� sangpum.dat�� ����
			if(!(k)) {
				out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
				for (int i = 0; i < Sangpum.cnt; i++) {
					out.writeObject(obj[i]);
				}
				System.out.println("��ǰ���� ���� ����\n");
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�\n");
        } catch (EOFException eofe) {
            System.out.println("��");
        } catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�\n");
        } finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
	}
}
