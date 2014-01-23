
public class Connect4Board {
	private int[][] board;

	public Connect4Board() {
		this.board = new int[7][6];

		this.clearBoard();
	}

	public void clearBoard() {
		for (int r = 0; r < this.board.length; r ++) {
			for (int c = 0; c < this.board[r].length; c ++) {
				this.board[r][c] = 0;
			}
		}
	}

	public boolean canDrop(int column) {
		return column >= 0 && column < this.board[0].length && this.board[0][column] == 0;
	}

    public int dropPiece(int column, int player) {
        int row = 0;
        
        while (row + 1 < this.board.length && this.board[row + 1][column] == 0) {
            row ++;
        }
        
        this.board[row][column] = player;
        
        return row;
    }

    public String toString() {
        String outStr = "";
        
        for (int col = 0; col < board[0].length; col ++) {
            outStr += col + " ";
        }
        
        outStr += "\n";
        
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                outStr += board[row][col] + " ";
            }
            
            outStr += "\n";
        }
        
        return outStr;
	}

}
