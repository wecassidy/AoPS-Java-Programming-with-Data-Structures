
public class Week7Problem4 {
	
	public static int[][] genCheckerboard(int rows, int columns) {
		int[][] board = new int[rows][columns];
		
		boolean zero = true;
		
		for (int r = 0; r < rows; r ++) {
			for (int c = 0; c < columns; c ++) {
				if (zero) {
					board[r][c] = 0;
				}
				
				else {
					board[r][c] = 1;
				}
				
				zero = !zero;
			}
			
			if (r % 2 == 0) {
				zero = false;
			}
			
			else {
				zero = true;
			}
		}
		
		return board;
	}
	
	public static void main(String[] args) {
		int[][] board = genCheckerboard(30, 40);
		
		for (int[] r : board) {
			for (int c : r) {
				System.out.print(c);
			}
			
			System.out.println();
		}
	}
	
}
