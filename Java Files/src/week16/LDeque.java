package week16;

public class LDeque implements AOPSStack, AOPSQueue {
	
	private class Node {
        public String data;
        public Node next;
        public Node previous;
        
        public Node(String data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }        
    }

	@Override
	public void enqueue(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
