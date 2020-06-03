package chapter_18;

public class SimplePrintThread extends Thread {
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
         System.out.printf("%.2f %n", sharedArea.result);
    }
}
