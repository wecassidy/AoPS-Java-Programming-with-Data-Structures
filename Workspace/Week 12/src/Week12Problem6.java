import java.io.File; // Import the File class for handling files
import java.io.FileNotFoundException; // Import the FileNotFoundException class to help handle exceptions
import java.util.ArrayList; // Import the ArrayList class for 
import java.util.HashMap;
import java.util.Scanner;


public class Week12Problem6 {
	
	public static final HashMap<String, Integer> LETTER_TO_NUMBER = new HashMap<String, Integer> () {	{
		put("a", 0);
		put("b", 1);
		put("c", 2);
		put("d", 3);
		put("e", 4);
		put("f", 5);
		put("g", 6);
		put("h", 7);
		put("i", 8);
		put("j", 9);
		put("k", 10);
		put("l", 11);
		put("m", 12);
		put("n", 13);
		put("o", 14);
		put("p", 15);
		put("q", 16);
		put("r", 17);
		put("s", 18);
		put("t", 19);
		put("u", 20);
		put("v", 21);
		put("w", 22);
		put("x", 23);
		put("y", 24);
		put("z", 25);
	}}; // Create a dictionary that maps the letters a-z to the numbers 0-25. We make the field static so that it doesn't have to be initialised from within a constructor and final so that it is a constant 

	
	public static int[] letterFrequency(String word) { // This function is very nearly identical to the letterFrequency function from Week 9 Problem 9. I altered it so that it finds the frequency of a single word, instead of an entire file.
		final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; // Create a constant String instance to represent the alphabet
		
		int[] frequencyList = new int[26]; // The indices of the entries in the list of frequencies correspond to the letters as in the NUMBER_TO_LETTER dictionary

		for (int i = 0; i < 26; i ++) { // Loop 26 times
			frequencyList[i] = 0; // Initialize the frequency of the letter to 0
		}

		for (int j = 0; j < word.length(); j ++) { // Loop through the word
				String currentChar = word.substring(j, j + 1).toLowerCase(); // Get the current character and convert it to lowercase

				if (ALPHABET.indexOf(currentChar) != -1) { // If the current character is in the alphabet:
					frequencyList[LETTER_TO_NUMBER.get(currentChar)] ++; // Increment the frequency of the current character
				}
			}

		return frequencyList; // Return the list of frequencies
	}

	public static void main(String[] args) throws FileNotFoundException { // Tell Java that the program might throw a FileNotFoundException
		File f = new File("wordlist.txt"); // Create a file object from the wordlist.txt file
		Scanner wordlist = new Scanner(f); // Create a Scanner to read through the file
		
		Scanner s = new Scanner(System.in); // Create a Scanner to get user input through the console
		
		System.out.println("Please enter the large word:"); // Prompt the user to enter the large word
		String bigWord = s.next(); // The big word is the next token entered by the user
		
		ArrayList<String> littleWords = new ArrayList<String> (); // Create an ArrayList to fill with the words that fit inside the big word
		
		int[] bigWordFrequency = letterFrequency(bigWord); // Get the frequency of all the letters in the big word
		
		boolean wordPossible = true; // This variable stores whether or not a given word in the wordlist can be created from the letters in the big word
		for (String word = ""; wordlist.hasNext(); word = wordlist.nextLine()) { // Initialize the String word to an empty string, loop while the wordlist Scanner has input, set word to the next line of the wordlist Scanner's input feed each iteration
			int[] charCounts = letterFrequency(word); // Get the frequency of the letters in the current word
			
			for (int i = 0; i < 26; i ++) { // For each entry in the character frequency counts:
				if (charCounts[i] > bigWordFrequency[i]) { // The little word fits in the big word if and only if the frequency count of every letter in the small word is at most as large as the frequency count for the corresponding word in the big word. This if tests for the converse of that, i. e. it checks if the little word cannot fit in the big word
					wordPossible = false; // The little word does not fit inside the big word, so set wordPossible to false
					break; // Leave the loop because we don't need to check any other letters
				}
			}
			
			if (wordPossible) { // If the little word fits in the big word:
				littleWords.add(word); // Add the word to the list of little words
			}
		}
		
		for (String word : littleWords) { // Loop through each word in the list of little words
			System.out.println(word); // Print out the word
		}
		
		wordlist.close(); // Close the wordlist Scanner
		s.close(); // Close the Scanner for user input
	}

}
