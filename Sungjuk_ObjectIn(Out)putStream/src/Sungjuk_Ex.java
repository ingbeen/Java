import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Sungjuk_Ex {
	final static int MAX = 100;
	
	public static void main(String[] args) {
		Sungjuk obj[] = new Sungjuk[MAX];
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			printMenu();
			System.out.print("�޴� ���� => ");
			menu = scan.nextInt();
			System.out.println();
			
			if (menu == 6) {
				System.out.println("The End...");
				break;
			}
			
			switch (menu)
			{
				case 1:
					input_sungjuk(obj);

					break;
				case 2:
					output_sungjuk(obj);
					break;
				case 3:
					search_sungjuk(obj);
					break;
				case 4:
					update_sungjuk(obj);
					break;
				case 5:
					delete_sungjuk(obj);
					break;
				default: 
				
			}
		}	
	}
	
	static void printMenu()
	{
		System.out.println("*** �������� ***");
		System.out.println("1. �������� �Է�");
		System.out.println("2. �������� ���");
		System.out.println("3. �������� ��ȸ");
		System.out.println("4. �������� ����");
		System.out.println("5. �������� ����");
		System.out.println("6. ���α׷� ����");
		System.out.println();
	}
	
	static void input_sungjuk(Sungjuk obj[])
	{
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		File file = new File("sungjuk.dat");
        try {
        	if(!file.exists()){
        		out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
        	}
    		in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
    		obj[Sungjuk.cnt] = new Sungjuk();
    		obj[Sungjuk.cnt].input();
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(obj[Sungjuk.cnt].hakbun)) {
    				System.out.println("\n�й� �Է� ����(�ߺ�)!!\n");
    				return;
    			}
    		}
    		obj[Sungjuk.cnt].process();
    		Sungjuk.cnt++;
            out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
            for (int i=0; i<Sungjuk.cnt; i++) {
            	
            	out.writeObject(obj[i]);
            }
            System.out.println("\n�������� �Է� ����!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
        }
        finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	static void output_sungjuk(Sungjuk obj[])
	{
		ObjectInputStream in = null;
        try {
     		in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
     		
     		if (Sungjuk.cnt == 0)
    		{
    			System.out.println("����� ���������� �����ϴ�!!\n");
    			return;
    		}
    		
    		System.out.println("             *** ����ǥ ***");
    		System.out.println("=======================================");
    		System.out.println("�й�    �̸�    ����    ����    ����    ����    ���   ���");
    		System.out.println("=======================================");
    		Sungjuk.tot_avg = 0;
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			obj[i].output();
    			Sungjuk.tot_avg += obj[i].avg;
    		}
    		System.out.println("=======================================");
    		System.out.printf("\t ���л��� : %d, ��ü ��� : %5.2f\n\n",
    			Sungjuk.cnt, Sungjuk.getTotal_avg());
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
        }
        finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	static void search_sungjuk(Sungjuk obj[])
	{
		ObjectInputStream in = null;
        try {
     		in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
     		Scanner scan = new Scanner(System.in);
	
    		System.out.print("��ȸ�� �й� �Է� => ");
    		String hakbun = scan.next();
    		
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(hakbun)) {
    				System.out.println("\n�й�    �̸�    ����    ����    ����    ����    ���   ���");
    				System.out.println("=======================================");
    				obj[i].output();
    				System.out.println("=======================================\n");
    				return;
    			}	
    		}
    		System.out.println("\n��ȸ�� �й� �Է� ����!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
        }
        finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	static void update_sungjuk(Sungjuk obj[])
	{
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		boolean flag = false;
		
        try {
     		in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
     		Scanner scan = new Scanner(System.in);
	
     		System.out.print("������ �й� �Է� => ");
    		String hakbun = scan.next();
    		
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(hakbun)) {
    				System.out.print("���� �Է� => ");
    				obj[i].kor = scan.nextInt();
    				System.out.print("���� �Է� => ");
    				obj[i].eng = scan.nextInt();
    				System.out.print("���� �Է� => ");
    				obj[i].math = scan.nextInt();
    				obj[i].process();
    				System.out.println("\n�������� ���� ����!!\n");
    				flag = true;
    			}	
    		}
    		
			if (flag == true)
			{
				out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
				for (int i=0; i<Sungjuk.cnt; i++) {
					out.writeObject(obj[i]);
				}
			}
    		else
            	System.out.println("\n������ �й� �Է� ����!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
        }
        finally {
            try {
            	in.close();
            	out.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	static void delete_sungjuk(Sungjuk obj[])
	{
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		int k=0;
		boolean flag=false;
        try {
     		in = new ObjectInputStream(new FileInputStream("sungjuk.dat"));
     		Scanner scan = new Scanner(System.in);
	
    		System.out.print("��ȸ�� �й� �Է� => ");
    		String hakbun = scan.next();
    		
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(hakbun)) {
    				k = i;
    				flag = true;
    			}	
    		}
    		if (flag == true) {
    			for (int i=k; i < Sungjuk.cnt-1; i++) {
					obj[i] = obj[i+1];
				}
				Sungjuk.cnt--;
				System.out.println("\n�������� ���� ����!!\n");
				out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
				for (int i=0; i<Sungjuk.cnt; i++) {
					out.writeObject(obj[i]);
				}
    		}
    		else 
    			System.out.println("\n������ �й� �Է� ����!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
        catch (EOFException eofe) {
            System.out.println("��");
        }
        catch (IOException ioe) {
            System.out.println("������ ���� �� �����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
        }
        finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
}