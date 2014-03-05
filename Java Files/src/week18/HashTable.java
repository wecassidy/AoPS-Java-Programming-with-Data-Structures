package week18;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
	
    public List<String> makeList() {
        List<String> data = new LinkedList<String> ();
        
        for (int i=0; i < this.table.length; i ++) {
            for (String element : this.table[i]) {
                data.add(element);
            }
        }
        
        return data;
    }

	public HashTable intersection(HashTable h) {
		List<String> l1 = this.makeList();
		List<String> l2 = h.makeList();
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		HashTable out = new HashTable(Math.min(this.table.length, h.table.length));

		for (int i = 0; i < Math.min(l1.size(), l2.size()); i ++) {
			if (l1.get(i).equals(l2.get(i))) {
				out.add(l1.get(i));
			}
		}

		return out;
	}

	public HashTable union(HashTable h) {
		List<String> l1 = this.makeList();
		List<String> l2 = h.makeList();
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		HashTable out = new HashTable(Math.min(this.table.length, h.table.length));

		for (int i = 0; i < Math.min(l1.size(), l2.size()); i ++) {
			if (! l1.get(i).equals(l2.get(i))) {
				out.add(l1.get(i));
				out.add(l2.get(i));
			}
			
			else {
				out.add(l1.get(i));
			}
		}

		return out;
	}
	
	public HashTable difference(HashTable h) {
		List<String> l1 = this.makeList();
		List<String> l2 = h.makeList();
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		HashTable out = new HashTable(Math.min(this.table.length, h.table.length));

		for (int i = 0; i < Math.min(l1.size(), l2.size()); i ++) {
			if (l1.get(i).equals(l2.get(i))) {
				out.add(l1.get(i));
			}
		}

		return out;
	}

}
