package week1;
import java.util.Scanner; // Import the Scanner class


public class Week1Problem5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner object
		
		System.out.print("Enter 5 integers seperated by spaces: "); // Prompt the user to enter the integers
		int a = scan.nextInt(); // Set the integer a to the first value
		int b = scan.nextInt(); // Set the integer b to the second value
		int c = scan.nextInt(); // Set the integer c to the third value
		int d = scan.nextInt(); // Set the integer d to the fourth value
		int e = scan.nextInt(); // Set the integer e to the fifth value
		
		int positiveCount = 0; // The number of positive numbers will be saved in positiveCount
		int negativeCount = 0; // The number of negative numbers will be saved in negativeCount
		int zeroCount = 0; // The number of zeroes will be saved in zeroCount
		
		if (a > 0) {positiveCount ++;} // If a is positive, increment positiveCount by 1
		if (a < 0) {negativeCount ++;} // If a is negative, increment negativeCount by 1
		if (a == 0) {zeroCount ++;} // If a is zero, increment zeroCount by 1
		
		if (b > 0) {positiveCount ++;} // If b is positive, increment positiveCount by 1
		if (b < 0) {negativeCount ++;} // If b is negative, increment negativeCount by 1
		if (b == 0) {zeroCount ++;} // If b is zero, increment zeroCount by 1
		
		if (c > 0) {positiveCount ++;} // If c is positive, increment positiveCount by 1
		if (c < 0) {negativeCount ++;} // If c is negative, increment negativeCount by 1
		if (c == 0) {zeroCount ++;} // If c is zero, increment zeroCount by 1
		
		if (d > 0) {positiveCount ++;} // If d is positive, increment positiveCount by 1
		if (d < 0) {negativeCount ++;} // If d is negative, increment negativeCount by 1
		if (d == 0) {zeroCount ++;} // If d is zero, increment zeroCount by 1
		
		if (e > 0) {positiveCount ++;} // If e is positive, increment positiveCount by 1
		if (e < 0) {negativeCount ++;} // If e is negative, increment negativeCount by 1
		if (e == 0) {zeroCount ++;} // If e is zero, increment zeroCount by 1
		
		System.out.printf("%d numbers were positive.\n", positiveCount); // Print the number of positive numbers
		System.out.printf("%d numbers were negative.\n", negativeCount); // Print the number of negative numbers
		System.out.printf("%d numbers were zeroes.\n", zeroCount); // Print the number of zeroes
		
		scan.close();

	}

}
