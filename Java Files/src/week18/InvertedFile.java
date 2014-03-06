package week18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class InvertedFile {
	private HashMap<String, LinkedList<Integer>> words;

	public InvertedFile(String fileName) throws FileNotFoundException {
		this.words = new HashMap<String, LinkedList<Integer>> ();
		
		Scanner s = new Scanner(new File(fileName));
		
		s.useDelimiter("*");
	}
}
