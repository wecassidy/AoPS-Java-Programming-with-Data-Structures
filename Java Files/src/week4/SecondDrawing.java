package week4;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SecondDrawing extends JPanel {
	int lines = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of lines:"));
	int startX = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the starting x value:"));
	int startY = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the starting y value:"));
	
	public void paintComponent(Graphics g) { // Draws content in the panel
        // Prepare panel for drawing
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int incrementX = (w - 2 * startX) / (lines - 1);
        
        for(int lineNumber = 0; lineNumber < lines; lineNumber ++) {
        	g.drawLine(startX + lineNumber * incrementX, startY, startX + (lines - 1 - lineNumber) * incrementX, h - startY);
        }
    }

	public static void main(String[] args) {
		// create the panel where we are drawing our picture
        SecondDrawing fdPanel = new SecondDrawing();    
        // create the window where the picture appears
        JFrame window = new JFrame("Second Graphics");
        // allow us to close the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        // put the panel in the window
        window.add(fdPanel);        
        // set initial dimensions of the window (width and height)
        window.setSize(250, 250);        
        // make sure window is visible on screen
        window.setVisible(true);

	}

}
