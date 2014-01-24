import java.util.Scanner;

public class ForExample {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int positives = 0; // tallies of types of numbers
        int zeroes = 0;
        int negatives = 0;
        
        System.out.print("How many numbers do you want to enter: ");
        int howMany = scan.nextInt();
        
        for (int counter = 0; counter != howMany; counter++) // loop 5 times
        {
            System.out.print("Enter a number: ");
            int num = scan.nextInt(); // read number
            if (num > 0) { // check its sign; 3 possibilities
                positives++;
            }
            else if (num < 0) {
                negatives++;
            }
            else {
                zeroes++;
            }
        }
        // print results
        System.out.printf("Positives: %d\nNegatives: %d\nZeroes: %d\n", positives, negatives, zeroes);
        
        scan.close();
    }
}