package chapter_16;

public class NestedIFExample11 {
	public static void main(String args[]) {
        MP3PlayerFactory factory = new MP3PlayerFactory();
        PlayerFactory.Player player = factory.createPlayer();
        player.play("¾Æ¸®¶û");
        player.stop();
    }

}

