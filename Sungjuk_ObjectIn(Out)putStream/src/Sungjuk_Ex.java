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
			System.out.print("메뉴 선택 => ");
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
		System.out.println("*** 성적관리 ***");
		System.out.println("1. 성적정보 입력");
		System.out.println("2. 성적정보 출력");
		System.out.println("3. 성적정보 조회");
		System.out.println("4. 성적정보 수정");
		System.out.println("5. 성적정보 삭제");
		System.out.println("6. 프로그램 종료");
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
    				System.out.println("\n학번 입력 오류(중복)!!\n");
    				return;
    			}
    		}
    		obj[Sungjuk.cnt].process();
    		Sungjuk.cnt++;
            out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
            for (int i=0; i<Sungjuk.cnt; i++) {
            	
            	out.writeObject(obj[i]);
            }
            System.out.println("\n성적정보 입력 성공!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
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
    			System.out.println("출력할 성적정보가 없습니다!!\n");
    			return;
    		}
    		
    		System.out.println("             *** 성적표 ***");
    		System.out.println("=======================================");
    		System.out.println("학번    이름    국어    영어    수학    총점    평균   등급");
    		System.out.println("=======================================");
    		Sungjuk.tot_avg = 0;
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			obj[i].output();
    			Sungjuk.tot_avg += obj[i].avg;
    		}
    		System.out.println("=======================================");
    		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n",
    			Sungjuk.cnt, Sungjuk.getTotal_avg());
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
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
	
    		System.out.print("조회할 학번 입력 => ");
    		String hakbun = scan.next();
    		
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(hakbun)) {
    				System.out.println("\n학번    이름    국어    영어    수학    총점    평균   등급");
    				System.out.println("=======================================");
    				obj[i].output();
    				System.out.println("=======================================\n");
    				return;
    			}	
    		}
    		System.out.println("\n조회할 학번 입력 오류!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
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
	
     		System.out.print("수정할 학번 입력 => ");
    		String hakbun = scan.next();
    		
    		for (int i=0; i<Sungjuk.cnt; i++) {
    			obj[i] = (Sungjuk) in.readObject();
    			if (obj[i].hakbun.equals(hakbun)) {
    				System.out.print("국어 입력 => ");
    				obj[i].kor = scan.nextInt();
    				System.out.print("영어 입력 => ");
    				obj[i].eng = scan.nextInt();
    				System.out.print("수학 입력 => ");
    				obj[i].math = scan.nextInt();
    				obj[i].process();
    				System.out.println("\n성적정보 수정 성공!!\n");
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
            	System.out.println("\n수정할 학번 입력 오류!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
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
	
    		System.out.print("조회할 학번 입력 => ");
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
				System.out.println("\n성적정보 삭제 성공!!\n");
				out = new ObjectOutputStream(new FileOutputStream("sungjuk.dat"));
				for (int i=0; i<Sungjuk.cnt; i++) {
					out.writeObject(obj[i]);
				}
    		}
    		else 
    			System.out.println("\n삭제할 학번 입력 오류!!\n");
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (EOFException eofe) {
            System.out.println("끝");
        }
        catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
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