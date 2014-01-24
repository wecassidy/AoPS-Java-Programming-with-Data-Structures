package week9;

public interface Number {
	public Number square();
}

/**
 * Represents a real number in the form <var style="font-family: times;" >a/b</var>
 */
class RealNumber implements Number {
	private int numerator;
	private int denominator;
	
	public RealNumber(int numerator, int denominator) {
		this.numerator = numerator;
		
		if (denominator != 0) {
			this.denominator = denominator;
		}
	}
	
	@Override
	public RealNumber square() {
		return new RealNumber((int) Math.pow(this.numerator, 2), (int) Math.pow(this.denominator, 2)); // (a/b)^2 = (a/b)(a/b) = a^2/b^2
	}
	
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
}

/**
 * Represents a complex number in the form <var style="font-family: times;" >a + bi</var>
 */
class ComplexNumber implements Number {
	private int a; // a is the constant term of the complex number
	private int b; // b is the coefficient of the imaginary term of the complex number
	
	public ComplexNumber(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public ComplexNumber square() {
		return new ComplexNumber((int) Math.pow(this.a, 2) - (int) Math.pow(this.b, 2), 2 * this.a * this.b);
	}
	
	public String toString() {
		return this.a + " + " + this.b + "i";
	}
}