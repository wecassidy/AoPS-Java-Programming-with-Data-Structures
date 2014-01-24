package week2;
import java.util.Scanner;
public class WhileExampleSentinel {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int positives = 0; // tallies of types of numbers
        int negatives = 0;
        System.out.print("Enter a number: ");
        int num = scan.nextInt(); // read number
        
        	while (num != 0) // loop as many times as needed
            {
                if (num > 0) { // check its sign; 2 possibilities
                    positives = positives + 1;
                }
                else { // negative number
                    negatives = negatives + 1;
                }
                System.out.print("Enter a number: ");
                num = scan.nextInt(); // read number
            }
        
        // print results
        System.out.printf("Positives: %d\nNegatives: %d\n\n", positives, negatives);
        
        scan.close();
    }
}