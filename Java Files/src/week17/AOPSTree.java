package week17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class AOPSTree<E extends Comparable<E>> {

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

	private String toString(Node subroot) {
		if (subroot == null) {
			return "";
		}

		return toString(subroot.left) + " " + subroot.data + " " + toString(subroot.right);
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

	/**
	 * Makes the tree as balanced as possible. For example, if the tree looks like:
	 * <pre>
	 * 1
	 *  \
	 *   2
	 *    \
	 *     3
	 *      \
	 *       4
	 *        \
	 *         5
	 *          \
	 *           7
	 *            \
	 *             8
	 * </pre>
	 * 
	 * It will become:
	 * <pre>
	 *      4
	 *     / \
	 *    /   \
	 *   2     7
	 *  / \   / \
	 * 1   3 5   8
	 * </pre>
	 */
	public void rebalance() {
		List<E> list = this.treeToList(); // Get the tree as it currently is and move it to a list

		Collections.sort(list); // Use the sort method of Collections to sort the list

		this.listToTree(list); // Convert the now-sorted list to a tree. Because of the way treeToList works, the tree will be balanced
	}

	/**
	 * Moves the tree into a list. The tree looks like:
	 * <pre>
	 *      d
	 *     / \
	 *    /   \
	 *   b     f
	 *  / \   / \
	 * a   c e   g
	 * </pre>
	 * 
	 * The list will be {@code [a, b, c, d, e, f, g]}
	 * @return The tree as a list
	 */
	public List<E> treeToList() {
		return treeToList(this.root);
	}

	/**
	 * Helper method for treeToList
	 * @param subroot the root of the tree
	 * @return The tree as a list
	 */
	private List<E> treeToList(Node subroot) {
		List<E> outList = new LinkedList<E> ();
		outList.add(subroot.data);

		if (subroot.left == null && subroot.right == null) {
			return outList;
		}

		if (subroot.left != null) {
			outList.addAll(treeToList(subroot.left));
		}

		if (subroot.right != null) {
			outList.addAll(treeToList(subroot.right));
		}

		return outList;

	}

	/**
	 * Creates a tree from a list. If the list is in the form {@code [a, b, c, d, e, f, g]} the tree will look like:
	 * <pre>
	 *      d
	 *     / \
	 *    /   \
	 *   b     f
	 *  / \   / \
	 * a   c e   g
	 * </pre>
	 * @param list
	 */
	public void listToTree(List<E> list) {
		this.listToTree(list, this.root);
	}

	/**
	 * Helper method for the public listToTree()
	 * @param list the data for the tree
	 * @param subroot the root of the tree
	 */
	private void listToTree(List<E> list, Node subroot) {
		if (subroot == null) {
			subroot = new Node(null, null, null);
		}

		if (list.size() == 1) {
			subroot.data = list.get(0);
		}

		else {
			int middle = list.size() / 2;
			subroot.data = list.get(middle);

			listToTree(list.subList(0, middle), subroot.left);

			listToTree(list.subList(middle + 1, list.size()), subroot.right);
		}
	}

	/*
	 * Pseudocode for rebalance():
	 * Move the tree into an list
	 * Sort the list
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
	 * If the list only contains one element (base case):
	 * -- Return a tree containing only that element
	 * Otherwise:
	 * Sort the list
	 * Get the index of the middle of the list
	 * Make a node from the left half of the list
	 * Make a node from the right half of the list
	 * Return a new Node made from the data at the middle of the list and the two previously made nodes
	 */

	public static void main(String[] args) { // Here for testing
		List<Integer> list = new LinkedList<Integer> (); // Create a list

		for (int i = 0; i < 9; i ++) { // Go through the integers from 0 to 50 (inclusive-exclusive)
			list.add(i); // Add the E value of the current integer to the list
		}

		Collections.shuffle(list); // Shuffle the list

		System.out.println(list); // Print the shuffled list

		AOPSTree<Integer> tree = new AOPSTree<Integer> (); // Create a tree

		for (Integer thing : list) { // Go through each thing in the list
			tree.insertStupid(thing); // Add the thing to the tree
		}

		System.out.println(tree);

		tree.rebalance();

		System.out.println(tree);

		Collections.sort(list);
		System.out.println(list);

	}

	public void insertStupid(E thing) {
		Node newNode = new Node(thing, null, null);

		if (this.root == null) {
			this.root = newNode;
		}

		else {
			Node subroot = this.root;

			boolean done = false;
			while (! done) {
				if (subroot.left == null) {
					subroot.left = newNode;
					done = true;
				}

				else {
					subroot = subroot.left;
				}

			}
		}
	}
}
