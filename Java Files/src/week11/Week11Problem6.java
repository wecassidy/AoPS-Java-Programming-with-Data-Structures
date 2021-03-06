package week11;

public class Week11Problem6 {

	public static int[] getPath(int[][] board) {
		return getPath(board, 0, new int[board.length], new int[board.length], 0);
	}

	public static int[] getPath(int[][] board, int column, int[] path, int[] maxPath, int iteration) {
		if (board.length == 1) {
			int[] nextC;

			if (column == 0) {nextC = new int[] {column, column + 1};}
			else if (column == board[0].length - 1) {nextC = new int[] {column - 1, column};}
			else {nextC = new int[] {column - 1, column, column + 1};}

			for (int c : nextC) {
				path[iteration] = board[0][c];
				maxPath = arraySum(path) > arraySum(maxPath) ? path : maxPath;
			}

			return maxPath;
		}
		
		int[][] smallBoard = new int[board.length - 1][board[0].length]; // smallBoard is the board (as passed to the function) minus the top row
		
		for (int i = 1; i < board.length; i ++) {
			smallBoard[i - 1] = board[i].clone();
		}
		
		path[iteration] = board[0][column];

		int[] nextC;

		if (column == 0) {nextC = new int[] {column, column + 1};}
		else if (column == board[0].length - 1) {nextC = new int[] {column - 1, column};}
		else {nextC = new int[] {column - 1, column, column + 1};}
		
		for (int c : nextC) {
			maxPath = getPath(smallBoard, c, path, maxPath, 0);
		}

		return maxPath;
	}

	public static int arraySum(int[] array) {
		int sum = 0;

		for (int n : array) {
			sum += n;
		}

		return sum;
	}
	
	public static void main(String[] args){
		int[][] grid = {
				{2, 5, 17, 12, 3},
				{15, 8, 4, 11, 10},
				{9, 18, 6, 20, 16},
				{14, 13, 12, 1, 07}
		};
		
		int[] path = getPath(grid);

		for (int p : path) {
			System.out.println(p);
		}
	}

}
