package week3;
import java.util.Scanner;

public class CarTrip {
	public static double getDistance(double x0, double y0, double x1, double y1) { // Computes distance between (x0, y0) and (x1, y1)
		double squareX = Math.pow(x0-x1, 2.0);
        double squareY = Math.pow(y0-y1, 2.0);
        double dist = Math.sqrt(squareX+squareY);
        
        return dist;
	}
	
	public static boolean areEqual(double value1, double value2) {
		return Math.abs(value1 - value2) < 0.00001;
	}
	
	public static String getDirection(double x0, double y0, double x1, double y1) {
		if (areEqual(y0, y1) && x1 > x0) { // Going east
			return "E";
		}
		
		else if (areEqual(y0, y1) && x1 < x0) { // Going west
			return "W";
		}
		
		else if (areEqual(x0, x1) && y1 > y0) { // Going north
			return "N";
		}
		
		else if (areEqual(x0, x1) && y1 < y0) { // Going south
			return "S";
		}
		
        else if (x1>x0 && y1>y0) {
            return "NE";
        }
		
        else if (x1<x0 && y1>y0) {
            return "NW";
        }
		
        else if (x1<x0 && y1<y0) {
            return "SW";
        }
		
        else if (x1>x0 && y1<y0) {
            return "SE";
        }
		
        else {
            return "None";
        }
	}
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter x-coordinate of start city: ");
        double startX = scan.nextDouble();
        System.out.print("Enter y-coordinate of start city: ");
        double startY = scan.nextDouble();
        System.out.print("Enter x-coordinate of end city: ");
        double endX = scan.nextDouble();
        System.out.print("Enter y-coordinate of end city: ");
        double endY = scan.nextDouble();
        System.out.print("How fast will you be going? ");
        double speed = scan.nextDouble();
        
        double dist = getDistance(startX, startY, endX, endY);
        double time = dist / speed;        
        System.out.printf("It will take you %f hours to travel\n", time);
        System.out.printf("You are traveling in the approximate direction %s\n", 
                getDirection(startX, startY, endX, endY));
        
        scan.close();
    }
}