package week17;

public class AOPSTree {
	private class Node {
		public Node left;
		public Node right;
		public String data;
		
		
		public Node(Node left, Node right, String data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	private Node root = null;	
	
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
