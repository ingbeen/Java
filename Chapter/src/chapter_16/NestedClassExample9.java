package chapter_16;

import java.util.HashMap;

public class NestedClassExample9 {
    public static void main(String args[]) {
        class ContactInfo{
        	String address;
        	String phoneNo;
        	ContactInfo(String address, String phoneNo){
        		this.address = address;
        		this.phoneNo = phoneNo;
        	}
        }
        
        HashMap<String, ContactInfo> hashtable = new HashMap<String, ContactInfo>();
        hashtable.put("이순희", new ContactInfo("서울시 강남구", "02-547-0000"));
        hashtable.put("한지영", new ContactInfo("서울시 강븍구", "02-920-0000"));
        hashtable.put("박철규", new ContactInfo("경기도 고양시", "031-915-0000"));
        ContactInfo obj = hashtable.get("한지영");
        System.out.println("<한지영의 연락처>");
        System.out.println("주소 : " + obj.address);
        System.out.println("전화번호 : " + obj.phoneNo);
    }
}

