package week12;

import java.util.Arrays;


public class Week12Problem5 {

	public static void mergeSort(int[] array) {
		if (array.length == 1) {
			return;
		}

		int splitIndex = array.length / 2;

		int[] smallArray1 = new int[splitIndex];
		int[] smallArray2 = new int[array.length - splitIndex];

		for (int i = 0; i < splitIndex; i ++) {
			smallArray1[i] = array[i];
		}

		for (int i = splitIndex; i < array.length; i ++) {
			smallArray2[i - splitIndex] = array[i];
		}

		mergeSort(smallArray1); mergeSort(smallArray2);

		for (int i = 0; i < array.length; i ++) {
			if (smallArray1.length > 0 && smallArray2.length > 0) {
				int smallest1 = min(smallArray1);
				int smallest2 = min(smallArray2);

				if (smallest1 < smallest2) {
					array[i] = smallest1;
					smallArray1 = Arrays.copyOfRange(smallArray1, 1, smallArray1.length);
				}

				else {
					array[i] = smallest2;
					smallArray2 = Arrays.copyOfRange(smallArray2, 1, smallArray2.length);
				}
			}
			
			else if (smallArray1.length == 0) {
				array[i] = min(smallArray2);
				smallArray2 = Arrays.copyOfRange(smallArray2, 1, smallArray2.length);				
			}
			
			else if (smallArray2.length == 0) {
				array[i] = min(smallArray1);
				smallArray1 = Arrays.copyOfRange(smallArray1, 1, smallArray1.length);
			}
		}
	}

	public static int min(int... nums) {
		int min = nums[0];

		for (int num : nums) {
			min = num < min ? num : min;
		}

		return min;
	}

	public static void main(String[] args) {
		int[] array = {5, 88, 2, 3, 10, 4, 1, 9, 7, 6};
		mergeSort(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

// The program runs in O(N) time.