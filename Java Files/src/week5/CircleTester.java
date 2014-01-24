package week5;

public class CircleTester {

	public static void main(String[] args) {
		Circle smallCircle = new Circle(40, 40, 20.0);
        Circle smallCircle2 = new Circle(40, 40, 20.0);
        if (smallCircle.equals(smallCircle2)) {System.out.println("Match!");}
        else {System.out.println("No match!");}

	}

}
