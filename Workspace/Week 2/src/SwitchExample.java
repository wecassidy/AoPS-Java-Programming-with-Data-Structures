import java.util.Scanner;
public class SwitchExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What language are we studying: ");
        System.out.println("1. Python");
        System.out.println("2. Java");
        System.out.println("3. C++");
        System.out.println("4. English");
        System.out.print("Please enter 1-4: ");
        int choice = scan.nextInt();
        
        switch (choice)
        {
        	case 2:
            	System.out.println("Correct!");
            //	break;
        	case 1: case 3: case 4:
                System.out.println("Sorry!");
                break;
        	default:
                System.out.println("Huh??");
        }
     
        scan.close();
    }
}