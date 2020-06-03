package chapter_16;

public class MP3PlayerFactory extends PlayerFactory {

	@Override
	Player createPlayer() {
		return new MP3Player();
	}
	
	class MP3Player implements Player{
		public void play(String source) {
			System.out.println("�÷��� ���� : " + source);
		}
		public void stop() {
			System.out.println("�÷��� ����");
		}
	}

}
