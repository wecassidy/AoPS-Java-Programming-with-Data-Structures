import java.util.Scanner; // Import the Scanner class


public class Week3Problem7 {
	public static boolean isPrime(int num) { // isPrime returns a boolean and takes an int as an argument; it checks if it's argument is prime
		double numSqrt = Math.sqrt(num); // Get the square root of num. We only have to check values less than or equal to sqrt(x) to see if x is prime
		boolean prime = true; // prime returns whether or not num is prime

		if (num != 1) { // If num isn't 1:
			for (int i = 2; i <= numSqrt; i ++) { // For each number i, starting from 2, less than or equal to sqrt(num):
				if (num % i == 0) { // If num is evenly divisible by i:
					prime = false; // num is not a prime, so we set prime to false
					break; // Leave the loop
				}
			}
		}
		
		else { // If num is 1:
			prime = false; // num isn't a prime, so we set prime to false
		}
		
		return prime; // Return prime
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a new Scanner object
		
		System.out.print("Please enter two numbers, seperated by spaces: "); // Prompt the user to enter two numbers
		int a = scan.nextInt(); // Get the first number entered
		int b = scan.nextInt(); // Get the second number entered
		
		System.out.printf("Primes in between %d and %d, inclusive:\n", Math.min(a, b), Math.max(a, b)); // Let the user know that the program prints the primes from a to 
		
		for (int i = Math.min(a, b); i <= Math.max(a, b); i ++) { // For each of the numbers from (minimum(a, b)) to (maximum(a, b)), inclusive:
			if (isPrime(i)) { // If the number is prime:
				System.out.println(i); // Print it
			}
		}

	}

}
