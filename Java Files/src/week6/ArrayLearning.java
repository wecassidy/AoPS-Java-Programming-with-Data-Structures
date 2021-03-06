package week6;
import java.util.Random;


public class ArrayLearning {
	
	public static double getAverage(int [] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		
		return (double) sum / nums.length;
	}
	
	public static int getMax(int... nums) {
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i ++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		
		return max;
	}
	
	public static int [] getLargeNums(int val, int [] nums) {
		int count = 0;
		
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] > val) {
				count ++;
			}
		}
		
		int [] largeNums = new int[count];
		
		int largeIndex = 0;
		for (int index = 0; index < nums.length; index++) {
            if (nums[index] > val) {
                largeNums[largeIndex] = nums[index];
                largeIndex ++;
            }
		}
		
		return largeNums;
		
	}
	


	public static void main(String[] args) {
		int [] grades = new int[10];
		
		Random rand = new Random();
		for (int i = 0; i < grades.length; i ++) {
			grades[i] = rand.nextInt(41) + 60;
		}
		
		for (int i = 0; i < grades.length; i ++) {
			System.out.println(grades[i]);
		}
		
		System.out.printf("The average is: %f\n", getAverage(grades));
		
		System.out.printf("The highest grade is: %d\n", getMax(grades));
		
		int [] larges = getLargeNums(85, grades);
        System.out.print("The grades higher than 85 are: ");
        for (int index=0; index < larges.length; index++)
            System.out.printf("%d ",larges[index]);
        System.out.print("\n");
        
	}

}
