package week17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class AOPSTree<E extends Comparable<E>> { // E can be any type that implements the Comparable interface

	private class Node {
		public Node left;
		public Node right;
		public E data;


		public Node(E data, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}

		public Node clone() {
			return new Node(this.data, this.left.clone(), this.right.clone());
		}
	}

	private Node root = null;

	public void insert(E value) {
		Node newNode = new Node(value, null, null);

		if (this.root == null) {
			this.root = newNode;
		}

		else {
			Node subroot = this.root;

			boolean done = false;
			while (! done) {
				if (value.compareTo(subroot.data) < 0) {
					if (subroot.left == null) {
						subroot.left = newNode;
						done = true;
					}

					else {
						subroot = subroot.left;
					}
				}

				else {
					if (subroot.right == null) {
						subroot.right = newNode;
						done = true;
					}

					else {
						subroot = subroot.right;
					}
				}
			}
		}
	}

	public void insertRecursive(E value) {
		insertRecursive(value, this.root);
	}

	private void insertRecursive(E value, Node subroot) {
		Node newNode = new Node(value, null, null);

		if (this.root == null) {
			this.root = newNode;
		}

		else {
			if (value.compareTo(subroot.data) < 0) {
				insertRecursive(value, subroot.left);
			}

			else {
				insertRecursive(value, subroot.right);
			}
		}
	}

	public int getHeight() {
		return getHeight(this.root);
	}

	private int getHeight(Node subroot) {
		if (subroot == null) {
			return -1;
		}

		int maxLeft = getHeight(subroot.left);
		int maxRight = getHeight(subroot.right);

		return Math.max(maxLeft, maxRight) + 1;
	}

	public String toString() {
		return this.toString(this.root);
	}

	/* I did not write this code. I found it at http://www2.hawaii.edu/~ztomasze/ta/ics211-1-fa06/a4/BinaryTree.java and
	 * used it to give me a more accurate representation of the trees than the toString() we wrote did.
	 */
	private String toString(Node subroot) {
		if (subroot == null) {
			return "";
		}

		else if (subroot.left == null && subroot.right == null) {
			return "[" + subroot.data + "]";
		}

		else {
			String result = "(";
			result += toString(subroot.left);
			result += " " + subroot.data + " ";
			result += toString(subroot.right);
			result += ")";
			return result;
		}
	}

	public boolean containsRecursive(E value) {
		return containsRecursive(value, this.root);
	}

	private boolean containsRecursive(E value, Node subroot) {
		if (subroot == null) {
			return false;
		}

		else if (value.equals(subroot.data)) {
			return true;
		}

		else if (value.compareTo(subroot.data) < 0) {
			return containsRecursive(value, subroot.left);
		}

		else {
			return containsRecursive(value, subroot.right);
		}
	}

	public boolean contains(E value) {
		Node subroot = this.root;

		while (subroot != null) {
			if (value.equals(subroot.data)) {
				return true;
			}

			else if (value.compareTo(subroot.data) < 0) {
				subroot = subroot.left;
			}

			else {
				subroot = subroot.right;
			}
		}

		return false;
	}
	
	public int addUp() {
		List<Integer> stuff = (List<Integer>) this.treeToList();
		
		int sum = 0;
		
		for (Integer thing : stuff) {
			sum += thing;
		}
		
		return sum;
	}
	
	public int count() {
		return count(this.root);
	}
	
	private int count(Node subroot) {
		if (subroot == null) {
			return -1;
		}
		
		return count(subroot.left) + count(subroot.right) + 1;
	}
	
	/*private int numberLess(int i) {
		Node n = this.root;
		
		while (n.data != i) {
			if (n < i) {
				n = n.left;
			}
			
			else {
				n = n.right;
			}
		}
		
		return getHeight(n);
	}*/
	
	public E getLargest() {		
		if (this.root == null) {
			throw new NoSuchElementException ();
		}
		
		Node n = this.root;
		
		while (n.left != null || n.right != null) {
			if (n.right == null) {
				n = n.left;
			}
			
			else {
				n = n.right;
			}
		}
		
		return n.data;
	}

	/**
	 * Makes the tree as balanced as possible. For example, if the tree looks like:
	 * <pre>
	 * 0
	 *  \
	 *   1
	 *    \
	 *     2
	 *      \
	 *       3
	 *        \
	 *         4
	 *          \
	 *           5
	 *            \
	 *             6
	 * </pre>
	 * 
	 * It will become:
	 * <pre>
	 *      3
	 *     / \
	 *    /   \
	 *   1     5
	 *  / \   / \
	 * 0   2 4   6
	 * </pre>
	 */
	public void rebalance() {
		List<E> list = this.treeToList(); // Get the tree as it currently is and move it to a list

		this.listToTree(list); // Convert the list to a tree. Because of the way treeToList works, the tree will be balanced
	}
	// The rebalance() method consists of a call to treeToList(), which runs in O(N) time, and a call to listToTree(),
	// which runs in O(N^2). O(N^2) is much larger than O(N) for large N, so the running time of the rebalance() method is
	// O(N^2).

	/**
	 * Moves the tree into a list. The tree looks like:
	 * <pre>
	 *      3
	 *     / \
	 *    /   \
	 *   1     5
	 *  / \   / \
	 * 0   2 4   6
	 * </pre>
	 * 
	 * The list will be {@code [3, 1, 0, 2, 5, 4, 6]}
	 * @return The tree as a list
	 */
	public List<E> treeToList() {
		return treeToList(this.root); // This is just a helper method
	}
	// This method is just a helper method, so it's running time is equal to that of the private treeToList() (O(N)).

	/**
	 * The method that constructs the list for the public {@link #treeToList()}. It inserts the elements as a preorder transversal
	 * @param subroot the root of the tree
	 * @return The tree as a list
	 */
	private List<E> treeToList(Node subroot) {
		List<E> outList = new LinkedList<E> (); // Create a list to hold the elements of the tree
		outList.add(subroot.data); // Add the data of root to the output

		if (subroot.left == null && subroot.right == null) { // If this node is a leaf
			return outList; // Return the list
		}

		if (subroot.left != null) { // If there is a left branch:
			outList.addAll(treeToList(subroot.left)); // Add all the elements of the list version of the left subtree to the output
		}

		if (subroot.right != null) { // If there is a right branch:
			outList.addAll(treeToList(subroot.right)); // Add all the elements of the list version of the right subtree to the output
		}

		return outList; // Return the output list

	}
	// This method goes through every element in the tree, so it runs in O(N) time (LinkedList.add() runs in O(1) time
	// because Java's implementation of the linked list structure keeps track of the tail node).

	/**
	 * Creates a tree from a list. If the list is in the form {@code [0, 1, 2, 3, 4, 5, 6]} the tree will look like:
	 * <pre>
	 *      3
	 *     / \
	 *    /   \
	 *   1     5
	 *  / \   / \
	 * 0   2 4   6
	 * </pre>
	 * This method does sort the list to make sure that the result follows the definition of a binary tree, so
	 * {@code [0, 6, 5, 1, 4, 3, 2]} will be evaluated as {@code [0, 1, 2, 3, 4, 5, 6]}.
	 * @param list the data for the tree
	 */
	public void listToTree(List<E> list) {
		Collections.sort(list); // Sort the list so that the tree that is built will follow the rules of how to construct trees
		
		this.root = this.listToTree(list, null); // Start a new tree by passing a null reference to listToTree
	}
	// According to the Java documentation of Collections.sort(), it runs in O(N log (N)). The version of listToTree()
	// which does the recursion runs in O(N^2) which is far larger than O(N log (N)), so the running time of the method is
	// O(N^2).

	/**
	 * The method that constructs the tree in the public {@link #listToTree(List)}
	 * @param list the data for the tree
	 * @param subroot the root of the tree
	 */
	private Node listToTree(List<E> list, Node subroot) {
		if (subroot == null) { // Check if subroot is null so that we can avoid any nasty NullPointerExceptions
			subroot = new Node(null, null, null); // If subroot is null, create an "empty" Node containing only null references
		}

		if (list.size() == 1) { // If the size of the list is 0, there will be only one element in the tree
			subroot.data = list.get(0); // This node is a leaf, so we don't need to worry about the left and right branches
		}

		else if (list.size() != 0) {
			int middle = list.size() / 2; // Both operands are ints, so integer division is performed which is equivalent to floor(list.size() / 2.0)
			subroot.data = list.get(middle); // Assign the data of subroot to the value of the middle element

			subroot.left = listToTree(list.subList(0, middle), subroot.left); // Recursively construct a balanced tree on the left side of subroot with the left half of the list (not including the middle)

			subroot.right = listToTree(list.subList(middle + 1, list.size()), subroot.right); // Recursively construct a balanced tree on the right side of subroot with the right half of the list (not including the middle)
		}
		
		return subroot; // Return the node constructed at this iteration of the recursion
	}
	// The running time of LinkedList.get() is O(N), and this method goes through every element in the list calling get()
	// every time, so the big-Oh running time is O(N^2)

	/*
	 * Pseudocode for rebalance():
	 * Move the tree into an list
	 * Create a new tree from the list
	 * 
	 * Pseudocode for treeToList():
	 * If the tree is has only one node (base case):
	 * -- Return a List containing the data of that node
	 * Otherwise:
	 * Add the root to the array
	 * Recursively add the left half of the tree to the array
	 * Recursively add the right half of the tree to the array
	 * 
	 * Pseudocode for listToTree():
	 * Sort the list in the helper method
	 * If the list only contains one element (base case):
	 * -- Set the data of subroot to the element of the list
	 * Otherwise:
	 * Sort the list
	 * Get the index of the middle of the list
	 * Make a node from the left half of the list
	 * Make a node from the right half of the list
	 * Return a new Node made from the data at the middle of the list and the two previously made nodes
	 */

	public static void main(String[] args) { // Here for testing
		List<Integer> list = new LinkedList<Integer> (); // Create a list

		for (int i = 0; i < 9; i ++) { // Go through the integers from 0 to 10 (inclusive-exclusive)
			list.add(i); // Add the value of the current integer to the list
		}

		Collections.shuffle(list); // Shuffle the list to make it more complicated
		
		System.out.println(list); // Print the list

		AOPSTree<Integer> tree = new AOPSTree<Integer> (); // Create a tree

		for (Integer thing : list) { // Go through each thing in the list
			tree.insert(thing); // Add the thing to the tree
		}

		System.out.println(tree); // Print the tree

		tree.rebalance(); // Balance the tree

		System.out.println(tree); // Reprint the tree

		Collections.sort(list); // Sort the list
		System.out.println(list); // Print the list for comparison (the items in the list should match the nodes of the tree, minus punctuation introduced by the toString methods) as printed
	}

}

class NoSuchElementException extends RuntimeException {
	public NoSuchElementException() {
		super();
	}
	
	public NoSuchElementException(String x) {
		super(x);
	}
}
