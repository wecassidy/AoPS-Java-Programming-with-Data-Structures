package week2;
import java.util.Scanner; // Import the Scanner class


public class Week1Problem7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner
		System.out.print("Enter the side lenghts of a triangle, seperated by spaces: "); // Prompt the user to enter three numbers
		int a = scan.nextInt(); // Get the first number entered
		int b = scan.nextInt(); // Get the second number entered
		int c = scan.nextInt(); // Get the third number entered

		if (a > 0 && b > 0 && c > 0) { // Check if all the numbers are positive
			if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) { // Check if any ways of ordering the sides satisfies the Pythoagorean Theorem
				System.out.println("These could form a right triangle."); // If so, let the user know that the side lengths could form a right triangle
			}
			
			else { // If a, b, and c don't satisfy the Pythagorean Theorem:
				System.out.println("These could not form a right triangle."); // Let the user know that a, b, and c aren't the side lengths of a right triangle
			}
		}
		
		else { // If any of a, b, and/or c are negative or zero:
			System.out.println("All numbers must be positive."); // Tell the user that the numbers must be positive.
		}

		scan.close();
	}

}
