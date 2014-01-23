import java.awt.Color; // Import the Color class
import java.awt.Graphics; // Import the Graphics class

import javax.swing.JFrame; // Import the JFrame class
import javax.swing.JOptionPane; // Import the JOptionPane class
import javax.swing.JPanel; // Import the JPanel class


public class Week4Problem9 extends JPanel { // The week4Problem9 class is descended from the JPanel class
	int numCircles = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of circles:")); // Get the number of circles wanted through an input dialogue
	
	public void paintComponent(Graphics g) {// The method that paints everything 
		super.paintComponent(g); // Clear the screen
		
		int offset = (getWidth() / 2) / numCircles; // offset is the offset of the circles relative to the previous circle
		
		for (int i = 0; i < numCircles; i++) { // Loop numCircles times
			if (i % 2 == 0) {g.setColor(Color.RED);} // If i is even, set the colour to red
			else {g.setColor(Color.YELLOW);} // If i is odd, set the colour to yellow
			
			g.fillOval(offset * i, offset * i, getWidth() - 2 * offset * i, getHeight() - 2 * offset * i); // Draw an oval with width (widthOfScreen) - 2 x offset x i, height (heightOfScreen) - 2 x offset x i, and top left corner at (offset x i, offset x i)
		}
	}

	public static void main(String[] args) {
		Week4Problem9 panel = new Week4Problem9(); // Create a new Week4Problem9 object
		JFrame window = new JFrame("Concentric Circles"); // Create a new window with the caption "Concentric Circles"
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the program to quit when the window is closed
		window.add(panel); // Add the panel to the window
		window.setSize(250, 250); // Set the size of the window to 250 x 250 px
		window.setVisible(true); // Make the window visible

	}

}
