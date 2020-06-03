package chapter_20;

import java.net.*;

public class ClientrExample3 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// loopback address 내컴퓨터 주소(테스트용)
			socket = new Socket("127.0.0.1", 9001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}

}
