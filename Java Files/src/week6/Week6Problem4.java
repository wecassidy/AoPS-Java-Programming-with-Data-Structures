package week6;

public class Week6Problem4 {

	public static int positiveSum(int[] nums) {
		int sum = 0; // Initialise the sum as 0
		
		for (int num : nums) { // For each element in nums as num:
			if (num > 0) { // If num is positive:
				sum += num; // Add num to the sum
			}
		}
		
		return sum; // Return the sum
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, -6, 0};
		System.out.println(positiveSum(a));

	}

}
