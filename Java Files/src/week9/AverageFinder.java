package week9;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class BadGradeException extends Exception {
	private boolean positive;

	public BadGradeException() {
		super();
		this.positive = true;
	}

	public BadGradeException(String message, boolean positive) {
		super(message);
		this.positive = true;
	}
}

public class AverageFinder {
	public static float getAverage(ArrayList<Integer> nums) throws BadGradeException {
		float total = 0;
		for (int grade : nums) {
			if (grade > 100) {
				throw new BadGradeException("Bad negative grade: " + grade, true);
			}
			
			else if (grade < 0) {
				throw new BadGradeException("Bad positive grade: " + grade, false);
			}
			
			else {
				total += grade;
			}
		}

		return total/nums.size();
	}

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("grades.txt");
		Scanner scan = new Scanner(f);

		FileOutputStream fos = new FileOutputStream("answer.txt", false);
		PrintWriter pw = new PrintWriter(fos);

		ArrayList<Integer> grades = new ArrayList<Integer> ();

		while (scan.hasNext()) {
			grades.add(scan.nextInt());
		}

		try {
			pw.printf("The average of the grades is: %f\n", getAverage(grades));
		}
		
		catch (BadGradeException bge) {
			System.out.println("There was silly input in the grades file! :O");
		}

		scan.close();
		pw.close();

	}

}
