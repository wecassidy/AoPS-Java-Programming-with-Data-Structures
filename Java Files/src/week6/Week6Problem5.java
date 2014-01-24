package week6;

public class Week6Problem5 {

	/**
	 * Finds the sum of the numbers at even indices of an array.
	 * @param nums the array of numbers to sum
	 * @return 
	 */
	public static int evenSum(int[] nums) {
		int sum = nums[0]; // Start the sum at the first item of nums because the index 0 is even
		
		for (int i = 2; i < nums.length; i += 2) { // Start the index at 2, increase by 2 every iteration so that is stays even
			sum += nums[i]; // Add the number at the index i to the sum
		}
		
		return sum; // Return the sum
	}
	
	public static void main(String[] args) {
		int[] thing = {1, 2, 3, 4, 5};
		System.out.println(evenSum(thing));

	}

}
