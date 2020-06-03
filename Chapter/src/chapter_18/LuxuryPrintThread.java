package chapter_18;

public class LuxuryPrintThread extends Thread {
	SharedArea sharedArea;
	public void run() {
	    if (sharedArea.isReady != true) {
	        synchronized (sharedArea) {
	            try {
	                sharedArea.wait();
	            }            
	            catch (InterruptedException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }
	    System.out.println("*** ¥ð = " + sharedArea.result + " ***");
	}
}
