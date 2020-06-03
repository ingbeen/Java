package chapter_20;

import java.io.*;
import java.net.*;

public class ClientrExample2 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// loopback address 내컴퓨터 주소(테스트용)
			socket = new Socket("127.0.0.1", 9000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("Hello, Server");
			writer.flush();
			String str = reader.readLine();
			System.out.println(new String(str));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {

			}
		}
	}

}
