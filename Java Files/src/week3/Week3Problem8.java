package week3;
import java.util.Scanner; // Import the Scanner classs


public class Week3Problem8 {
	public static int gcd(int a, int b) { // gcd returns an int and takes two ints as arguments
		if (Math.min(a, b) == 0) { // If the smaller of (a, b) is 0:
			return Math.max(a, b); // The gcd of a and b is the larger of (a, b), by Euclid's algorithm
		}

		else { // If neither of (a, b) are 0:
			return gcd(Math.min(a, b), Math.max(a, b) % Math.min(a, b)); // The gcd of a and b is gcd(b, a % b) by Euclid's algorithm
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner
		System.out.print("Please enter two integers, seperated by spaces: "); // Prompt the user to enter two numbers
		int a = scan.nextInt(); // Get the first number entered
		int b = scan.nextInt(); // Get the second number entered

		System.out.printf("The gcd of %d and %d is %d", a, b, gcd(a, b)); // Print a, b, and gcd(a, b)

		scan.close();
	}

}
