package chapter_20;

import java.io.*;
import java.net.*;

public class ServerExample1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			// ��û�� ���ö����� ���
			socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte[] arr = new byte[100];
			// arr�� �迭�� ����(100) ��ŭ �ѹ��� �д´�(������ �ϳ���)
			in.read(arr);
			System.out.println(new String(arr));
			String str = "Hello, Client";
			// String�� ByteŸ���� �迭�� �����Ѵ�
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
