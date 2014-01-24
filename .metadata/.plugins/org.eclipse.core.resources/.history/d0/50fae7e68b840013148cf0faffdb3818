import java.util.Scanner; // Import the Scanner class


public class Week1Problem6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner
		System.out.print("Enter the coefficients of the polynomial ax^2 + bx + c, seperated by spaces: "); // Prompt the user to enter the coefficients of the polynomial
		int a = scan.nextInt(); // Get the first number entered
		int b = scan.nextInt(); // Get the second number entered
		int c = scan.nextInt(); // Get the third number entered
		
		System.out.print("Your polynomial is: "); // Let the user know that the polynomial is being printed
		
		if (a > 0) {System.out.printf("%dx^2", a);} // If a is positive, then ax^2 will be printed
		if (a < 0) {System.out.printf("%dx^2", a);} // If a is negative, then -ax^2 will be printed. If a is 0, then the term will not be printed
		
		if (b > 0) {System.out.printf("+%dx", b);} // If b is positive, then +bx will be printed
		if (b < 0) {System.out.printf("%dx", b);} // If b is negative, then -bx^2 will be printed. If b is 0, then the term will not be printed
		
		if (c > 0) {System.out.printf("+%d", c);} // If c is positive, then c will be printed
		if (c < 0) {System.out.printf("%d", c);} // If c is negative, then -c will be printed. If c is 0, then the term will not be printed
		System.out.println(); // Move onto a new line
		
		System.out.print("Enter a value of x to evaluate the polynomial: "); // Prompt the user to enter a value of x
		int x = scan.nextInt(); // Get the next number printed
		
		int result = a * x * x + b * x + c; // Evaluate the polynomial
		System.out.printf("The value of the polynomial at %d is %d.\n", x, result); // Tell the user what the value of the polynomial is at x
		
		if (result == 0) {
			System.out.printf("%d is a root of the polynomial.\n", x); // If the value of the polynomial at x is 0, tell the user that x is a root of the polynomial
		}
		
		

	}

}
