package week11;
import java.util.ArrayList;


public class Week11Problem3 {

	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set) {
		if (set.size() == 0) {
			ArrayList<ArrayList<Integer>> emptySet = new ArrayList<ArrayList<Integer>> (1);
			emptySet.add(new ArrayList<Integer> (0));
			return emptySet;
		}

		int x = set.remove(0);
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>> ();

		for (ArrayList<Integer> subset : powerSet(set)) {
			answer.add(new ArrayList<Integer>(subset));
			subset.add(x);
			answer.add(subset);
		}

		return answer;
	}

	public static void main(String[] args) {
		ArrayList<Integer> mySet = new ArrayList<Integer>();
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		System.out.println(powerSet(mySet));

	}

}
