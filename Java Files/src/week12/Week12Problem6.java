package week12;
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

/*
 * The running time of the program acts as follows:
 * Line 71: Call to letterFrequency() causes the program to loop (length of the big word) = L times. Total running time thus far is O(L).
 * Line 74: The program goes through the entire wordlist, causing the program to loop (length of wordlist) = N times. Total running time
 * thus far is O(L + N).
 *     Line 75, inside the for loop of line 74: Another call to letterFrequency() makes the program loop another (length of little word)
 *     times every iteration of the enclosing loop. Assuming that the all the words in the wordlist are the same length = M, the running
 *     time is now O(L + MN).
 *     Line 77, inside the for loop of line 74: This for loop goes through each entry in the character frequency counts. Because there are
 *     26 letters in the alphabet and only alphabetic characters are considered for the character counts, the running time of this loop is
 *     constant. The running time of the entire program is now O(L + N(M + 26)).
 * Line 89: A final for loop outputs the list of small words. This loop repeats (number of small words) = K times, so the total running time
 * of the program is O(L + N(M + 26) + K).
 * Because the size of the wordlist (thousands of words) is probably far greater than any English word that that wordlist contains (unless
 * it has the full chemical name for titin (see https://en.wikipedia.org/wiki/Titin#Linguistic_significance), which, at close to 190,000
 * characters is actually longer than the wordlist used for this problem (the wordlist.txt file is a little less than 180,000 lines long) :P),
 * so we can ignore the running time of finding the character frequencies of any one word (L and M). We can also throw out the time to go
 * through each of the 26 letters of the alphabet (the for loop starting at line 77) because it is constant and far less than number of
 * iterations needed to go through the wordlist. Finally, we can also ignore K, the number of iterations needed to output the list of
 * smaller words, because it will be significantly less than the length of the wordlist. Having eliminated all those variables, we are left
 * with the big-Oh running time of the program as O(N), where N is the size of the wordlist used.
 */