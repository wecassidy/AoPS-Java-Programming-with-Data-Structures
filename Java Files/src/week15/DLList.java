package week15;


public class DLList<E> implements AOPSListGeneric<E> {

	private class Node<E> {
		public E data;
		public Node<E> previous;
		public Node<E> next;

		public Node(E data, Node<E> previous, Node<E> next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}

	private Node<E> head;

	public DLList() {
		this.head = null;
	}

	@Override
	public void addToFront(E x) {
		if (this.head == null) {
			this.head = new Node<E> (x, null, null);
		}

		else {
			this.head = new Node<E> (x, null, this.head);
		}

	}

	@Override
	public void addToBack(E x) {
		if (this.head == null) {
			this.head = new Node<E> (x, null, this.head);
		}

		else {
			Node<E> end;

			for (end = this.head; end.next != null; end = end.next);

			end.next = new Node<E> (x, end, null);
		}

	}

	@Override
	public void insert(E x, int position) throws ListIndexOutOfBoundsException {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException("Index less than 0");
		}

		if (position == 0) {
			this.addToFront(x);
			return;
		}

		Node<E> prevNode = this.head;
		for (int i = 1; i < position && prevNode != null; i ++, prevNode = prevNode.next);

		if (prevNode != null) {
			prevNode.next = new Node<E> (x, prevNode, prevNode.next);
		}

		else {
			throw new ListIndexOutOfBoundsException("Index too large");
		}

	}

	@Override
	public void replace(E x, int position) throws ListIndexOutOfBoundsException {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException("Index less than 0");
		}

		if (position == 0) {
			this.addToFront(x);
			return;
		}

		Node<E> changeNode = this.head;
		for (int i = 0; i < position && changeNode != null; i ++, changeNode = changeNode.next);

		if (changeNode != null) {
			changeNode.data = x;
		}

		else {
			throw new ListIndexOutOfBoundsException("Index too large");
		}

	}

	@Override
	public E get(int position) throws ListIndexOutOfBoundsException {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException("Index less than 0");
		}

		Node<E> outNode = this.head;
		for (int i = 0; i < position && outNode != null; i ++, outNode = outNode.next);

		if (outNode != null) {
			return outNode.data;
		}

		else {
			throw new ListIndexOutOfBoundsException("Index too large");
		}

	}

	@Override
	public int size() {
		int size = 0;
		for (Node<E> ptr = this.head; ptr.next != null; ptr = ptr.next, size ++);

		return size;

	}

	@Override
	public boolean isEmpty() {
		return this.head == null;

	}

	@Override
	public boolean contains(E x) {
		for (Node<E> ptr = this.head; ptr.next != null; ptr = ptr.next) {
			if (ptr.data == x) {
				return true;
			}
		}

		return false;

	}

	@Override
	public void remove(int position) throws ListIndexOutOfBoundsException {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException("Index less than 0");
		}

		if (position == 0) {
			this.head = this.head.next;
			this.head.previous = null;
		}

		Node<E> prevNode = this.head;
		for (int i = 1; i < position && prevNode != null; i ++, prevNode = prevNode.next);

		if (prevNode != null) {
			if (prevNode.next.next != null) {
				prevNode.next = prevNode.next.next;
				prevNode.next.previous = prevNode;
			}
			
			else {
				prevNode.next = null;
			}
		}

		else {
			throw new ListIndexOutOfBoundsException("Index too large");
		}

	}

	@Override
	public int index(E x) {
		Node<E> ptr = this.head;
		for (int i = 0; ptr.next != null; i ++, ptr = ptr.next) {
			if (ptr.data.equals(x)) {
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public AOPSListGeneric<E> sample(int s) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListIndexOutOfBoundsException extends IllegalArgumentException {

	public ListIndexOutOfBoundsException() {
		super();
	}

	public ListIndexOutOfBoundsException(String mesg) {
		super(mesg);
	}
}
