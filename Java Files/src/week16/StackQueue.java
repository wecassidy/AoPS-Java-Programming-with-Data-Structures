package week16;

import java.util.LinkedList;

public class StackQueue implements AOPSQueue {
	private AOPSStack queue = new LStack();

	@Override
	public void enqueue(String s) {
		AOPSStack newQueue = new LStack();
		
		newQueue.push(s);
		
		LinkedList<String> itemsReversed = new LinkedList<String> ();
		
		while (! this.queue.isEmpty()) {
			itemsReversed.add(this.queue.pop());
		}
		
		for (String item : itemsReversed) {
			newQueue.push(item);
		}
		
		this.queue = newQueue;
		
	}

	@Override
	public String dequeue() {
		return this.queue.pop();
	}

	@Override
	public String peek() {
		return this.queue.peek();
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

}
