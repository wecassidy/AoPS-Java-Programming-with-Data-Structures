package week16;

public class LStack implements AOPSStack {
	
	private class Node {
		public String data;
		public Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node top = null;

	@Override
	public void push(String s) {
		this.top = new Node(s, this.top);
	}

	@Override
	public String pop() {
		if (this.top == null) {
			throw new MyEmptyStackException("Can't pop from empty stack");
		}
		
		String topData = this.top.data;
		this.top = this.top.next;
		
		return topData;
	}

	@Override
	public String peek() {
		if (this.top == null) {
			throw new MyEmptyStackException("Can't peek at empty stack");
		}
		
		return this.top.data;
	}

	@Override
	public boolean isEmpty() {
		return this.top == null;
	}

}

class MyEmptyStackException extends IllegalArgumentException {

	public MyEmptyStackException() {
		super();
	}

	public MyEmptyStackException(String s) {
		super(s);
	}
	
}
