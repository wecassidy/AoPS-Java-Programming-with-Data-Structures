package week16;

import java.util.Scanner;

public class Postfix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		scan.close();
		
		String[] parts = expression.split(" ");
		
		LStack stack = new LStack();
		
		for (String part : parts) {
			
		}

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