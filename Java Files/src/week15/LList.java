package week15;

import java.util.Random;


public class LList<E> implements AOPSListGeneric<E> {
	
	private class Node {
		public E data;
		public Node next;
		
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node head;
	
	public LList() {
		this.head = null;
	}

	@Override
	public void addToFront(E x) {
		this.head = new Node(x, this.head);
	}

	@Override
	public void addToBack(E x) {
		if (this.head == null) {
			this.head = new Node(x, null);
			return;
		}
		
		Node end;
		for (end = this.head; end.next != null; end = end.next);
		
		end.next = new Node(x, null);
	}

	@Override
	public void insert(E x, int position) {
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
	public void replace(E x, int position) {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException();
		}
		
		Node changeNode = this.head;
		for (int i = 0; i < position && changeNode != null; i ++, changeNode = changeNode.next);

		if (changeNode != null) {
			changeNode.data = x;
		}
		
		else {
			throw new ListIndexOutOfBoundsException();
		}
	}

	@Override
	public E get(int position) {
		if (position < 0) {
			throw new ListIndexOutOfBoundsException();
		}
		
		Node outNode = this.head;
		for (int i = 0; i < position && outNode != null; i ++, outNode = outNode.next);
		
		if (outNode == null) {
			throw new ListIndexOutOfBoundsException();
		}
		
		return outNode.data;
	}

	@Override
	public int size() {
		int i = 0;
		
		for (Node ptr = this.head; ptr.next != null; i ++, ptr = ptr.next);
		
		return i;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(E x) {
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next) {
			if (ptr.data.equals(x)) {
				return true;
			}
		}
		
		return false;
	}

	 @Override
	    public void remove(int position) {
	        if (position == 0) {
	            this.head = this.head.next;
	        }
	        
	        else {
	            int count = 0;
	            Node ptr;
	            for (ptr = this.head; ptr != null && count<position-1; ptr = ptr.next)
	                count ++;
	            if (ptr != null && ptr.next != null)
	                ptr.next = ptr.next.next;
	            
	        }

	    }

	@Override
	public int index(E x) {
		int i = 0;
		
		for (Node ptr = this.head; ptr.next != null; i ++, ptr = ptr.next) {
			if (ptr.data.equals(x)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void reverse() {
		for (int i = 0; i < this.size() / 2; i ++) {
			E oldBack = this.get(this.size() - i);
			E oldFront = this.get(i);
			this.replace(oldFront, this.size() - i);
			this.replace(oldBack, i);
		}
	}
	// O(N)
	
	public static void main(String[] args) {
		LList<Integer> thing = new LList<Integer> ();
		
		for (int i = 0; i < 10; i ++) {
			thing.addToBack(i);
		}
		
		System.out.println(thing);
		thing.reverse();
		System.out.println(thing);
	}
	
	public void rotate(int r) {
		for (int i = 0; i < r; i ++) {
			this.addToFront(this.get(this.size() - 1));
			this.remove(this.size() - 1);
		}
	}
	// O(NM)
	
	public AOPSListGeneric<Integer> getIndices(E x) {
		LList<Integer> indices = new LList<Integer> ();
		
		Node ptr = this.head;
		
		for (int i = 0; ptr != null; ptr = ptr.next, i ++) {
			if (ptr.data.equals(x)) {
				indices.addToBack(i);
			}
		}
		
		return indices;
	}
	// O(N)
	
	public LList<E> sample(int s) {
		if (s >= this.size() || s < 0) { // Check if the of the sample is outside of the range of the list
			throw new BadSampleSizeException(); // If so, throw a BadSampleSizeException
		}
		
		LList<E> sampleInputs = this.clone(); // Clone this list so that we can remove values from a list of sample inputs without messing with this list
		LList<E> output = new LList<E>(); // Create a list to hold the sample
		
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
	// Sample runs in O(NM).
	
	public LList<E> clone() {
		LList<E> newList = new LList<E>(); // Create a new list that will end up with the same contents as the original list
		
		for (int i = 0; i < this.size(); i ++) { // Loop through every element in this list
			newList.addToBack((E) this.get(i)); // Add the element at i in this list to the back of the new list
		}
		
		return newList; // Return the cloned array
	}
	
	@Override
    public String toString() {
        if (this.head == null) {
        	return "[]";
        }
        
        String answer = "[";
        
        Node ptr;
        for (ptr = this.head; ptr.next != null; ptr = ptr.next) {
            answer += ptr.data + ", ";
        }
        
        answer += ptr.data + "]";
        
        return answer;
    }
	
}


