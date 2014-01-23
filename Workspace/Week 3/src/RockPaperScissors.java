import java.util.Scanner;
import java.util.Random;


public class RockPaperScissors {
	public static String getComputerMove() { // Get the move of the computer
		Random rand = new Random();
		int choice = rand.nextInt(3);
		
		switch(choice) {
			case 0:
				return "Rock";
			case 1:
				return "Paper";
			default:
				return "Scissors";
		}
	}
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String userMove = scan.nextLine();
            String computerMove = getComputerMove();
            //determineWin(userMove, computerMove);
        }
    }
}
