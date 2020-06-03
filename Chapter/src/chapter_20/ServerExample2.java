package chapter_20;

import java.io.*;
import java.net.*;

public class ServerExample2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			String str = reader.readLine();
			System.out.println(new String(str));
			writer.println("Hello, Client");
			writer.flush();
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
