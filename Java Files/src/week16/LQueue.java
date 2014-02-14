package week16;

public class LQueue implements AOPSQueue {
	
	private class Node {
		public String data;
		public Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front = null;
	private Node back = null;

	@Override
	public void enqueue(String s) {
		Node newNode = new Node(s, null);
		
		if (this.front == null) {
			this.front = newNode;
			this.back = newNode;
		}
		
		else {
			this.back.next = newNode;
			this.back = newNode;
		}
	}

	@Override
	public String dequeue() {
		if (this.front == null) {
			throw new EmptyQueueException("Can't dequeue from empty queue");
		}
		
		if (this.front == this.back) {
			String frontData = this.front.data;
			this.front = null;
			this.back = null;
			
			return frontData;
		}
		
		String frontData = this.front.data;
		this.front = this.front.next;
		return frontData;
	}

	@Override
	public String peek() {
		if (this.front == null) {
			throw new EmptyQueueException("Can't peek at empty queue");
		}
		
		return this.front.data;
	}

	@Override
	public boolean isEmpty() {
		return this.front == null;
	}

}

class EmptyQueueException extends IllegalArgumentException{

	public EmptyQueueException() {
		super();
	}

	public EmptyQueueException(String s) {
		super(s);
	}
	
}
