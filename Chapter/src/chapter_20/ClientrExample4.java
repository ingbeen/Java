package chapter_20;

import java.net.*;

public class ClientrExample4 {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java ClientExample4 <user-name>");
			return;
		}
		try {
			Socket socket = new Socket("127.0.0.1", 9002);
			Thread thread1 = new SenderThread2(socket, args[0]);
			Thread thread2 = new ReceiverThread2(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}

}
