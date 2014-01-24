package week9;
import java.io.*;
import java.util.Scanner;


public class Week9Problem8 {
	
	public static int numDifferentRows(String f1Name, String f2Name) throws FileNotFoundException {
		File f1 = new File(f1Name);
		File f2 = new File(f2Name);
		
		Scanner f1Scan = new Scanner(f1);
		Scanner f2Scan = new Scanner(f2);
		
		int numDifferent = 0;
		
		while (f1Scan.hasNext() && f2Scan.hasNext()) {
			if (!f1Scan.nextLine().equals(f2Scan.nextLine())) {
				numDifferent ++;
			}
		}
		
		f1Scan.close();
		f2Scan.close();
		
		return numDifferent;
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(numDifferentRows("hello1.txt", "hello2.txt"));

	}

}
