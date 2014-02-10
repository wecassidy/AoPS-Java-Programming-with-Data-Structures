package week15;

import java.util.Random;

public class DLList<E> implements AOPSListGeneric<E> {

	private class Node {
		public E data;
		public Node previous;
		public Node next;

		public Node(E data, Node previous, Node next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}

	private Node head;
	private Node current;

	public DLList() {
		this.head = null;
	}

	@Override
	public void addToFront(E x) {
		if (this.head == null) {
			this.head = new Node (x, null, null);
			this.current = this.head;
		}

		else {
			this.head = new Node (x, null, this.head);
		}

	}

	@Override
	public void addToBack(E x) {
		if (this.head == null) {
			this.head = new Node (x, null, this.head);
			this.current = this.head;
		}

		else {
			Node end;

			for (end = this.head; end.next != null; end = end.next);

			end.next = new Node (x, end, null);
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

		Node prevNode = this.head;
		for (int i = 1; i < position && prevNode != null; i ++, prevNode = prevNode.next);

		if (prevNode != null) {
			prevNode.next = new Node (x, prevNode, prevNode.next);
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

		Node changeNode = this.head;
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

		Node outNode = this.head;
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
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next, size ++);

		return size;

	}

	@Override
	public boolean isEmpty() {
		return this.head == null;

	}

	@Override
	public boolean contains(E x) {
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next) {
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
		
		if (position == this.indexOfCurrent()) {
			throw new IllegalArgumentException("Can't remove current node");
		}

		if (position == 0) {
			this.head = this.head.next;
			this.head.previous = null;
		}

		Node prevNode = this.head;
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

	public int indexOfCurrent() {
		int i = 0;
		for (Node ptr = this.head; ptr.data != this.current.data; ptr = ptr.next, i ++);
		
		return i;
	}

	@Override
	public int index(E x) {
		Node ptr = this.head;
		for (int i = 0; ptr.next != null; i ++, ptr = ptr.next) {
			if (ptr.data.equals(x)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public DLList<E> sample(int s) {
		if (s >= this.size() || s < 0) { // Check if the of the sample is outside of the range of the list
			throw new BadSampleSizeException(); // If so, throw a BadSampleSizeException
		}
		
		DLList<E> sampleInputs = this.clone(); // Clone this list so that we can remove values from a list of sample inputs without messing with this list
		DLList<E> output = new DLList<E>(); // Create a list to hold the sample
		
		Random rand = new Random(); // Create a Random object to generate random indices
		
		for (int i = 0; i < s; i ++) { // Repeat the loop s times
			try { // Try the block of code, and if an exception is thrown, deal with it in the catch block
				int index = rand.nextInt(sampleInputs.size()); // Get a random index from 0 to (size of the sample input list - 1), inclusive
				
				output.addToBack(sampleInputs.get(index)); // Add the element in the list of sample inputs at the random index to the back of the output array
				
				sampleInputs.remove(index); // Remove the element at index from sampleInputs so that it can't be selected again
			}
			
			catch (ListIndexOutOfBoundsException e) {} // The catch should never be entered, so we leave it empty
		}
		
		return output; // Return the output list
	}
	
	public DLList<E> clone() {
		DLList<E> newList = new DLList<E>(); // Create a new list that will end up with the same contents as the original list
		
		for (Node ptr = this.head; ptr.next != null; newList.addToBack(ptr.data)); // Loop through every element in this list and add it to the new List		
		
		return newList; // Return the cloned array
	}

	public void forward() {
		if (this.current.next != null) {
			this.current = this.current.next;
		}
		
		else {
			throw new RuntimeException("No next node");
		}
	}

	public void backward() {
		if (this.current.previous != null) {
			this.current = this.current.previous;
		}
		
		else {
			throw new RuntimeException("No previous node");
		}
	}
	
	public E getCurrent() {
		return this.current.data;
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

class BadSampleSizeException extends IllegalArgumentException {
	
	public BadSampleSizeException() {
		super();
	}
	
	public BadSampleSizeException(String mesg) {
		super(mesg);
	}
	
}
