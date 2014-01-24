package week5;
import java.awt.Graphics;


public class Circle {
	private int centerX;
    private int centerY;
    private double radius;
    
    /**
     * Circle constructor  
     * @param newX : the x coordinate of the centre
     * @param newY : the y coordinate of the centre
     * @param newRadius : the radius of the circle
     */
    public Circle(int newX, int newY, double newRadius) {
    	this.centerX = newX;
    	this.centerY = newY;
    	if (newRadius > 0) {this.radius = newRadius;}
    	else {this.radius = 10.0;}
    }
    
    /**
     * Circle constructor
     * @param newX : the x coordinate of the centre
     * @param newY : the y coordinate of the centre
     */
    public Circle(int newX, int newY) {
    	this.centerX = newX;
    	this.centerY = newY;
    	this.radius = 10.0;
    }
    
    /**
     * Circle constructor    
     */
    public Circle() {
    	this.centerX = 100;
    	this.centerY = 100;
    	this.radius = 10.0;
    }
    
    /**
     * Accessor for the radius
     * @return radius
     */
    public double getRadius() {return this.radius;}
    
    /**
     * Accessor for the x coordinate of the centre of the circle
     * @return centerX
     */
    public int getCenterX() {return this.centerX;}
    
    /**
     * Accessor for the y coordinate of the centre of the circle
     * @return centerY
     */
    public int getCenterY() {return this.centerY;}
    
    /**
     * Set the radius of the circle.
     * @param newRadius : the new value for the radius. Must be greater than 0.
     */
    public void setRadius(double newRadius) {
    	if (newRadius > 0) {
    		this.radius = newRadius;
    	}
    }
    
    /**
     * Set the x coordinate of the centre of the circle
     * @param newCenterX : the new x coordinate of the centre of the circle
     */
    public void setCenterX(int newCenterX) {this.centerX = newCenterX;}
    
    /**
     * Set the y coordinate of the centre of the circle
     * @param newCenterY : the new y coordinate of the centre of the circle
     */
    public void setCenterY(int newCenterY) {this.centerY = newCenterY;}
    
    /**
     * Set the centre of the circle
     * @param newCenterX : the new x coordinate of the centre of the circle
     * @param newCenterY : the new y coordinate of the centre of the circle
     */
    public void setCenter(int newCenterX, int newCenterY) {
    	this.centerX = newCenterX;
    	this.centerY = newCenterY;
    }
    
    /**
     * Convert the circle to a string
     */
    public String toString() {
    	return "A Circle with radius " + this.radius + " and center (" + this.centerX + ", " + this.centerY + ")";
    }
    
    /**
     * Check if the circle is equal to another object
     */
    public boolean equals(Object other) {
    	if (!(other instanceof Circle)) {return false;}
    	else
        {
            Circle otherCircle = (Circle) other;
            return ((this.centerX == otherCircle.centerX) &&
                    (this.centerY == otherCircle.centerY) &&
                    (Math.abs(this.radius - otherCircle.radius) < 0.0001));
        }
    }
    
    /**
     * Get the area of the circle
     * @return The area of the circle
     */
    public double getArea() {return Math.PI * Math.pow(this.radius, 2);}
    
    /**
     * Draw the circle
     * @param g : the graphics object to draw the circle onto
     */
    public void draw(Graphics g) {
    	int intRadius = (int) this.radius;
    	g.drawOval(this.centerX - intRadius, this.centerY - intRadius, intRadius * 2, intRadius * 2);
    }
    
    /**
     * Tests if a point is within the circle
     * @param pointX : the x coordinate of the point
     * @param pointY : the y coordinate of the point
     * @return Whether or not the point is in the circle
     */
    public boolean within(int pointX, int pointY) {
    	if (pointX >= this.centerX - this.radius && pointX <= this.centerX + this.radius) {
    		if (pointY >= this.centerY - this.radius && pointY <= this.centerY + this.radius) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * Get the circumference of the circle
     * @return the value of the circumference of the invoking circle object.
     */
    public double getCircumference() {
    	return Math.PI * this.radius * 2; // Circumference = pi(diameter) = pi(2 x radius)
    }

}
