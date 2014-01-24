package week1;
import java.util.Scanner; // Import the scanner class

public class Week1Problem2 {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in); // Create a new scanner
	    System.out.println("Enter a number"); // Print a prompt to the console
	    int num = scan.nextInt(); // Assign the value the user enters to the integer num
	    System.out.printf("Twice the number is %d.", num * 2); // Print the message to the console

	    scan.close();
	}

}