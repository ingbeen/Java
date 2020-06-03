package chapter_13;

import java.util.LinkedList;

public class StackExample {

	public static void main(String[] args) {
		LinkedList<Coin> coinBox = new LinkedList<Coin>();
		
		coinBox.addLast(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " +  coin.getValue() + "원");
		}

	}

}
