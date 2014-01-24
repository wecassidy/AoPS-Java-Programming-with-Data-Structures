import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class RandConcentricCircles extends JPanel {
	int numCircles = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of circles:"));
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int widthDifference = (getWidth() / 2) / numCircles;
		
		Random rand = new Random();
		Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		
		for (int i = 0; i < numCircles; i++) {
			if (i % 2 == 0) {g.setColor(color1);}
			else {g.setColor(color2);}
			
			g.fillOval(widthDifference * i, widthDifference * i, getWidth() - 2 * widthDifference * i, getHeight() - 2 * widthDifference * i);
		}
	}

	public static void main(String[] args) {
		RandConcentricCircles panel = new RandConcentricCircles();
		JFrame window = new JFrame("Concentric Circles");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setSize(100, 100);
		window.setVisible(true);

	}

}
