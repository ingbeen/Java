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
			System.out.print("메뉴 선택 => ");
			
			// 정수 외의 값을 입력받을시 개행문자 비워주고 다시
			try {
				menu = scan.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("\n잘못 입력하셨습니다\n");
				scan.nextLine();
				continue;
			}
			System.out.println();
			
			// 메뉴 선택별 실행 메소드
			if(menu == 6) {
				System.out.println("The End...");
				break;
			} else if(menu == 1) {
				menu_1(hashmap);
			} else if(menu == 2) {
				if (hashmap.size() > 0) {
					menu_2(hashmap);
				} else {
					System.out.println("조회할 성적이 없습니다\n");
				}
			} else if(menu == 3) {
				menu_3(hashmap);
			} else if(menu == 4) {
				menu_4(hashmap);
			} else if(menu == 5) {
				menu_5(hashmap);
			} else {			
				System.out.println("잘못된 입력입니다\n");
			}
		}
		
	}

	
	// 메뉴 출력
	public static void printMenu() {
		System.out.println("*** 성적관리 ***");
		System.out.println("1. 성적정보 입력");
		System.out.println("2. 성적정보 출력");
		System.out.println("3. 성적정보 조회");
		System.out.println("4. 성적정보 수정");
		System.out.println("5. 성적정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	
	// 학번 선택
	// 성적조회, 성적수정에 사용할 메소드
	// 입력받는 학번이 존재하는지 검사하여 존재한다면 해당 성적객체 반환
	// 없다면 null 값으로 반환
	public static Sungjuk choice(HashMap<String, Sungjuk> hashmap) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("선택할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		if(hashmap.containsKey(choice)) {
			return hashmap.get(choice);
		}
		
		System.out.println("존재하지 않는 학번입니다\n");
		return null;
	}


	// 입력 및 계산
	public static void menu_1(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = new Sungjuk();
		obj.input();
		if(hashmap.containsKey(obj.hakbun)) {
			System.out.println("\n학번 입력 오류(중복)!!\n");
			return;
		}
		obj.process();
		hashmap.put(obj.hakbun, obj);
		System.out.println("\n성적 정보 입력 성공!!\n");
	}
	

	// 전체 데이터 출력
	public static void menu_2(HashMap<String, Sungjuk> hashmap) {
		// keyset 버전
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		Set<String> keyset = hashmap.keySet();
		for(String key : keyset) {
			hashmap.get(key).output();
			Sungjuk.tot_avg += hashmap.get(key).avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
		
		// entryset 버전
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		// hashmap에 key와 객체가 있다 (HashMap)
		// entryset으로 모든 Key와 객체를 옮긴다 (Set)
		// it_entry으로 한쌍의 key와 객체를 차곡차곡 전부 옮긴다 (Iterator)
		// 아래부터 반복
		// Map.Entry e으로 한쌍의 key와 객체를 옮긴다 (Map.Entry)
		// obj에 e에 있는 객체를 옮긴다 (Sungjuk)
		Set entryset = hashmap.entrySet();
		Iterator it_entry = entryset.iterator();
		while(it_entry.hasNext()) {
			// 키와 값을 Map.Entry로 캐스트 연산함
			// 캐스트를 해주는 이유는 
			Map.Entry e = (Map.Entry) it_entry.next();
			// 캐스트를 해주는 이유는 Map.Entry을 할때 <String, Sungjuk>을 안해줘서
			Sungjuk obj = (Sungjuk) e.getValue();
			obj.output();
			Sungjuk.tot_avg += obj.avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n", entryset.size(), Sungjuk.getTotal_avg() / entryset.size());

		// entryset 버전 2
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		for(Map.Entry<String, Sungjuk> e : hashmap.entrySet()) {
			e.getValue().output();
			Sungjuk.tot_avg += e.getValue().avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
		
		// values 버전
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		Sungjuk.tot_avg = 0;
		for(Sungjuk obj : hashmap.values()) {
			obj.output();
			Sungjuk.tot_avg += obj.avg;
		}
		System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n", hashmap.size(), Sungjuk.getTotal_avg() / hashmap.size());
	}
	
	
	
	// 학생별 데이터 조회
	public static void menu_3(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = choice(hashmap);
		if(obj == null) {
			return;
		}
		
		System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름     국어     영어      수학     총점       평균      등급");
		System.out.println("=======================================");
		obj.output();
		System.out.println("=======================================\n");
	}
	
	
	// 성적정보 수정
	public static void menu_4(HashMap<String, Sungjuk> hashmap) {
		Sungjuk obj = choice(hashmap);
		if(obj == null) {
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 입력 => ");
		obj.kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		obj.eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		obj.math = scan.nextInt();
		System.out.println();
		
		obj.process();
		System.out.println("\n성적정보 수정 성공!!\n");
	}
	
	
	//성적정보 삭제
	public static void menu_5(HashMap<String, Sungjuk> hashmap) {
		Scanner scan = new Scanner(System.in);
		String choice;
		
		System.out.print("선택할 학번 입력 => ");
		choice = scan.next();
		System.out.println();
		
		if(hashmap.containsKey(choice)) {
			hashmap.remove(choice);
			System.out.println("성적정보 삭제 성공!!\n");
			return;
		}
		System.out.println("존재하지 않는 학번입니다\n");
	}

}
