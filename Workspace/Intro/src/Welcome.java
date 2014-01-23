/*
 * First program
 * Illustrates simple Java class, input, and output
 * By: Scott Weiss
 */
import java.util.Scanner; // bring in Scanner from Java library


public class Welcome { // begin class definition

	public static void main(String[] args) 
	{ // function called when program is run
		Scanner scan = new Scanner(System.in); // set up user input
		System.out.print("What is your name? "); // display prompt to user
		String name = scan.nextLine(); // read in entered name
		System.out.printf("Hi, %s! Welcome to Java!\n", name); // give friendly message
		System.out.print("What is your age? "); // display prompt to user
		int ageNow = scan.nextInt(); // read in entered age
		int ageNext = ageNow + 1; // Calculate the age next year
		System.out.printf("Next year, you will be %d.", ageNext); // print the age next year
		
		
	} // end of main method

} // end of class definition