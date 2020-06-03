
public class TransferThread extends Thread {
    SharedArea sharedArea;
    TransferThread(SharedArea area) {   // »ı¼ºÀÚ
        sharedArea = area;
    }
    public void run() {
		for (int cnt = 0; cnt < 12; cnt ++) {
			sharedArea.transfer(100);

        }
    }
    
}
