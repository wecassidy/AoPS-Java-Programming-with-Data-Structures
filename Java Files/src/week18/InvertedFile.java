package week18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class InvertedFile {
<<<<<<< .merge_file_7Op9Od
	private HashMap<String, LinkedList<Integer>> words;

	public InvertedFile(String fileName) throws FileNotFoundException {
		this.words = new HashMap<String, LinkedList<Integer>> ();
=======
	private HashMap<String, LinkedList<Integer>> table;

	public InvertedFile(String fileName) throws FileNotFoundException {
		this.table = new HashMap<String, LinkedList<Integer>> ();
>>>>>>> .merge_file_ZZTksu
		
		Scanner s = new Scanner(new File(fileName));
		
		s.useDelimiter("*");
	}
<<<<<<< .merge_file_7Op9Od
=======
	
	public void add(String word, int number) {
		if (this.table.containsKey(word)) {
			this.table.get(word).add(number);
		}
		
		else {
			this.table.put(word, new LinkedList<Integer> ());
			this.table.get(word).add(number);
		}
	}
>>>>>>> .merge_file_ZZTksu
}
