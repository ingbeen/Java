import java.util.HashMap;
/*
class Solution {
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
 */
public class TestApp {
    public static void main(String[] args) {
    	HashMap<String, String> vo = new HashMap<String, String>();
    	vo.put("name", "이기자");
    	vo.put("age", "13");
    	
    	Solution ss = new Solution();
    	
    	ss.setName(vo.get("name"));
    	ss.setAge(Integer.parseInt(vo.get("age")));
    	
    	// 출력
    	System.out.println(ss.getName());
    	System.out.println(ss.getAge());
    }
}