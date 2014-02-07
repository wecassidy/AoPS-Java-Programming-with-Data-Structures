package week15;

public class LList implements AOPSList {
	
	private class Node {
		public String data;
		public Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node head;
	
	public LList() {
		this.head = null;
	}

	@Override
	public void addToFront(String x) {
		this.head = new Node(x, this.head);
	}

	@Override
	public void addToBack(String x) {
		if (this.head == null) {
			this.head = new Node(x, null);
			return;
		}
		
		Node end;
		for (end = this.head; end.next != null; end = end.next);
		
		end.next = new Node(x, null);
	}

	@Override
	public void insert(String x, int position) {
		if (position < 0) {
			return;
		}
		
		if (position == 0) {
			this.addToFront(x);
			return;
		}
		
		Node prevNode = this.head;
		for (int i = 1; i < position && prevNode != null; i ++, prevNode = prevNode.next);
		
		if (prevNode != null) {
			prevNode.next = new Node(x, prevNode.next);
		}

	}

	@Override
	public void replace(String x, int position) {
		if (position < 0) {
			return;
		}
		
		Node changeNode = this.head;
		for (int i = 0; i < position && changeNode != null; i ++, changeNode = changeNode.next);

		if (changeNode != null) {
			changeNode.data = x;
		}
	}

	@Override
	public String get(int position) {
		if (position < 0) {
			return "ERROR";
		}
		
		Node outNode = this.head;
		for (int i = 0; i < position && outNode != null; i ++, outNode = outNode.next);
		
		return outNode.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int position) {
		// TODO Auto-generated method stub

	}

	@Override
	public int index(String x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
