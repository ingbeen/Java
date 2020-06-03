import java.io.*;
import java.util.Scanner;

public class Sangpum_Ex {

	// 최대 판매 건수
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
				System.out.println("잘못된 값을 입력하셨습니다\n");
				scan.nextLine();
				continue;
			}

			if (menu == 6) {
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else if (menu == 1) {
				menu_1(obj);
			} else if (menu == 2) {
				if (Sangpum.cnt > 0) {
					menu_2(obj);
				} else {
					System.out.println("입력된 값이 없습니다");
					System.out.println();
				}
			} else if (menu == 3) {
				menu_3(obj);
			} else if (menu == 4) {
				menu_4(obj);
			} else if (menu == 5) {
				menu_5(obj);
			} else {
				System.out.println("잘못된 값을 입력하셨습니다");
				System.out.println();
			}
		}
		
	}
	

	public static void menu() {
		System.out.println("*** 판매 현황 ***");
		System.out.println("1. 판매정보 입력");
		System.out.println("2. 판매정보 출력");
		System.out.println("3. 판매정보 조회");
		System.out.println("4. 판매정보 수정");
		System.out.println("5. 판매정보 삭제");
		System.out.println("6. 판매정보 종료");
		System.out.println();
		System.out.print("메뉴번호 입력 => ");
	}

	// 기초데이터 입력 및 계산
	public static void menu_1(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		// 파일없으면 생성
		File file = new File("sangpum.dat");
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("파일생성에 실패했습니다\n");
			}
		}
		
		try {
			
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			obj[Sangpum.cnt] = new Sangpum();
			obj[Sangpum.cnt].input(obj);
			for(int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if(obj[i].code.equals(obj[Sangpum.cnt].code)) {
					System.out.println("코드명이 중복되었습니다\n");
					return;
				}
			}
			obj[Sangpum.cnt].processc();
			Sangpum.cnt++;
			
			// 입력된 obj객체를 sangpum.dat에 저장
			out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
			for (int i = 0; i < Sangpum.cnt; i++) {
				out.writeObject(obj[i]);
			}
			System.out.println("상품정보 입력 성공\n");
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다\n");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다\n");
        } finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
	}
	

	// 전체 데이터 출력
	public static void menu_2(Sangpum[] obj) {
		ObjectInputStream in = null;

		if (Sangpum.cnt == 0)
		{
			System.out.println("출력할 상품정보가 없습니다!!\n");
			return;
		}
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			System.out.printf("\t\t*** 판매 현황 ***\n");
			System.out.println("=============================================");
			System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
			System.out.println("=============================================");
			Sangpum.tot_price = 0;
			for (int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				obj[i].output();
				obj[i].processc_tot();
			}
			System.out.println("=============================================");
			System.out.printf("\t\t\t판매액 합계 : %d\n", Sangpum.tot_price);
			System.out.println();
			
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다\n");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다\n");
        } finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
		
	
	// 상품정보 조회
	public static void menu_3(Sangpum[] obj) {
		ObjectInputStream in = null;
		
		if (Sangpum.cnt == 0)
		{
			System.out.println("출력할 상품정보가 없습니다!!\n");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("조회할 상품코드 입력 => ");
		choice = scan.next();
		System.out.println();
		
		try {
			in = new ObjectInputStream(new FileInputStream("sangpum.dat"));
			boolean k = true;
			for (int i = 0; i < Sangpum.cnt; i++) {
				obj[i] = (Sangpum) in.readObject();
				if (obj[i].code.equals(choice))
				System.out.printf("\t\t*** %s의 판매 현황 ***\n", obj[i].code);
				System.out.println("=============================================");
				System.out.printf("상품코드\t상품명\t수량\t단가\t금액\t   평가\n");
				System.out.println("=============================================");
				obj[i].output();
				System.out.println("=============================================");
				System.out.println();
				k = false;
				return;
			}
			if (k) {
				System.out.println("존재하지 않는 상품코드입니다");
				System.out.println();
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다\n");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다\n");
        } finally {
            try {
            	in.close();
            }          
            catch (Exception e) {
            }
        }
	}
	
	
	// 상품정보 수정
	public static void menu_4(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		Scanner scan = new Scanner(System.in);
		String choice;
		int su;
		int dan;
		
		System.out.print("수정할 상품코드 입력 => ");
		choice = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
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
					
					System.out.println("판매정보 수정 성공");
					System.out.println();
					k = false;
				}
			}
			if (k) {
				System.out.println("존재하지 않는 상품코드입니다");
				System.out.println();
			}
			
			// 입력된 obj객체를 sangpum.dat에 저장
			if(!(k)) {
				out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
				for (int i = 0; i < Sangpum.cnt; i++) {
					out.writeObject(obj[i]);
				}
				System.out.println("상품정보 입력 성공\n");
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다\n");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다\n");
        } finally {
            try {
            	in.close();
                out.close();
            }          
            catch (Exception e) {
            }
        }
		
	}

	
	// 상품정보 삭제
	public static void menu_5(Sangpum[] obj) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("삭제할 상품코드 입력 => ");
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
				System.out.println("존재하지 않는 상품코드입니다");
				System.out.println();
			}
			
			// 입력된 obj객체를 sangpum.dat에 저장
			if(!(k)) {
				out = new ObjectOutputStream(new FileOutputStream("sangpum.dat"));
				for (int i = 0; i < Sangpum.cnt; i++) {
					out.writeObject(obj[i]);
				}
				System.out.println("상품정보 삭제 성공\n");
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다\n");
        } catch (EOFException eofe) {
            System.out.println("끝");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다\n");
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
