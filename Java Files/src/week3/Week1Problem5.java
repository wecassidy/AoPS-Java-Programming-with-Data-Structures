package week3;
import java.util.Scanner; // Import the scanner class


public class Week1Problem5 {
	public static double average(int a, int b, int c, int d) { // The method average returns type double and accepts four integers as arguments
		return (a + b + c + d)/4.0; // Return the average of a, b, c, and d
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner
		System.out.print("Please enter 4 integers, seperated by spaces: "); // Prompt the user to enter four integers
		int a = scan.nextInt(); // Get the first number entered
		int b = scan.nextInt(); // Get the second number entered
		int c = scan.nextInt(); // Get the third number entered
		int d = scan.nextInt(); // Get the fourth number entered
		
		System.out.printf("The average of %d, %d, %d, and %d is %f.", a, b, c, d, average(a, b, c, d)); // Print a, b, c, d, and their average
		
		scan.close();
	}

}
