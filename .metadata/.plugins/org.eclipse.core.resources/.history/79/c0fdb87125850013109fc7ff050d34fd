import java.io.File; // Import the File class to handle files
import java.io.FileNotFoundException; // Import the FileNotFoundException class so that we can throw exceptions without generating exceptions (waitwhat)
import java.util.Scanner; // Import the Scanner class to read files
 
 
public class NumLines {
    
    public static int countLines(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f); // Create a Scanner to read the file
        
        int numLines = 0; // Initialise the number of lines to 0
        
        for ( ; scan.hasNext(); numLines ++) { // A counter variable isn't needed for this for loop, so we leave the initialisation empty; loop while there is another token for the Scanner object to read; increment numLines every iteration
            scan.nextLine(); // Move the Scanner to the next line so that the number of lines is correct
        }
        
        scan.close(); // Close the Scanner
        
        return numLines; // Return the number of lines
    }
 
}
