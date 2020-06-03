package chapter_20;

import java.io.*;
import java.net.*;

public class ClientrExample1 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// loopback address 내컴퓨터 주소(테스트용)
			socket = new Socket("127.0.0.1", 9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String str = "Hello, Server";
			out.write(str.getBytes());
			byte[] arr = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {

			}
		}
		// cmd
		// C:\Project156\Java_Source\Chapter\bin>java chapter_20/ServerExample1
	}

}
