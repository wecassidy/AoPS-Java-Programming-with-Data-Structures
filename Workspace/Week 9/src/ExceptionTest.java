import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean goAgain = true;
		
		while (goAgain) {
            try {
                System.out.print("Enter numerator: ");
                int numerator = scan.nextInt();
                System.out.print("Enter denominator: ");
                int denominator = scan.nextInt();
                double answer = ((double) numerator)/denominator;
                System.out.printf("%f divided by %d is %d",numerator,denominator,answer);
                
                goAgain = false;
            }
            
            catch (ArithmeticException ae) {
                System.out.println("Why u make my math sense sad? D:");
            }
            
            catch (InputMismatchException ime) {
                System.out.println("Enter an integer, you bad person.");
                scan.nextLine();
            }
        }
		
		scan.close();
	}
}