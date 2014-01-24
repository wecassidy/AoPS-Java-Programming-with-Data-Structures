package week8;

public class Circle extends Shape {
	private int x; // The x coordinate of the centre
	private int y; // The y coordinate of the centre
	private int radius; // The radius
	
	public Circle(String name, int x, int y, int radius) {
		super(name); // Use the constructor from the superclass to create the name
		
		this.x = x;
		this.y = y;
		
		this.radius = radius;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return "We're sorry, but the coder is to lazy to create a proper ASCII circle."; // It's true :-(	
	}
	
	@Override // Tell Java that you are going to override a method from the superclass
	public int perimeter() {
		return (int) Math.round(2 * Math.PI * this.radius); // Typecast the value of rounding pi * 2r to the nearest integer to an int (Math.round() returns a long)
	}
	
	public static void main(String[] args) {
		Circle c = new Circle("This be da unit circle of testyness", 0, 0, 1);
		System.out.println(c); // Print the rectangle
	}
}
