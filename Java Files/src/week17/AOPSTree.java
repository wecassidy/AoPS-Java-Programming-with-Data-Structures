package week17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class AOPSTree {

	private class Node {
		public Node left;
		public Node right;
		public String data;


		public Node(String data, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}

		public Node clone() {
			return new Node(this.data, this.left.clone(), this.right.clone());
		}
	}

	private Node root = null;

	public void insert(String value) {
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

	public void insertRecursive(String value) {
		insertRecursive(value, this.root);
	}

	private void insertRecursive(String value, Node subroot) {
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

	public boolean containsRecursive(String value) {
		return containsRecursive(value, this.root);
	}

	private boolean containsRecursive(String value, Node subroot) {
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

	public boolean contains(String value) {
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

	public void rebalance() {
		List<String> list = this.treeToList();

		Collections.sort(list);

		this.listToTree(list);
	}

	/**
	 * Moves the tree into a list. The list is in the form:
	 * <pre>[root, left branch, right branch]</pre>
	 * @return The tree as a list
	 */
	public List<String> treeToList() {
		return treeToList(this.root);
	}

	private List<String> treeToList(Node subroot) {
		List<String> outList = new LinkedList<String> ();
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
	 * Creates a balanced tree 
	 * @param list
	 */
	public void listToTree(List<String> list) {
		this.listToTree(list, this.root);
	}

	/**
	 * Helper method for the public listToTree()
	 * @param list the data for the tree
	 * @param subroot the root of the tree
	 */
	private void listToTree(List<String> list, Node subroot) {
		/*if (list.size() == 0) {
			return;
		}

		if (list.size() == 1) {
			subroot = new Node(list.get(0), null, null);
		}

		else {
			int middle = list.size() / 2;

			if (subroot.left != null) {
				listToTree(list.subList(0, middle), subroot.left);
			}

			if (subroot.right != null) {
				listToTree(list.subList(middle + 1, list.size()), subroot.right);
			}
		}*/
		
		this.root.data = list.get(list.size() / 2);
		
		Node ptr = this.root;
		
		boolean done = false;
		while (! done) {
			while (ptr.data.compareTo(ptr.left.data) < 0 && ptr.left != null) {
				ptr = ptr.left;
			}
			
			if (ptr.data.compareTo(ptr.left.data) < 0 && ptr.left == null) {
				
			}
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
		List<String> list = new LinkedList<String> (); // Create a list

		for (int i = 0; i < 10; i ++) { // Go through the integers from 0 to 50 (inclusive-exclusive)
			list.add(String.valueOf(i)); // Add the String value of the current integer to the list
		}

		Collections.shuffle(list); // Shuffle the list

		System.out.println(list); // Print the shuffled list

		AOPSTree tree = new AOPSTree (); // Create a tree

		for (String thing : list) { // Go through each thing in the list
			tree.insertStupid(thing); // Add the thing to the tree
		}

		System.out.println(tree);

		tree.rebalance();

		System.out.println(tree);

		Collections.sort(list);
		System.out.println(list);

	}

	public void insertStupid(String thing) {
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
