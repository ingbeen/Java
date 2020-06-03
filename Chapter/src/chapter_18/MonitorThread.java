package chapter_18;

public class MonitorThread extends Thread {
	Thread thread;
	MonitorThread(Thread thread){
		this.thread = thread;
	}
	
	public void	run() {
		while(true) {
			Thread.State state = thread.getState();
			System.out.println("쓰레드의 상태 : " + state);
			if(state == Thread.State.TERMINATED) {
				break;
			} 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
}
