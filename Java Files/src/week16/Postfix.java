package week16;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Use a Scanner connected to the "standard" input to get the postfix notation
		
		System.out.println("Please enter an expression written in postfix notation: "); // Prompt the user
		String expression = scan.nextLine(); // Get the next line the user enters, which should be in postfix.

		scan.close(); // Close the Scanner so that no resources are leaked

		String[] parts = expression.split(" "); // Split the expression into parts by spaces

		Stack<Double> stack = new Stack<Double> (); // Create a Stack of real numbers to that will serve as the container for the numbers

		boolean error = false; // If error is true, a error occurred and the loop terminates

		for (String token : parts) { // Loop through every part of the postfix notation
			try { // Try the following code and catch any exceptions that occur and match the type specified in the catch block			
				stack.push(Double.parseDouble(token)); // Try parsing the current token as a double and pushing it to the stack
			}

			catch (NumberFormatException nfe) { // If parsing the token failed (throwing a NumberFormatException), the token isn't a numeric string, which means that it is either an operator or invalid
				switch (token) { // If the code reached here, we know that 
				case "+":
					try { // The following code could throw an EmptyStackException if there aren't enough numbers for the operators
						double operand2 = stack.pop(); // The second operand is on the top of the stack because it was the most recent one to be pushed
						double operand1 = stack.pop(); // The first operand is immediately after the first one
						
						stack.push(operand1 + operand2);
					}

					catch (EmptyStackException ese) { // If there are 0 or 1 numbers on the stack, there aren't enough operands
						System.out.println("Not enough numbers preceeding operator(s)"); // Print a relevant error message
						error = true; // An error occurred, so set error to true
					}
					
					break; // Leave the switch so that the rest of the cases aren't executed, which would mess up the program

				case "-":
					try { // The following code could throw an EmptyStackException if there aren't enough numbers for the operators
						double operand2 = stack.pop(); // The second operand is on the top of the stack because it was the most recent one to be pushed
						double operand1 = stack.pop(); // The first operand is immediately after the first one
						
						stack.push(operand1 - operand2); // Perform the required operation on the two operands and push the result to the stack
					}

					catch (EmptyStackException ese) { // If there are 0 or 1 numbers on the stack, there aren't enough operands
						System.out.println("Not enough numbers preceeding operator(s)"); // Print a relevant error message
						error = true; // An error occurred, so set error to true
						break; // Leave the for loop so that the rest of the code isn't executed
					}
					
					break; // Leave the switch so that the rest of the cases aren't executed, which would mess up the program

				case "*":
					try { // The following code could throw an EmptyStackException if there aren't enough numbers for the operators
						double operand2 = stack.pop(); // The second operand is on the top of the stack because it was the most recent one to be pushed
						double operand1 = stack.pop(); // The first operand is immediately after the first one
					
						stack.push(operand1 * operand2); // Perform the required operation on the two operands and push the result to the stack
					}

					catch (EmptyStackException ese) { // If there are 0 or 1 numbers on the stack, there aren't enough operands
						System.out.println("Not enough numbers preceeding operator(s)"); // Print a relevant error message
						error = true; // An error occurred, so set error to true
						break; // Leave the for loop so that the rest of the code isn't executed
					}
					
					break; // Leave the switch so that the rest of the cases aren't executed, which would mess up the program

				case "/":
					try { // The following code could throw an EmptyStackException if there aren't enough numbers for the operators
						double operand2 = stack.pop(); // The second operand is on the top of the stack because it was the most recent one to be pushed
						double operand1 = stack.pop(); // The first operand is immediately after the first one
						
						stack.push(operand1 / operand2); // Perform the required operation on the two operands and push the result to the stack
					}

					catch (EmptyStackException ese) { // If there are 0 or 1 numbers on the stack, there aren't enough operands
						System.out.println("Not enough numbers preceeding operator(s)"); // Print a relevant error message
						error = true; // An error occurred, so set error to true
					}
					
					if (stack.peek() == Double.POSITIVE_INFINITY || stack.peek() == Double.NEGATIVE_INFINITY) { // If the top item on the stack is +/- infinity for Doubles, a division by 0 occured
						System.out.println("Division by 0"); // Print a relevant error message
						error = true; // Set error to true, as u
					}
					
					break; // Leave the switch so that the rest of the cases aren't executed, which would mess up the program

				default: // If the switch reached here, the current token is invalid (non-numeric and not an operator)
					System.out.println("Invalid character(s): " + token); // Print a relevant error message
					error = true; // Set error to true because an error occurred
				}
				
				if (error) { // If an error occurred:
					break; // Leave the loop because the program should terminate at an error
				}
			}
		}

		if (! error) { // If an error did not occur
			if (stack.size() > 1) { // If the size of the stack is greater than one, there were to many numbers relative to the number of operators
				System.out.println("Too many number preceding operator(s)");
			}
			
			else if (stack.size() == 0) {
				
			}

			else {
				System.out.println(stack.pop());
			}
		}
	}

}

/*
 * Pseudocode
 * Get postfix expression.
 * Split into parts by spaces.
 * for each part:
 * -- try parsing it as a number and pushing it to the stack.
 * -- if the pushing failed:
 * ---- there are too many operands
 * -- if the parsing failed:
 * ---- if the part is a +:
 * ------ push the sum of the top two numbers to the stack.
 * ---- if the part is a -:
 * ------ push the difference of the top two numbers to the stack.
 * ---- if the part is a *:
 * ------ push the product of the top two numbers to the stack.
 * ---- if the part is a /:
 * ------ push the quotient of the top two numbers to the stack.
 * ---- if the part is none of the above:
 * ------ throw an exception and quit.
 */