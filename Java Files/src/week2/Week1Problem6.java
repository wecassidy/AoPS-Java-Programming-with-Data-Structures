package week2;
import java.util.Scanner; // Import the Scanner class


public class Week1Problem6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner
		System.out.print("Please enter a year: "); // Prompt the user to enter a year
		int year = scan.nextInt(); // Get the next integer entered
		
		if (year > 0) { // Check if the user entered valid input
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ) { // Check if the year is a leap year (every 4th year is a leap year, except for every 100th year and including every 400th year)
				System.out.printf("%d is a leap year!\n", year); // Tell the user that the entered year is a leap year
			}
			
			else { // If the year is not a leap year:
				System.out.printf("%d is not a leap year.\n", year); // Let the user know
			}
		}
		
		else { // If the user entered invalid input:
			System.out.println("Please enter a positive number."); // Reprimand them :)
		}
		
		scan.close();

	}

}
