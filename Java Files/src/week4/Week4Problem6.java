package week4;
import java.awt.Color; // Import the Color class
import java.awt.Graphics; // Import the Graphics class

import javax.swing.JFrame; // Import the JFrame class
import javax.swing.JPanel; // Import the JPanel class


public class Week4Problem6 extends JPanel { // The Week4Problem6 class is descended from the JPanel class
	
	public void paintComponent(Graphics g) { // The drawing method
		super.paintComponent(g); // Empty the screen
		
		g.setColor(Color.BLUE); // Set the colour to blue
		g.drawOval(0, 0, 100, 100); // Draw the blue circle
		
		g.setColor(Color.YELLOW); // Set the colour to yellow
		g.drawOval(50, 50, 100, 100); // Draw the yellow circle
		
		g.setColor(Color.BLACK); // Set the colour to black
		g.drawOval(100, 0, 100, 100); // Draw the black circle
		
		g.setColor(Color.GREEN); // Set the colour to green
		g.drawOval(150, 50, 100, 100); // Draw the green circle
		
		g.setColor(Color.RED); // Set the colour to red
		g.drawOval(200, 0, 100, 100); // Draw the red circle
	}

	public static void main(String[] args) {
		Week4Problem6 panel = new Week4Problem6(); // Create a new Week4Problem6 object
		JFrame window = new JFrame("Olympic Rings"); // Create the window with the title "Olympic Rings"
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the close operation to quit on close
		window.add(panel); // Draw the Week4Problem6 object onto the window
		window.setSize(350, 200); // Set the size of the window to 350 x 200 px
		window.setVisible(true); // Make the window visible
		
	}

}
