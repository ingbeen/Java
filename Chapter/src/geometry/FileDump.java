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
			in = new FileInputStream(args[0]); // ���ϸ��� �о in�� ����
			byte arr[] = new byte[16]; // 16���� ������ ���� �迭 ����
			while (true) {
				int num = in.read(arr); // num���� 
				if(num < 0) {
					break;
				}
				for (int cnt = 0; cnt < num; cnt++) {
					System.out.printf("%02d ", arr[cnt]);
				}
				System.out.println();
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println(args[0] + "������ �������� �ʽ��ϴ�.");
		} catch(IOException ioe) {
			System.out.println(args[0] + "������ ���� �� �����ϴ�.");
		} finally {
			try {
				in.close();
			} catch(Exception e){
			}
		}
	}

}
