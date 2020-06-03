package chapter_13;

import java.util.LinkedList;
import java.util.Stack;

public class StackExample1 {

	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.addLast(new Integer(12));
		stack.addLast(new Integer(59));
		stack.addLast(new Integer(7));
		while(!stack.isEmpty()) {
			Integer num = stack.removeLast();
			System.out.println(num);
		}
		
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(new Integer(12));
		stack1.push(new Integer(59));
		stack1.push(new Integer(7));
		while(!stack1.isEmpty()) {
			Integer num = stack1.pop();
			System.out.println(num);
		}
	}

}
