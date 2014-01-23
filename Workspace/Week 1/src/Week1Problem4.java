import java.util.Scanner; // Import the scanner class

public class Week1Problem4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner object
		System.out.println("Enter a number:"); // Prompt the user to enter a number
		int a = scan.nextInt(); // Get the next number entered into the console
		System.out.println("Enter another number:"); // Prompt the user for a second number
		int b = scan.nextInt(); // Get the next number entered into the console
		
		System.out.println(""); // Print an empty line for space
		System.out.printf("%d + %d = %d\n", a, b, a + b); // Print the sum
		System.out.printf("%d - %d = %d\n", a, b, a - b); // Print the difference
		System.out.printf("%d * %d = %d\n", a, b, a * b); // Print the product
		System.out.printf("%d / %d = %d\n", a, b, a / b); // Print the integer part of the quotient

	}

}
