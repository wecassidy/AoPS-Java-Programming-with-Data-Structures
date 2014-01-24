package week11;
import java.io.File;
import java.util.ArrayList;


public class Recursion {

	public static int factorialFor(int n) {
		if (n == 1) {
			return 1;
		}

		int product = 1;

		for (int i = 2; i <= n; i ++) {
			product *= i;
		}

		return product;
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}

		else {
			return n * factorial(n - 1);
		}
	}
	
	public static int maxFor(int... nums) {
		int max = 0;
		
		for (int num : nums) {
			max = num > max ? num : max; // If num > max, set max to num, otherwise set max to max
		}
		
		return max;
	}
	
	public static int maximum(int[] nums, int start) {
		if (start == nums.length - 1) {
			return nums[start];
		}
		
		int max = maximum(nums, start + 1);
		
		return max > nums[start] ? max : nums[start];
	}
	
	public static void showFiles(File file) {
		if (!file.isDirectory()) {
            System.out.printf("%s\n",file.getName());
		}
		
        else {
        	for (File f : file.listFiles()) {
        		showFiles(f);
        	}
        }
	}
	
	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set) {
		if (set.size() == 0) {
			ArrayList<ArrayList<Integer>> emptySet = new ArrayList<ArrayList<Integer>> (1);
			emptySet.add(new ArrayList<Integer> (0));
			return emptySet;
		}
		
		int x = set.remove(0);
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>> ();
		
		for (ArrayList<Integer> subset : powerSet(set)) {
			answer.add(new ArrayList<Integer>(subset));
            subset.add(x);
            answer.add(subset);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(3/2);

	}

}
