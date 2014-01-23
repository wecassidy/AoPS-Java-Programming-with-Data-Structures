import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Week9Problem7 {

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("dataInput.txt");
		Scanner scan = new Scanner(in);
		
		File out = new File("dataOutput.txt");
		PrintWriter pw = new PrintWriter(out);
		
		for (int i = 1; scan.hasNext(); i ++) {
			pw.println(i + " " + scan.nextLine());
		}
		
		scan.close();
		pw.close();

	}

}
