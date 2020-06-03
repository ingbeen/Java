package geometry;

import java.io.*;

public class FileDump {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FileDump <filename>");
			return;
		} 
		FileInputStream in = null;
		try {
			in = new FileInputStream(args[0]); // 파일명을 읽어서 in에 저장
			byte arr[] = new byte[16]; // 16개의 공간을 갖는 배열 생성
			while (true) {
				int num = in.read(arr); // num에는 
				if(num < 0) {
					break;
				}
				for (int cnt = 0; cnt < num; cnt++) {
					System.out.printf("%02d ", arr[cnt]);
				}
				System.out.println();
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println(args[0] + "파일이 존재하지 않습니다.");
		} catch(IOException ioe) {
			System.out.println(args[0] + "파일을 읽을 수 없습니다.");
		} finally {
			try {
				in.close();
			} catch(Exception e){
			}
		}
	}

}
