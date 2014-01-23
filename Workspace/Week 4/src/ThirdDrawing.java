import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ThirdDrawing extends JPanel {	
	public void paintComponent(Graphics g) { // Draws content in the panel
        // Prepare panel for drawing
        super.paintComponent(g);
        
        g.drawRect(10, 60, 30, 100);
        g.drawRect(10,  160,  100,  30);
        g.drawRect(110, 90, 30, 100);
        g.drawRect(40, 60, 100, 30);
    }

	public static void main(String[] args) {
		// create the panel where we are drawing our picture
        ThirdDrawing fdPanel = new ThirdDrawing();    
        // create the window where the picture appears
        JFrame window = new JFrame("Third Graphics");
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