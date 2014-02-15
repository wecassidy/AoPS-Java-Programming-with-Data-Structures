package week15;

// In the following code, when I specify the running time as O(N), I am talking about the worst-case running time where N is the size of the list.

public class DLList<E> implements AOPSListGeneric<E> {

	private class Node {
		public E data;
		public Node previous; // We need a previous attribute to make the list doubly linked (both forwards and backwards) instead of singly linked (forwards only)
		public Node next;

		public Node(E data, Node previous, Node next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
		// The node constructor runs in constant time
	}

	/**
	 * The first node in the list. If there are no nodes in the list, {@code head} is set to {@code null}.
	 */
	private Node head;

	/**
	 * The back of the list. If there are <= 1 nodes in the list, {@code this.head == this.tail}.
	 */
	private Node tail;

	/**
	 * The current node in the list. By default, the current node is set to the head node.
	 */
	private Node current;

	public DLList() {
		this.head = null;
		this.tail = null;
		this.current = null;
	}
	// The constructor just instantiates all the attributes to null, so it runs in constant time.

	/**
	 * Add an element to the front of the list. If there are no elements in the list, the new element becomes the current one.
	 * @param x the new element
	 */
	@Override
	public void addToFront(E x) {
		if (this.head == null) { // If this is the first node:
			this.head = new Node(x, null, null); // Create a new Node for the head without any previous or next nodes
			this.tail = this.head; // If there is only one node in the list, the tail of the list equals the head
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
		if (this.head == null) { // If the list is empty:
			this.head = new Node(x, null, null); // Create a new Node for the head without any previous or next nodes
			this.tail = this.head; // If there is only one node in the list, the tail of the list equals the head
			this.current = this.head; // Set the current node to this.head because it is the only node in the list
		}

		else { // Otherwise:
			this.tail = new Node(x, this.tail, null); // Create a new node with the element passed to the function as the data, the previous tail as the previous node, and no next node
			this.tail.previous.next = this.tail; // Set the next attribute of the node before the tail node to the new tail node
		}

	}
	// The method runs in O(1) time. The only method call it contains is to the Node constructor, which also runs in constant time.

	/**
	 * Inserts an element at a given index in the list.
	 * @param x the new data for the element
	 * @param index the index of the element to be inserted
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 */
	@Override
	public void insert(E x, int index) {
		if (index < 0) { // Check if the index is too small
			throw new ListIndexOutOfBoundsException("Index less than 0"); // If so, throw a ListIndexOutOfBoundsException with an appropriate message
		}
		// We don't need an else clause because the method will exit if the throw is executed

		if (index == 0) { // If the index is 0:
			this.addToFront(x); // We can call the addToFront() method to do the work for us
			return; // Leave the method
		}

		Node prevNode = this.head.next; // Instantiate the object that will be used as a reference to the node before the index to be inserted at to the head node
		for (int i = 1; i < index && prevNode != null; i ++, prevNode = prevNode.next); // Go through the list, checking if we are at the index before index and that we aren't at the end of the list

		if (prevNode != null) { // If we didn't leave the loop because we fell off the end:
			prevNode.next = new Node (x, prevNode, prevNode.next); // Create a new Node between prevNode and prevNode.next
			prevNode.next.next.previous = prevNode.next; // Set the previous node of the node after the new node to the new node
		}

		else {
			throw new ListIndexOutOfBoundsException("Index too large"); // If the index is too large, throw an exception
		}

	}
	/*
	 * The way the method works in a more legible way:
	 * If the original list is A <-> B <-> C <-> D and we are inserting at 3:
	 * First, we check if passed index is less than 0. If this is true, we complain and throw an exception.
	 * If the index is greater than 0 (as is the case with 3), we check if the index is 0 because we have a method that 
	 * does our work for us in that case.
	 * If the index is not 0, we create a Node object that points to 2nd node in the list (the one at index 1). We start at
	 * index 1 instead of 0 because we covered the 0 case in the previous if block.
	 * The next line contains a for loop which repeats until either i >= index (i is a counter variable representing the
	 * index which increments each iteration) or there is no next node, setting
	 * the Node pointer to the next item in the list each iteration. In a picture:
	 * A <-> B <-> C <-> D, i = 1
	 *       ^ Where the node starts out pointing
	 *       
	 * The for loop then checks if i < index (true) and prevNode.next != null (true) which results to true, so we go for
	 * another iteration
	 * A <-> B <-> C <-> D, i = 2
	 *             ^ Where the node is pointing this iteration
	 * 
	 * A final iteration leaves i at 3 which makes i < index false, so we leave the loop with the node pointer referencing
	 * C.
	 * 
	 * The next line contains an if which checks if the loop ended because it got to the end of the list, indicating that the
	 * index passed to the function is too large. If the condition (prevNode != null) is true, the code sets the reference of
	 * to the next node of the node before the one we are inserting to a new node with the given data and the correct next
	 * and previous attributes. In other words, if the data we are inserting is E (at point 3), the list becomes:
	 *             V---------------
	 * A <-> B <-> C <\         D ^
	 *                 \-> E <-/ 
	 * 
	 * The only problem with this is we haven't updated D's previous attribute, so it is still pointing at C. The next line
	 * fixes that, setting the previous attribute of the node after the node after prevNode to the new Node, leaving us with
	 * the following list:
	 * A <-> B <-> C <-> E <-> D
	 * as desired.
	 * 
	 * If the condition of the if on line 102 is false, the index specified by the user is too large and an exception is
	 * thrown.
	 */

	// There is only one loop in the insert method which repeats index - 1 times. For very large inputs, 1 fewer loop is insignificant, so the big-Oh running time is O(N).

	/**
	 * Replaces an element at a given index in the list.
	 * @param x the new data for the element
	 * @param index the index of the element to be replaced
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 */
	@Override
	public void replace(E x, int index) {
		if (index < 0) { // If the index is too small:
			throw new ListIndexOutOfBoundsException("Index less than 0"); // Complain by throwing an exception
		}
		// The rest of the method will not be executed if an exception is thrown, so an else is not needed

		Node changeNode = this.head; // Create an object that will point to the node of the list to be changed
		for (int i = 0; i <= index && changeNode != null; i ++, changeNode = changeNode.next); // Go through the list until we end up at the correct node or reach the end

		if (changeNode != null) { // If the loop exited because the index was reached:
			changeNode.data = x; // Update the data of the node to be changed
		}

		else { // If the for loop exited because the end of the list was reached:
			throw new ListIndexOutOfBoundsException("Index too large"); // Throw an exception to alert the user to that fact
		}

	}
	// This method (in the worst case) loops N times, so the running time is O(N)

	/**
	 * Gets the element at a given index.
	 * @param index the index of the element to be retrieved
	 * @return the element at the specified index in the list
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 */
	@Override
	public E get(int index) {
		if (index < 0) { // If the index is too small:
			throw new ListIndexOutOfBoundsException("Index less than 0"); // Throw an exception to let the user know and exit the method
		}

		Node outNode = this.head; // Create a reference to the list
		for (int i = 0; i <= index && outNode != null; i ++, outNode = outNode.next); // Repeat while the reference node is a) not at the correct index and b) not at the end of the list

		if (outNode != null) { // If the for loop ended by reaching the correct position:
			return outNode.data; // Return the data of the reference node
		}

		else { // Otherwise:
			throw new ListIndexOutOfBoundsException("Index too large"); // The index was too large, so throw an exception
		}

	}
	// This method, like the ones above, has only one for loop, which runs in O(N) (linear) time.

	/**
	 * Gets the size of the list.
	 * @return the number of elements in the list as an integer
	 */
	@Override
	public int size() {
		int size = 0; // Instantiate the size to 0
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next, size ++); // Repeat the loop until we reach the end, incrementing size each iteration

		return size; // Return the size
	}
	// The get() method will always loop until it reaches the end of the list, so it runs in O(N) time.

	/**
	 * Checks if the list is empty.
	 * @return if the list is empty, {@code true}, otherwise {@code false}.
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null; // If this.head is null, the list is empty
	}
	// This method simply performs an equality check, so it runs in O(1) time.

	/**
	 * Checks if a given element is in the list.
	 * @param x the element to check for inclusion
	 * @return {@code true} if the element is in the list, otherwise {@code false}
	 */
	@Override
	public boolean contains(E x) {
		for (Node ptr = this.head; ptr.next != null; ptr = ptr.next) { // Go through each element in the list
			if (ptr.data.equals(x)) { // If the data at the current node is x:
				return true; // Return true because the list contains x
			}
		}

		return false; // If the method got this far, x can't be in the list, so return false

	}
	// In the worst case (x is not in the list) this method goes through the entire list, so it runs in O(N) time.

	/**
	 * Removes an element at a given index.
	 * @param index the index of the element to be removed
	 * @throws ListIndexOutOfBoundsException if the index is less than 0 or greater than the size of the list
	 * @throws IllegalArgumentException if the index is that of the current element, which can't be removed
	 */
	@Override
	public void remove(int index) {
		if (index < 0) { // If the index too small
			throw new ListIndexOutOfBoundsException("Index less than 0"); // Throw a ListIndexOutOfBoundsException that indicates this
		}

		if (index == this.indexOfCurrent()) { // If the index is that of the current node, which can't be removed:
			throw new IllegalArgumentException("Can't remove current element"); // Throw an IllegalArgumentException to inform the user and exit the method
		}

		if (index == 0) { // If the element to be removed is at index 0
			this.head = this.head.next; // Move the head node forward one node
			this.head.previous = null; // Set the previous attribute of the head node to null so that all references to the node which was removed are gone, making it eligible for garbage collection
			return; // Leave the method
		}

		Node prevNode = this.head; // prevNode is the node before the one to be removed
		for (int i = 1; i < index && prevNode != null; i ++, prevNode = prevNode.next); // Move prevNode forward until it is either pointing at the node before the one to be removed or reaches the end of the list

		if (prevNode != null) { // If the for loop was not exited by reaching the end of the list:
			if (prevNode.next == this.tail) { // Check if the node to be removed is the last node because that is a special case
				prevNode.next = prevNode.next.next; // Move the next reference of prevNode to the one after the node to be removed
				prevNode.next.previous = prevNode; // Set the previous attribute of the node after the one to be removed to prevNode, making all references to the node to be removed null (effectively removing it from the list, if not from memory) and making it eligible for garbage collection
			}

			else { // If the node to be removed is the last one:
				prevNode.next = null; // Remove the next attribute of prevNode because it is now at the end of the list
				this.tail = prevNode; // Update the tail attribute so that it contains a reference to the new end of the list
			}
		}

		else { // If the for loop was exited because it reached the end of the list:
			throw new ListIndexOutOfBoundsException("Index too large"); // Throw a ListIndexOutOfBoundsException that informs the user of that fact
		}
	}
	// The remove() method has to step through the list to get to the correct node, so it runs in O(N) time.

	/**
	 * Gets the index of the current element
	 * @return the index of the current element as an int
	 */
	public int indexOfCurrent() {
		int i = 0; // i will store the index of the current node so that it can be returned
		for (Node ptr = this.head; ptr != this.current; ptr = ptr.next, i ++); // Go through the list until we get to the current node

		return i; // Return the index of current
	}
	// indexOfCurrent() contains one for loop which will run at most N times, so its big-Oh running time is O(N).

	/**
	 * Gets the index of the first occurrence of an element of the list.
	 * @param x the element of which to find the index
	 * @return the index of the element or {@code -1} if the element is not in the list
	 */
	@Override
	public int index(E x) {
		Node ptr = this.head; // Start at the beginning of the list
		for (int i = 0; ptr.next != null; i ++, ptr = ptr.next) { // Each iteration until the end of the loop is reached or the body of the for loop causes the method to end:
			if (ptr.data.equals(x)) { // Check if the data of ptr in this iteration is equal to that of x
				return i; // If so, return the current index
			}
		}

		return -1; // If the method got this far x is not in the list, so return -1
	}
	// This method goes through the entire list if x is not in it, so the worst-case running time is O(N).

	/**
	 * Moves the current node forward one element in the list (i. e. if the index of the current node is 3, calling {@code forward()} will make it 4).
	 * @throws RuntimeException if the current node is already at the end of the list, in which case it can't be moved forward
	 */
	public void forward() {
		if (this.current.next != null) { // If the current node is not the last one:
			this.current = this.current.next; // Move it to the next node
		}

		else { // If the current node is at the end of the list, it can't be moved forward
			throw new RuntimeException("No next node"); // So throw an exception
		}
	}
	// This method either moves the current node forward or throws an exception. Either way there is no repetition of variable length, so the method runs in O(1) time.

	/**
	 * Moves the current node forward one element in the list (i. e. if the index of the current node is 3, calling {@code backward()} will make it 2).
	 * @throws RuntimeException if the current node is at the beginning of the list, in which case it can't be moved backward
	 */
	public void backward() {
		if (this.current.previous != null) { // If the current node isn't already at the beginning of the list:
			this.current = this.current.previous; // Move it back one node
		}

		else { // If the current node is at the beginning of the list, it can't be move backward
			throw new RuntimeException("No previous node"); // So throw an exception
		}
	}
	// This method either moves the current node backward or throws an exception. Either way there is no repetition of variable length, so the method runs in O(1) time.
	
	/**
	 * Gets the data of the current node.
	 * @return the data stored in the current node, unless the list is empty in which case the method returns {@code null}
	 */
	public E getCurrent() {
		return this.current.data;
	}
	// This method just accesses the data of this.current, so it runs in O(1) time.

	/**
	 * Resets the current node to the front of the list.
	 */
	public void reset() {
		this.current = this.head;
	}
	// The reset() method only contains an assignment, so it runs in O(1) time.

	@Override
	public String toString() {
		if (this.head == null) { // If there are no elements in the list:
			return "[]"; // Return an empty pair of square brackets
		}

		String answer = "["; // If not, start the answer with an opening square bracket

		Node ptr; // ptr is just a reference to the list used to retrieve data
		for (ptr = this.head; ptr.next != null; ptr = ptr.next) { // Go through each element in the list except for the last one
			answer += ptr.data + ", "; // And add it to the output string along with a comma and a space
		}

		answer += ptr.data + "]"; // Add the final element to the answer and close it with a closing square bracket

		return answer; // Return the answer
	}
	// The method goes through every element in the list, so the running time is O(N).

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true; // If o points to the same position in memory as this list, they must be equal
		}
		
		if  (o instanceof DLList) { // Check if o is a doubly linked list
			DLList<E> other = (DLList<E>) o; // Cast o to a DLList<E> so that we can access the data inside

			Node ptr1 = this.head; // ptr1 keeps track of each element inside this list
			Node ptr2 = other.head; // ptr2 is a reference to the elements of the other list

			for (; ptr1 != null && ptr2 != null; ptr1 = ptr1.next, ptr2 = ptr2.next) {
				if (!(ptr1.data.equals(ptr2.data))) {
					return false;
				}
			} // Go through each element in both lists until one of the elements is not equal to the other or either of the lists end up at the end

			return true; // If the code reaches here the lists must be equal
		}

		return false; // If the code made it here, o can't be a DLList which implies this.equals(o) must be false.
	}
	// The code (if o is equal to this) steps through every element in both lists, so the running time of this method is O(N).

}

