package week17;

import java.util.Scanner;

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
	
}
