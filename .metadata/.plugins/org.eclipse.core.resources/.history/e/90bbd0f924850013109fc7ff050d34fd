
public class Week12Problem4 {
	public static void selectionSort(int[] array) {		
		for (int firstIndex = 0; firstIndex < array.length; firstIndex ++) {
			int min = array[firstIndex];
			int minPos = firstIndex;
			
			for (int i = firstIndex; i < array.length; i ++) {
				if (array[i] < min) {
					min = array[i];
					minPos = i;
				}
			}
			
			int save = array[firstIndex];
			
			array[firstIndex] = min;
			array[minPos] = save;
		}
	}
}

// The program O(N^2)
