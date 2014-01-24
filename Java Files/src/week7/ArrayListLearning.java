package week7;
import java.util.ArrayList;


public class ArrayListLearning {

	public static double getAverage (ArrayList <Integer> nums) {
		int sum = 0;

		for (int i = 0; i < nums.size(); i ++) {
			sum += nums.get(i);
		}

		return (double)sum / nums.size();
	}


	public static void printOdds(String s) {
		for (int i = 1; i < s.length(); i += 2) {
			System.out.print(s.charAt(i));
		}
		
		System.out.print("\n");
	}

	public static void main(String[] args) {
		ArrayList <String> stringList = new ArrayList <String> (30);

		stringList.add("Hello");
		
		printOdds(" G R E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E E N");
	}
}
