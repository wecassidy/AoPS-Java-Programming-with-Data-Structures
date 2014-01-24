import java.util.Scanner; // Import the Scanner class


public class Week1Problem9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner object
		int option = 0; // Declare a new integer variable "option" and set it to 0. option stores the option chosen
		int quantity = 0; // Declare a new integer variable "quantity" and set it to 0. quantity stores the number of items to be bought 
		int subtotal = 0; // Declare a new integer variable "subtotal" and set it to 0. subtotal stores the total for one transaction
		int total = 0; // Declare a new integer variable "total" and set it to 0. total stores the total for the entire sale

		System.out.println("Welcome to the AoPS store!"); // Welcome the user
		System.out.println("Please select one of the following options:"); // Tell the user what the options are
		System.out.println("1) Introduction to Algebra textbook - $59"); 
		System.out.println("2) Introduction to Counting and Probability textbook - $42");
		System.out.println("3) Contest Problem Book I - $20");
		System.out.println("4) AoPS Hoodie - $30");
		System.out.println("5) Print total sales and quit");

		while (option != 5) { // While the user isn't finished:
			System.out.println("Enter 1 for Introduction to Algebra textbook, 2 for Introduction to Counting and Probability, 3 for Contest Problem Book I, 4 for AoPS Hoodie, or 5 to quit."); // Prompt the user to enter a number from 1 to 5
			System.out.print("Your choice: "); // Ask the user for their choice

			option = scan.nextInt(); // Get the next integer entered
			switch (option) {
				case 1: // If the user entered 1:
					System.out.print("Enter the number of Introduction to Algebra textbooks you want: "); // Ask the user how many of this item they want
	
					quantity = scan.nextInt(); // Get the next integer entered
	
					if (quantity > 0) { // Check that the user entered a positive number
						subtotal = 59 * quantity; // The subtotal is the price of the item ($59) times the number of items bought (quantity)
						total += subtotal; // Add the subtotal to the total cost
	
						System.out.printf("Subtotal: $%d\n", subtotal); // Tell the user the subtotal
					}
					else {System.out.println("Please enter a positive integer.");} // If the user entered a negative number or zero, ask them to enter a positive number
					
					break; // Leave the switch
	
				case 2: // If the user entered 2:
					System.out.print("Enter the number of Introduction to Counting and Probability textbooks you want: "); // Ask the user how many of this item they want
	
					quantity = scan.nextInt(); // Get the next integer entered
					
					if (quantity > 0) { // Check that the user entered a positive number
						subtotal = 42 * quantity; // The subtotal is the price of the item ($42) times the number of items bought (quantity)
						total += subtotal; // Add the subtotal to the total cost
	
						System.out.printf("Subtotal: $%d\n", subtotal); // Tell the user the subtotal
					}
					else {System.out.println("Please enter a positive integer.");} // If the user entered a negative number or zero, ask them to enter a positive number
					
					break; // Leave the switch
	
				case 3: // If the user entered 3:
					System.out.print("Enter the number of Contest Problem Book I books you want: "); // Ask the user how many of this item they want
	
					quantity = scan.nextInt(); // Get the next integer entered
					
					if (quantity > 0) { // Check that the user entered a positive number
						subtotal = 20 * quantity; // the subtotal is the price of the item ($20) times the number of items bought (quantity)
						total += subtotal; // add the subtotal to the total cost
	
						System.out.printf("Subtotal: $%d\n", subtotal); // tell the user the subtotal
					}
					else {System.out.println("Please enter a positive integer.");} // If the user entered a negative number or zero, ask them to enter a positive number
					
					break; // Leave the switch
	
				case 4: // If the user entered 4:
					System.out.print("Enter the number of AoPS Hoodies you want: "); // Ask the user how many of this item they want
	
					quantity = scan.nextInt(); // Get the next integer entered
					
					if (quantity > 0) { // Check that the user entered a positive number
						subtotal = 30 * quantity; // the subtotal is the price of the item ($30) times the number of items bought (quantity)
						total += subtotal; // add the subtotal to the total cost
	
						System.out.printf("Subtotal: $%d\n", subtotal); // tell the user the subtotal
					}
					else {System.out.println("Please enter a positive integer.");} // If the user entered a negative number or zero, ask them to enter a positive number
					
					break; // Leave the switch
	
				case 5: // If the user entered 5:
					System.out.println("Thank you for using the AoPS store!"); // Thank the user for using the store
					break; // Leave the switch
	
				default: // Otherwise:
					System.out.println("Please enter a number from 1 to 5."); // Ask the user to enter a number from 1 to 5
			}
			
			System.out.println(); // Print a new line for space
		}
		
		System.out.printf("Total: $%d\n", total); // Print the total


	}

}
