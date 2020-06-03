package chapter_18;

public class CalcThread extends Thread {
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for (int i = 1; i < 1000000000; i += 2) {
			if(i / 2 % 2 == 0) {
				total += 1.0 / i;
			} else {
				total -= 1.0 / i;
			}
		}
		sharedArea.result = total * 4;
		sharedArea.isReady = true;
		synchronized (sharedArea) {
			sharedArea.notifyAll();
		}
	}
}
