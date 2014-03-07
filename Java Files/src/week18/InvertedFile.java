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

		String file = "";
		for (; s.hasNext(); file += s.nextLine() + "\n");

		String[] docs = file.split("\n\\*\n"); // Split the file into documents by each asterisk (including the newlines before and after it)

		for (int i = 0; i < docs.length; i ++) {
			for (String word : docs[i].split(" |\n")) { // Go through each word in the current document as split by either a space or a newline
				this.add(word, i + 1);
			}
		}
	}

	public void add(String word, int number) {
		if (this.words.containsKey(word)) {
			if (! this.words.get(word).contains(number)) {
				this.words.get(word).add(number);
			}
		}

		else {
			this.words.put(word, new LinkedList<Integer> ());
			this.words.get(word).add(number);
		}
	}

	public String toString() {
		return this.words.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		InvertedFile f = new InvertedFile("documents.txt");
		System.out.println(f);
	}
}
