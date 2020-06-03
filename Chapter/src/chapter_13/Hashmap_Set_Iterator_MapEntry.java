package chapter_13;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hashmap_Set_Iterator_MapEntry {
    public static void main(String[] args) {
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
    	hashmap.put("blue", 80);
    	hashmap.put("hong", 90);
    	hashmap.put("white", 100);
    	
    	String name = null;
    	int maxScore = 0;
    	int totalScore = 0;
    	
    	// 1
    	Iterator it_entry1 = hashmap.entrySet().iterator();
    	while(it_entry1.hasNext()) {
    		Map.Entry<String, Integer> e = (Map.Entry) it_entry1.next();
    		if(e.getValue() > maxScore) {
    			maxScore = e.getValue();
    			name = e.getKey();
    		}
    		totalScore += e.getValue();
    	}
    	System.out.println("평균점수 : " + totalScore / hashmap.size());
    	System.out.println("최고점수 : " + maxScore);
    	System.out.println("최고점수를 받은 아이디 : " + name);
    	
    	// 2
    	maxScore = 0;
    	totalScore = 0;
    	Set entryset2 = hashmap.entrySet();
		Iterator<Map.Entry<String, Integer>> it_entry2 = entryset2.iterator();
    	while(it_entry2.hasNext()) {
    		Map.Entry<String, Integer> e = it_entry2.next();
    		if(e.getValue() > maxScore) {
    			maxScore = e.getValue();
    			name = e.getKey();
    		}
    		totalScore += e.getValue();
    	}
    	System.out.println("평균점수 : " + totalScore / hashmap.size());
    	System.out.println("최고점수 : " + maxScore);
    	System.out.println("최고점수를 받은 아이디 : " + name);
    	
    	// 3
    	maxScore = 0;
    	totalScore = 0;
    	Iterator<String> key = hashmap.keySet().iterator();
    	while(key.hasNext()) {
    		String i =  key.next();
    		if(hashmap.get(i) > maxScore) {
    			maxScore = hashmap.get(i);
    			name = i;
    		}
    		totalScore += hashmap.get(i);
    	}
    	System.out.println("평균점수 : " + totalScore / hashmap.size());
    	System.out.println("최고점수 : " + maxScore);
    	System.out.println("최고점수를 받은 아이디 : " + name);
    	
    	// 4
    	maxScore = 0;
    	totalScore = 0;
    	Set entryset4 = hashmap.entrySet();
		Iterator it_entry4 = entryset4.iterator();
    	while(it_entry4.hasNext()) {
    		Map.Entry e = (Map.Entry) it_entry4.next();
    		if((int) e.getValue() > maxScore) {
    			maxScore = (int) e.getValue();
    			name = (String) e.getKey();
    		}
    		totalScore += (int) e.getValue();
    	}
    	System.out.println("평균점수 : " + totalScore / hashmap.size());
    	System.out.println("최고점수 : " + maxScore);
    	System.out.println("최고점수를 받은 아이디 : " + name);
    	
    	// 5
    	maxScore = 0;
    	totalScore = 0;
    	Set<Map.Entry<String, Integer>> entryset5 = hashmap.entrySet();
    	for(Map.Entry<String, Integer> entry : entryset5) {
    		if(entry.getValue() > maxScore) {
    			maxScore = entry.getValue();
    			name = entry.getKey();
    		}
    		totalScore += entry.getValue();
    	}
    	System.out.println("평균점수 : " + totalScore / hashmap.size());
    	System.out.println("최고점수 : " + maxScore);
    	System.out.println("최고점수를 받은 아이디 : " + name);
    }
}