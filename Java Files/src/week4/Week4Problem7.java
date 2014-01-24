package week4;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Week4Problem7 extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g); // Clear the screen
		
		g.drawLine(0, 70, 70, 0); // Draw the left section of the roof
		g.drawLine(70, 0, 140, 70); // Draw the right section of the roof
		
		g.drawRect(10, 60, 120, 120); // Draw the box of the house
		
		g.drawRect(20, 70, 40, 40); // Draw the box of the first window
		g.drawLine(20, 90, 60, 90); // Draw the horizontal bar in the first window
		g.drawLine(40, 70, 40, 110); // Draw the vertical bar in the first window
		
		g.drawRect(80, 70, 40, 40); // Draw the box of the second window
		g.drawLine(80, 90, 120, 90); // Draw the horizontal bar in the second window
		g.drawLine(100, 70, 100, 110); // Draw the vertical bar in the second window
		
		g.drawRect(50, 120, 40, 60); // Draw the door
		
		g.fillOval(75, 145, 5, 5); // Draw the doorknob
	}

	public static void main(String[] args) {
		Week4Problem7 panel = new Week4Problem7(); // Create a new Week4Problem6 object
		JFrame window = new JFrame("House"); // Create the window with the title "House"
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the close operation to quit on close
		window.add(panel); // Draw the Week4Problem6 object onto the window
		window.setSize(140, 210); // Set the size of the window to 140 x 210 px
		window.setVisible(true); // Make the window visible

	}

}
