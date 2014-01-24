package week9;

public class Triangle extends Shape implements Drawable, Comparable<Triangle> {
	private int s1, s2, s3;
	
    public Triangle(String newName, int s1, int s2, int s3) {
        super(newName);
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

	@Override
	public int perimeter() {
		return this.s1 + this.s2 + this.s3;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing the triangle");
	}
	
	public static void main(String[] args) {
		Drawable d = new Triangle("Isoceles triangle", 3, 3, 4);
        d.draw();
	}

	@Override
	public int compareTo(Triangle o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
