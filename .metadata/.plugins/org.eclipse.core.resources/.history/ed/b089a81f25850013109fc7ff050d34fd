public class Week1Problem6 {
	public static int numRoots(double a, double b, double c) { // The method numRoots returns an int and takes three doubles as arguments
		double discriminant = Math.pow(b, 2) - 4 * a * c; // The discriminant is b^2 - 4ac
		
		if (discriminant > 0) { // If the discriminant is positive then the polynomial has 2 real roots
			return 2;
		}
		else if (discriminant == 0) { // If the discriminant is zero, the polynomial has 1 real root
			return 1;
		}
		else { // If the discriminant is negative, then there are no real roots
			return 0;
		}
	}
	
    public static void main(String[] args) {
    	double a = 3; // a is the coefficient of the x^2 term
    	double b = 7; // b is the coefficient of the x term
    	double c = -5; // c is the constant term
    	
    	System.out.printf("%fx^2+%fx+%f has %d real roots.", a, b, c, numRoots(a, b, c)); // Print the polynomial and how many roots it has
    }
}
