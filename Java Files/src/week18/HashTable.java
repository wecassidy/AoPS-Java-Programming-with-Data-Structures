package week18;

import java.util.LinkedList;

public class HashTable {
	
	private LinkedList<String> [] table;
	
	public HashTable(int capacity) {
        this.table = new LinkedList[capacity];
        
        for (int i = 0; i < capacity; i ++) {
        	this.table[i] = new LinkedList<String> ();
        }
    }
	
	public void add(String x) {
		int hash = Math.abs(x.hashCode()) % table.length;
		
		if (! table[hash].contains(x)) {
			table[hash].addFirst(x);
		}
	}
	
	public boolean contains(String x) {
		int hash = Math.abs(x.hashCode()) % this.table.length;
		
		return this.table[hash].contains(x);
	}
	
	public boolean remove(String x) {
		int hash = Math.abs(x.hashCode()) % this.table.length;
		
		return this.table[hash].remove(x);
	}
	
}
