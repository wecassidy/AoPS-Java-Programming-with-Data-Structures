package week11;
import java.util.ArrayList;


public class Week11Problem5 {
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static ArrayList<Integer> factor(int n) {
		return factor(n, new ArrayList<Integer> ());
	}
	
	public static ArrayList<Integer> factor(int n, ArrayList<Integer> factors) {
		if (isPrime(n)) {
			factors.add(n);
			return factors;
		}
		
		for (int i = 2; i <= n; i ++) {
			while (n % i == 0) {
				factors.addAll(factor(i));
				n /= i;
			}
		}
		
		return factors;
	}

}
