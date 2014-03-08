package week18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InvertedFile {
	/**
	 * This variable maps words (as {@code String}s) to lists of the numbers of the documents in which they appear (as {@code
	 * List<Integer>}s).
	 */
	private HashMap<String, List<Integer>> words; // this.words maps a word to the list of the numbers of the documents which contain it

	/**
	 * Constructs an inverted file from a given filename. The file should consist of "documents" separated by an asterisk in the form:
	 * <pre>
	 * i really like java
	 * *
	 * although it would be nice if it had list comprehension
	 * *
	 * i think that python is better than java
	 * *
	 * </pre>
	 * The file is split into documents, then each document is assigned a number from 1 to (number of documents), inclusive.
	 * Each document is split into words, and each word is added to a {@code HashMap} which maps them to a {@code List<Integer>} which
	 * contains the number of the document. No document number will be repeated (this scenario will occur if a word occurs more than once
	 * in one document).<br />
	 * Following the rules mentioned above, the file specified earlier would result in the following inverted file:
	 * <pre>
	 * "i"             -&gt; 1, 3
	 * "really"        -&gt; 1
	 * "like"          -&gt; 1
	 * "java"          -&gt; 1, 3
	 * "although"      -&gt; 2
	 * "it"            -&gt; 2
	 * "would"         -&gt; 2
	 * "be"            -&gt; 2
	 * "nice"          -&gt; 2
	 * "if"            -&gt; 2
	 * "had"           -&gt; 2
	 * "list"          -&gt; 2
	 * "comprehension" -&gt; 2
	 * "think"         -&gt; 3
	 * "that"          -&gt; 3
	 * "python"        -&gt; 3
	 * "is"            -&gt; 3
	 * "better"        -&gt; 3
	 * "than"          -&gt; 3
	 * </pre>
	 * @param fileName the name of the file which contains the documents
	 * @throws FileNotFoundException if the file specified by the argument doesn't exist
	 */
	public InvertedFile(String fileName) throws FileNotFoundException {
		this.words = new HashMap<String, List<Integer>> (); // Initialize this.words

		Scanner s = new Scanner(new File(fileName)); // Build a Scanner that reads from fileName

		String file = ""; // This variable will store the contents of the file
		for (; s.hasNext(); file += s.nextLine() + "\n"); // Read the file into a string

		String[] docs = file.split("\n\\*\n"); // Split the file into documents by each asterisk (including the newlines before and after it)

		for (int i = 0; i < docs.length; i ++) { // This loop will go through all of the documents
			for (String word : docs[i].split(" |\n")) { // Go through each word in the current document as split by either a space or a newline
				this.add(word, i + 1); // Add the current word to the inverted file with the document number as i + 1
			}
		}
	}

	/**
	 * Add a word to the inverted file
	 * @param word the word to add
	 * @param number the number of the document in which it appears
	 */
	public void add(String word, int number) {
		if (this.words.containsKey(word)) { // If the word has already been added to the inverted file:
			if (! this.words.get(word).contains(number)) { // If the word hasn't already been added from the current document:
				this.words.get(word).add(number); // Add the number of the document to the list for this word
			}
		}

		else { // If the word isn't yet in the inverted file
			this.words.put(word, new LinkedList<Integer> ()); // Add a new list to the HashMap at the word
			this.words.get(word).add(number); // Add the document number to the list just created
		}
	}

	/**
	 * Gets the document numbers for a word
	 * @param word the word of which to get the document numbers
	 * @return The numbers of the documents which feature the word
	 */
	public List<Integer> get(String word) {
		return this.words.get(word); // Return the document numbers for the given word
	}

}
