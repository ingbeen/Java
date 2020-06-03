package chapter_20;

import java.util.List;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class PerClinetThread extends Thread {
	static List <PrintWriter> List = Collections.synchronizedList(new ArrayList <PrintWriter>());
	Socket socket;
	PrintWriter writer;
	
	PerClinetThread(Socket socket){
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			List.add(writer);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
			
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "´ÔÀÌ µé¾î¿À¼Ì½À´Ï´Ù");
			while(true) {
				String str = reader.readLine();
				if(str == null) {
					break;
				}
				sendAll(name + "> " + str);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			List.remove(writer);
			sendAll("#" + name + "´ÔÀÌ ³ª°¡¼Ì½À´Ï´Ù");
			try {
				socket.close();
			} catch(Exception ignored) {
				
			}
			
		}
	}
	
	private void sendAll(String str) {
		for(PrintWriter writer : List) {
			writer.println(str);
			writer.flush();
		}
	}
	
}
