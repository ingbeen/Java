package chapter_16;

public class NestedClassExample10 {
    public static void main(String args[]) {
       Player obj = new Player() {
    	 public void play(String source) {
    		 System.out.println("�÷��� ���� : " + source);
    	 }
    	 public void stop() {
    		 System.out.println("�÷��� ����");
    	 }
       };
       obj.play("LetItBe.mp3");
       obj.stop();
    }
}

