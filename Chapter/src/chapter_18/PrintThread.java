package chapter_18;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	public void run() {
		try {
			synchronized (sharedArea) {
				sharedArea.wait();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sharedArea.result);
	}
}
