package week7;
import java.util.Scanner;
public class Connect4Game {
	public static void main(String[] args) {
		Connect4Board board = new Connect4Board();

		Scanner scan = new Scanner(System.in);

		int player = 1;

		while (true) {
			System.out.printf("%s", board);

			System.out.printf("Player %d, enter your column number: ", player);
			int column = scan.nextInt();
			
			if (board.canDrop(column)) {
				board.dropPiece(column, player);

				if (player == 1) {
					player = 2;
				}

				else {
					player = 1;
				}
			}
			
			scan.close();
		}
	}
}