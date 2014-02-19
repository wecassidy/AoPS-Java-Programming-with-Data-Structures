package week16;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		
		scan.close();
		
		String[] parts = expression.split(" ");
		
		Stack<Integer> stack = new Stack<Integer> ();
		
		for (String part : parts) {
			try {
				stack.push(Integer.parseInt(part));
			}
			
			catch (NumberFormatException nfe) {
				switch (part) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
					
				case "-":
					int operand2 = stack.pop();
					int operand1 = stack.pop();
					stack.push(operand1 - operand2);
					break;
					
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
					
				case "/":
					operand2 = stack.pop();
					operand1 = stack.pop();
					stack.push(operand1 / operand2);
					break;
					
				default:
					System.out.println("Invalid character(s): " + part);
				}
			}
		}
		
		if (stack.size() != 1) {
			// throw an exception
		}
		
		System.out.println(stack.pop());
	}

}

class NotEnoughOperandsException extends IllegalArgumentException {

	public NotEnoughOperandsException() {
		super();
	}

	public NotEnoughOperandsException(String s) {
		super(s);
	}
	
}

/*
 * Pseudocode
 * Get postfix expression.
 * Split into parts by spaces.
 * for each part:
 * -- try parsing it as a number and pushing it to the stack.
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