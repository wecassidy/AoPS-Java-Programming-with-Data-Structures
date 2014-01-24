import java.util.Scanner;
public class WhileExample {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int counter = 0; // how many times loop has executed
        int positives = 0; // tallies of types of numbers
        int zeroes = 0;
        int negatives = 0;
        
        System.out.print("How many numbers do you want to enter: ");
        int howMany = scan.nextInt() - 1;
        
        while (counter != howMany) {
        	System.out.print("Please enter a number: ");
        	int num = scan.nextInt();
        	
        	if (num > 0) {positives ++;}
        	else if (num < 0) {negatives ++;}
        	else {zeroes ++;}
        	
        	counter ++;	
        }
        
        System.out.printf("Positives: %d\nNegatives: %d\nZeroes: %d\n", positives, negatives, zeroes);
        
        scan.close();
    }
}