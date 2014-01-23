
public class Week7Problem3 {
	
	public static boolean[] whichZeroRows(int[][] nums) {
		boolean[] outArray = new boolean[nums.length];
		
		for (int i = 0; i < nums.length; i ++) {
			for (int j = 0; j < nums[i].length; j ++) {
				if (nums[i][j] == 0) {
					outArray[i] = true; 
				}
			}
		}
		
		return outArray;
	}

	public static void main(String[] args) {
		int[][] thing = {{1, 2, 3, 4, 5}, {0}, {1, 2, 0, 4}, {5}, {0}};
		
		for (boolean things : whichZeroRows(thing)) {System.out.println(things);}

	}

}
