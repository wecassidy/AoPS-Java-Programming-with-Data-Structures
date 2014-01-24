import java.util.Random; // Import the Random class
import java.util.Scanner; // Import the Scanner class


public class Week3Problem9 {

	public static void main(String[] args) {
		Random rand = new Random(); // Create a new Random object
		Scanner scan = new Scanner(System.in); // Create a new Scanner object
		
		int correctCount = 0; // correctCount counts the number of correct answers
		
		for (int i = 0; i < 10; i ++) { // Loop 10 times
			int a = rand.nextInt(10); // Get a random number in the range (0, 9), inclusive
			int b = rand.nextInt(10); // Get a random number in the range (0, 9), inclusive
			int answer = a * b; // The correct answer is a * b
			
			System.out.printf("What is %d x %d?\n", a, b); // Prompt the user to enter a * b
			int guess = scan.nextInt(); // Get the next number entered
			
			if (guess == answer) { // If the user answered correctly:
				System.out.println("You got it right!"); // Congratulate him/her
				correctCount ++; // Increment correctCont
			}
			
			else { // If the user answered incorrectly:
				System.out.printf("Sorry, %d x %d is %d.\n", a, b, answer); // Tell the user the correct answer
			}
			
			System.out.println(); // Add a new line for spacing
		}
		
		int percentage = correctCount * 10; // correctCount is a number from 0-10, we want a number from 0-100, so we multiply by 10
		
		System.out.printf("You got %d%% right.", percentage); // Tell the user what percentage he/she go right. %% prints a % sign

		scan.close();
	}

}
