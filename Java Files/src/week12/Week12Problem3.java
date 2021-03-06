package week12;

public class Week12Problem3 {
	
	public static int numPythagTriples(int N) {
		int numTriples = 0;
		for (int c = 0; c < N; c ++) {
			for (int b = 0; b < c; b ++) {
				for (int a = 0; a < b; a ++) {
					if (a * a + b * b == c * c) {
						numTriples ++;
					}
				}
			}
		}
		
		return numTriples;
	}

}

// This program is O(N!)
