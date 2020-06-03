package chapter_20;

import java.io.*;
import java.net.*;

public class ServerExample1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			// 요청이 들어올때까지 대기
			socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte[] arr = new byte[100];
			// arr의 배열의 갯수(100) 만큼 한번에 읽는다(원래는 하나씩)
			in.read(arr);
			System.out.println(new String(arr));
			String str = "Hello, Client";
			// String을 Byte타입의 배열로 리턴한다
			out.write(str.getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {

			}
			try {
				serverSocket.close();
			} catch (Exception ignored) {

			}
		}
	}

}
