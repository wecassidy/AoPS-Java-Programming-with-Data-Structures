import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Week12Problem6 {
	
	public static int[] letterFrequency(String s) {
		int[] frequencyList = new int[26];
		
		for (int i = 0; i < 26; i ++) { // Loop 26 times
			frequencyList[i] = 0; // Initialise the frequency of the letter to 0
		}
		
		final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (char c : s.toCharArray()) { // Loop while there is another token for the Scanner
			if (ALPHABET.indexOf(c) != -1) { // If the current character is in the alphabet:
					frequencyList[(((int) c) - 19) % 26] ++; // Increment the frequency of the current character
				}
		}
		for (int i : frequencyList) {
			System.out.print(i + " ");
		}
		return frequencyList; // Return the list of frequencies
	}

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("wordlist.txt");
		Scanner wordlist = new Scanner(f);
		
		Scanner s = new Scanner(System.in);
		String bigWord = s.next();
		ArrayList<String> littleWords = new ArrayList<String> ();
		
		int[] bigWordFrequency = letterFrequency(bigWord);
		
		boolean wordPossible = true;
		for (String word = ""; wordlist.hasNext(); word = wordlist.nextLine()) {
			int[] charCounts = letterFrequency(word);
			
			for (int i = 0; i < 26; i ++) {
				if (charCounts[i] <= bigWordFrequency[i]) {
					wordPossible = true;
				}
				
				else {
					wordPossible = false;
					break;
				}
			}
			
			if (wordPossible) {
				littleWords.add(word);
			}
		}
		
		for (String word : littleWords) {
			System.out.println(word);
		}
		
		wordlist.close();
		s.close();
	}

}
