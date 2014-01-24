package week8;

public class Rectangle extends Shape {
	private int x; // The x coordinate of the top left corner
	private int y; // The y coordinate of the top left corner
	private int width; // The width
	private int height; // The height
	
	public Rectangle(String name, int x, int y, int width, int height) {
		super(name); // Use the constructor from the superclass to create the name
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		String outStr = ""; // Initialise the output string to an empty string
		
		for (int i = 0; i < height; i ++) { // Repeat the code in the loop for every column
			for (int j = 0; j < width; j ++) { // Repeat the code in the loop for every row
				outStr += "+"; // Add a "+" to the output string
			}
			
			outStr += "\n"; // Start a new line at the end of every row
		}
		
		return outStr; // Return the output string
		
	}
	
	@Override // Tell Java that you are going to override a method from the superclass
	public int perimeter() {
		return width * 2 + height * 2;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle("Looooooong rectangle", 1, 1, 400, 3); // :P
		System.out.println(r); // Print the rectangle
	}
}
