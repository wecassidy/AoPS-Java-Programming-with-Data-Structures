package week14;

import java.util.Scanner;


public class NameManager {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AOPSListGeneric<String> names = new AListGeneric<String>();
        System.out.println("Enter add to add someone to the chat");
        System.out.println("Enter ask to see if someone is in the chat");
        System.out.println("Enter remove to remove someone");
        System.out.println("Enter quit to quit");
        System.out.print("What is your choice? ");
        String choice = scan.nextLine();
        choice = choice.toLowerCase();
        String userName;
        while (!choice.equals("quit"))
        {
            if (choice.equals("add")) {
                System.out.print("Who do you want to add: ");
                userName = scan.nextLine();
                if (names.contains(userName)) {
                    System.out.printf("%s is already there\n", userName);
                }
                
                else {
                	names.addToBack(userName);
                }
            }
            else if (choice.equals("ask"))
            {
                System.out.print("Who do you want to ask about: ");
                userName = scan.nextLine();
                if (names.contains(userName)) {
                    System.out.printf("%s is in the chat\n", userName);
                }
                
                else {
                	System.out.printf("%s is not in the chat\n", userName);
                }
            }
            else if (choice.equals("remove"))
            {
                System.out.print("Who do you want to remove: ");
                userName = scan.nextLine();
                int index = names.index(userName);
                if (index != -1) {
                    names.remove(index);
                }
                
                else {
                    System.out.printf("Sorry, %s is not present\n", userName);
                }
            }
            else // default error case
                System.out.printf("Sorry, %s is not a valid command. Please try again\n", choice);
            System.out.print("Enter next command (add, ask, remove, quit): ");
            choice = scan.nextLine();
        }
        
        scan.close();
    }

}
