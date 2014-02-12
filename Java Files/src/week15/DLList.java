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
		this.current = null;
	}

	/**
	 * Add an element to the front of the list. If there are no elements in the list, the new element becomes the current one.
	 * @param x the new element
	 */
	@Override
	public void addToFront(E x) {
		if (this.head == null) { // If this is the first node:
			this.head = new Node(x, null, null); // Create a new Node for the head without any previous or next nodes
			this.current = this.head; // Set the current node to this.head because it is the only node in the list
		}

		else { // If there are already nodes in the list
			this.head = new Node(x, null, this.head); // Set the head node to a new node with the current head as the next node
		}

	}
	// This method runs in constant time because the Node constructor runs in constant time.

	/**
	 * Add an element to the back of the list. If there are no elements in the list, the new element becomes the current one.
	 * @param x the new element
	 */
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

	/**
	 * Inserts an element at a given position in the list.
	 * @param x the new data for the element
	 * @param position the index of the element to be inserted
	 * @throws ListIndexOutOfBoundsException if the position is less than 0 or greater than the size of the list
	 */
	@Override
	public void insert(E x, int position) {
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

	/**
	 * Replaces an element at a given position in the list.
	 * @param x the new data for the element
	 * @param position the index of the element to be replaced
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 */
	@Override
	public void replace(E x, int position) {
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

	/**
	 * Gets the element at a given position.
	 * @param position the index of the element to be retrieved
	 * @return the element at the specified index in the list
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 */
	@Override
	public E get(int position) {
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

	/**
	 * Gets the size of the list.
	 * @return the number of elements in the list as an integer
	 */
	@Override
	public int size() {
		int size = 0;
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next, size ++);

		return size;

	}
	
	/**
	 * Checks if the list is empty.
	 * @return if the list is empty, {@code true}, otherwise {@code false}.
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null;

	}

	/**
	 * Checks if a given element is in the list.
	 * @param x the element to check for inclusion
	 * @return {@code true} if the element is in the list, otherwise {@code false}
	 */
	@Override
	public boolean contains(E x) {
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next) {
			if (ptr.data == x) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Removes an element at a given position.
	 * @param position the index of the element to be removed
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 * @throws IllegalArgumentException if the index is that of the current element, which can't be removed
	 */
	@Override
	public void remove(int position) {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException("Index less than 0");
		}
		
		if (position == this.indexOfCurrent()) {
			throw new IllegalArgumentException("Can't remove current element");
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

	/**
	 * Gets the index of the current element
	 * @return the index of the current element as an int
	 */
	public int indexOfCurrent() {
		int i = 0;
		for (Node ptr = this.head; ptr.data != this.current.data; ptr = ptr.next, i ++);
		
		return i;
	}

	@Override
	/**
	 * Gets the index of an element of the list
	 * @param x the element to get the index of
	 * @return the index of the element or -1 if the element is not in the list
	 */
	public int index(E x) {
		Node ptr = this.head;
		for (int i = 0; ptr.next != null; i ++, ptr = ptr.next) {
			if (ptr.data.equals(x)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Gets a random sample of the list of size {@code s}. No elements are repeated unless they appear twice in the list.
	 * In other words, the sample is chosen as if the following code were run:
	 <pre>output = this;
for (int i = 0; i < s; i ++) { // Repeat the loop s times
	int index = rand.nextInt(sampleInputs.size());
	output.addToBack(sampleInputs.get(index));
	this.remove(index);
}
return output;</pre>
	 * @param s the size of the list
	 * @return a randomly chosen sample of the list of size s as a {@code DLList<E>}.
	 */
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
	
	/**
	 * Copies the list.
	 * @return a list which is identical to this list, but is in a different location
	 */
	@Override
	public DLList<E> clone() {
		DLList<E> newList = new DLList<E>(); // Create a new list that will end up with the same contents as the original list
		
		for (Node ptr = this.head; ptr.next != null; newList.addToBack(ptr.data)); // Loop through every element in this list and add it to the new List		
		
		return newList; // Return the cloned array
	}

	/**
	 * Moves the current node forward one in the list (i. e. if the index of the current node is 3, calling forward() will make it 4).
	 */
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
	
	public void reset() {
		this.current = this.head;
	}
	
	@Override
	public String toString() {
		String answer = "[";
        
        for (Node ptr = this.head; ptr.next.next != null; ptr = ptr.next) {
        	answer += ptr.data + ", ";
        }
        
        if (this.size() > 0) {
        	answer += this.get(this.size() - 1) + "]";
        }
        
        else {
        	answer += "]";
        }
        
        return answer;
	}
	
	@Override
	public boolean equals(Object o) {
		if  (o instanceof DLList) {
			DLList<E> other = (DLList<E>) o;
			
			Node ptr1 = this.head;
			Node ptr2 = other.head;
			
			for (; ptr1.data == ptr2.data && ptr1.next != null && ptr2.next != null; ptr1 = ptr1.next, ptr2 = ptr2.next);
			
			if (ptr1.next == null && ptr2.next != null) {
				return true;
			}
		}
		
		return false;
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
