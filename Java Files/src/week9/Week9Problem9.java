package week9;
import java.io.File; // Import the File class to help handle reading files
import java.io.FileNotFoundException; // Import the FileNotFoundException class for error catching
import java.util.HashMap; // Import the HashMap class to be used to convert from letters to numbers and vice versa
import java.util.Scanner; // Import the Scanner class to read files


public class Week9Problem9 {
	// I use two HashMaps (henceforth known as dictionaries because I'm from a Python background so I think that name makes more sense :P) to convert from indices of lists to characters and vice versa
	public static final HashMap<String, Integer> LETTER_TO_NUMBER = new HashMap<String, Integer> () {{
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
	
	public static HashMap<Integer, String> NUMBER_TO_LETTER = new HashMap<Integer, String> () {{ // The dictionary is final so that it is constant
		put(0, "a");
		put(1, "b");
		put(2, "c");
		put(3, "d");
		put(4, "e");
		put(5, "f");
		put(6, "g");
		put(7, "h");
		put(8, "i");
		put(9, "j");
		put(10, "k");
		put(11, "l");
		put(12, "m");
		put(13, "n");
		put(14, "o");
		put(15, "p");
		put(16, "q");
		put(17, "r");
		put(18, "s");
		put(19, "t");
		put(20, "u");
		put(21, "v");
		put(22, "w");
		put(23, "x");
		put(24, "y");
		put(25, "z");
	}}; // Create a dictionary that maps the numbers 0-25 to the letters a-z We make the field static so that it doesn't have to be initialised from within a constructor and final so that it is a constant

	public static int[] letterFrequency(String fileName) throws FileNotFoundException { // Tell Java that this method could throw a FileNotFoundException (if the program can't find a filename matching the argument)
		File f = new File(fileName); // Create a file object from the file name passed as an argument

		Scanner scan = new Scanner(f); // Create a Scanner object that scans the File object
		
		final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; // Create a constant String instance to represent the alphabet
		
		int[] frequencyList = new int[26]; // The indices of the entries in the list of frequencies correspond to the letters as in the NUMBER_TO_LETTER dictionary

		for (int i = 0; i < 26; i ++) { // Loop 26 times
			frequencyList[i] = 0; // Initialise the frequency of the letter to 0
		}

		while (scan.hasNext()) { // Loop while there is another token for the Scanner
			String nextWord = scan.next(); // Get the next token from the scanner (as far as I can tell, a token is from wherever the Scanner currently is to the next space or newline, whichever comes first)

			for (int j = 0; j < nextWord.length(); j ++) { // Loop through the word
				String currentChar = nextWord.substring(j, j + 1).toLowerCase(); // Get the current character and convert it to lowercase

				if (ALPHABET.indexOf(currentChar) != -1) { // If the current character is in the alphabet:
					frequencyList[LETTER_TO_NUMBER.get(currentChar)] ++; // Increment the frequency of the current character
				}
			}
		}
		
		scan.close(); // Close the scanner

		return frequencyList; // Return the list of frequencies
	}
	
	public static String mostFrequent(String fileName) throws FileNotFoundException { // Tell Java that this method could throw a FileNotFoundException
		int[] frequencyList = letterFrequency(fileName); // Get the frequency of the letters in the file
		
		int max = frequencyList[0]; // Initialise the variable to represent the largest value to the first entry in the list of frequencies
		String maxChar = NUMBER_TO_LETTER.get(0); // I initialise maxChar with a call to NUMBER_TO_LETTER for consistency with other parts of the code
		
		for (int i = 1; i < 26; i ++) { // Loop from the second entry in the list of frequencies (we already covered the first one) to the last
			if (frequencyList[i] > max) { // If the current letter occurred more times in the input file than the previous maximum:
				max = frequencyList[i]; // Set the new maximum to the frequency of the current character
				
				maxChar = NUMBER_TO_LETTER.get(i); // Set the maximum letter to the current character
			}
		}
		
		return maxChar; // Return the character with the highest frequency
	}
	
	public static String leastFrequent(String fileName) throws FileNotFoundException { // Tell Java that this method could throw a FileNotFoundException
		int[] frequencyList = letterFrequency(fileName); // Get the frequency of the letters in the file
		
		int min = frequencyList[0]; // Initialise the variable to represent the smallest value to the first entry in the list of frequencies
		String minChar = NUMBER_TO_LETTER.get(0); // I initialise minChar with a call to NUMBER_TO_LETTER for consistency with other parts of the code
		
		for (int i = 1; i < 26; i ++) { // Loop from the second entry in the list of frequencies (we already covered the first one) to the last
			if (frequencyList[i] < min) { // If the current letter occurred fewer times in the input file than the previous maximum:
				min = frequencyList[i]; // Set the new minimum to the frequency of the current character
				
				minChar = NUMBER_TO_LETTER.get(i); // Set the minimum letter to the current character
			}
		}
		
		return minChar; // Return the character with the lowest frequency
	}

	public static void main(String[] args) throws FileNotFoundException { // I included a main method so that the frequency methods can be tested without having to create another class. It can be deleted without any damage to the functionality of the other methods
		String fileName = "week9problem9input.txt"; // Save the filename as a variable because I'm too lazy to type it all out every time I need it

		for (int i = 0; i < 26; i ++) { // Loop 26 times
			System.out.println(NUMBER_TO_LETTER.get(i) + "=" + letterFrequency(fileName)[i]); // Print the frequency of each letter, along with what letter it is
		}
		
		System.out.println(mostFrequent(fileName)); // Print the most frequent letter
		System.out.println(leastFrequent(fileName)); // Print the least frequent letter

	}

}
