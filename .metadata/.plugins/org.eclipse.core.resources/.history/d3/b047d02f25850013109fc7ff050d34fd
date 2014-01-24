import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FirstDrawing extends JPanel {
	public void paintComponent(Graphics g) { // Draws content in the panel
		super.paintComponent(g); // Prepare panel for drawing
		g.drawLine(10, 10, 10, getHeight() - 10);
		g.drawLine(10, getHeight() - 10, getWidth() - 10, getHeight() - 10);
		g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
		
	}

	public static void main(String[] args) {
        // create the panel where we are drawing our picture
        FirstDrawing fdPanel = new FirstDrawing();    
        // create the window where the picture appears
        JFrame window = new JFrame("First Graphics");
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
