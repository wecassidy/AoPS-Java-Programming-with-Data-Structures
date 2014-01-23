
public class MultidimensionalArrays {
	
	public static int add2DArray(int[][] array) {
		int sum = 0;
		
		for (int r = 0; r < array.length; r ++) {
			for (int c = 0; c < array[r].length; c ++) {
				sum += array[r][c];
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		int[][] myArray = new int[5][8];
		
		for (int r = 0; r < myArray.length; r ++) {
			for (int c = 0; c < myArray[r].length; c ++) {
				myArray [r][c] = r + c;
			}
		}
		
		
	}

}
