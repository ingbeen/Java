package chapter_13;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "È«±æµ¿"));
		messageQueue.offer(new Message("sendSMS", "½Å¿ë±Ç"));
		messageQueue.offer(new Message("sendKakaotalk", "È«µÎ±ú"));
		
		while(!messageQueue.isEmpty()){
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail" :
				System.out.println(message.to + "´Ô¿¡°Ô ¸ÞÀÏÀ» º¸³À´Ï´Ù.");
				break;
			case "sendSMS" :
				System.out.println(message.to + "´Ô¿¡°Ô SMSÀ» º¸³À´Ï´Ù.");
				break;
			case "sendKakaotalk" :
				System.out.println(message.to + "´Ô¿¡°Ô Ä«Ä«¿ÀÅåÀ» º¸³À´Ï´Ù.");
				break;
			}
		}
		
	}
}
