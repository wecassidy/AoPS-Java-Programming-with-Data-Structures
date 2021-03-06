package week9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
 
public class Average {
 
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("input.txt"); // Create a File object from the file input.txt
        Scanner scan = new Scanner(f); // Create a Scanner object which reads from the File object f
        
        int sum = 0; // Sum is the sum of all the numbers in the input file
        int count = 0; // Count is the number of numbers in the input file
        
        for (int i = 0; scan.hasNext(); sum += scan.nextInt()) { // Initialize i to 0; loop while there is another token for the Scanner; add the next integer in the Scanner's feed to the sum every iteration
            count ++; // Increment the count
        }
        
        System.out.println((double) sum / count); // Compute the average of the numbers in the input file and print it
 
        scan.close();
    }
 
}
