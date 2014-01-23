import java.awt.Color; // Import the Color class
import java.awt.Graphics; // Import the Graphics class
import java.util.Random; // Import the Random class

import javax.swing.JFrame; // Import the JFrame class
import javax.swing.JOptionPane; // Import the JOptionPane class
import javax.swing.JPanel; // Import the JPanel class


public class Week4Problem8 extends JPanel { // The Week4Problem8 class is descended from the JPanel class
	int numRects = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of rectangles:")); // Get the number of rectangles wanted through an input dialog
	
	public void paintComponent(Graphics g) { // The method that draws everything
		Random rand = new Random(); // Create a new Random object
		
		for (int i = 0; i < numRects; i ++) { // Loop numRects times
			switch (rand.nextInt(3)) { // Switch on a random number from 0 to 2, inclusive
			case 0: // If 0:
				g.setColor(Color.RED); // Set the colour to red
				break; // Leave the switch
			
			case 1: // If 1:
				g.setColor(Color.GREEN); // Set the colour to green
				break; // Leave the switch
				
			default: // Otherwise:
				g.setColor(Color.BLUE); // Set the colour to blue
			}
			
			int x = rand.nextInt(getWidth()); // The x coordinate of the top left corner of the rectangle is a random number from the range (0, width of the screen - 1), inclusive
			int y = rand.nextInt(getHeight()); // The y coordinate of the top left corner of the rectangle is a random number from the range (0, height of the screen - 1), inclusive
			
			int width = rand.nextInt(getWidth()); // The width of the rectangle is a random number from the range (0, width of the screen - 1), inclusive
			int height = rand.nextInt(getHeight()); // The height of the rectangle is a random number from the range (0, height of the screen - 1), inclusive
			
			g.fillRect(x, y, width, height); // Draw a width x height filled rectangle with the top left corner at (x, y)
		}
	}

	public static void main(String[] args) {
		Week4Problem8 panel = new Week4Problem8(); // Create a new Week4Problem8 object
		JFrame window = new JFrame("Random Rectangles"); // Create a window with the caption "Random Rectangles"
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the window to exit when you close it
		window.add(panel); // Add the Week4Problem8 object to the window
		window.setSize(250, 250); // Set the window to 250 by 250 px
		window.setVisible(true); // Make the window visible

	}

}
