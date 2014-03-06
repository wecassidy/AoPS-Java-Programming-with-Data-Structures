package week18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class InvertedFile {
	private HashMap<String, LinkedList<Integer>> table;

	public InvertedFile(String fileName) throws FileNotFoundException {
		this.table = new HashMap<String, LinkedList<Integer>> ();
		
		Scanner s = new Scanner(new File(fileName));
		
		s.useDelimiter("*");
	}
	
	public void add(String word, int number) {
		if (this.table.containsKey(word)) {
			this.table.get(word).add(number);
		}
		
		else {
			this.table.put(word, new LinkedList<Integer> ());
			this.table.get(word).add(number);
		}
	}
}
