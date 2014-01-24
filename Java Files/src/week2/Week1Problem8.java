package week2;
import java.util.Scanner; // Import the Scanner class


public class Week1Problem8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner

		System.out.print("How many rows do you want: "); // Prompt the user to enter the number of rows
		int numRows = scan.nextInt(); // Get the next number entered

		if (numRows > 0) { // Check if the user entered a positive number of rows
			for (int row = 1; row <= numRows; row ++) { // Each iteration, increment the integer row by 1 until row is greater than numRows, starting at 1
				for (int r = 0; r < row; r ++) { // Each iteration, increment the integer r by 1 until r is equal to row, starting at 0
					System.out.print("*"); // Print a *
				}
				System.out.print("\n"); // Begin the next row
			}
		}
		else { // If the user entered a negative number or zero:
			System.out.println("Please enter a positive number."); // Ask the user to enter a positive number
		}
		
		scan.close();

	}

}
