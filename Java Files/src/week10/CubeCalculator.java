package week10;
import java.awt.GridLayout; // Import the GridLayout class to help order the items of the cube calculator
import java.awt.event.ActionEvent; // Import the ActionEvent class for working with button clicks
import java.awt.event.ActionListener; // The class that handles button clicks implements the ActionListener interface

import javax.swing.JButton; // Import the JButton class for rendering buttons
import javax.swing.JFrame; // Import the JFrame class for creating windows
import javax.swing.JLabel; // The number in the CubeCalculator will be represented as a JLabel
import javax.swing.JPanel; // The buttons will be stored in a JPanel, and the CubeCalculator class will extend JPanel so that components can be added to it
import javax.swing.JScrollPane; // The JLabel will go into a JScrollPane so that a scrollbar shows up if the number becomes to large to fit in the window


public class CubeCalculator extends JPanel {
	private JLabel numLabel; // Store the label for the number in a field so that it can be accessed and modified by the button handler class

	public CubeCalculator() {
		super(); // Call the default constructor of the JPanel class

		this.setLayout(new GridLayout(2, 1)); // Set the layout of the CubeCalculator to a 2 row x 1 column grid

		this.numLabel = new JLabel("0", JLabel.RIGHT); // Instantiate the JLabel for the number to 0 and align it with the right of its parent component
		JScrollPane labelScroll = new JScrollPane(this.numLabel); // Add the JLabel to a JScrollPane so that a scrollbar will be added it the number becomes to big to fit in the JScrollPane's parent component

		this.add(labelScroll); // Add the JScrollPane containing the number label to the CubeCalculator using the inherited add method

		JPanel buttonPanel = new JPanel(); // Create a new JPanel for the buttons so that a different GridLayout can be used to order the buttons
		buttonPanel.setLayout(new GridLayout(4, 3)); // Set the layout of the JPanel that will contain the buttons to a 4 row x 3 column grid

		String[] buttonLabels = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "Clear", "0", "Cube"}; // Create an array of strings containing the labels of the buttons

		/*
		 * The layout of the buttons will be (approximately):
		 *   7   8   9
		 *   4   5   6
		 *   1   2   3
		 * Clear 0 Cube
		 */

		for (String label : buttonLabels) { // Loop through each label in the array of labels because only the label changes from one button to the next
			JButton button = new JButton(label); // Create a new JButton with the current label
			button.addActionListener(new BHandler()); // Add a new ActionListner to the button

			buttonPanel.add(button); // Add the button to the JPanel containing the buttons
		}

		this.add(buttonPanel); // Add the JPanel to the CubeCalculator, filling in the seconds space in the GridLayout
	}

	public void reset() {
		this.numLabel.setText("0"); // Clear all the numbers in the label and replace them with a 0
	}

	private class BHandler implements ActionListener { // The BHandler class implements the ActionListener interface so that it is forced to contain methods for handling actions/events

		@Override // Tell Java that the method overrides one in the superclass/implemented interface
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) { // Switch on the label of the button that generated the action
			case "Clear": // If the button was the one that clears the label:
				reset(); // Reset the CubeCalculator
				break; // Leave the switch

			case "Cube": // If the cube button was clicked:
				double cube = Math.pow(Double.parseDouble(numLabel.getText()), 3); // Calculate the cube of the number in the label with the pow method of the Math class

				numLabel.setText(Double.toString(cube)); // Set the text of the number label to the string equivalent of the cube
				break; // Leave the switch

			default: // For the rest of the buttons:
				if (numLabel.getText().equals("0")) { // If the number label doesn't contain any numbers other than 0:
					numLabel.setText(e.getActionCommand()); // Replace the text of the label with the number of the button clicked on
				}

				else { // Otherwise:
					numLabel.setText(numLabel.getText() + e.getActionCommand()); // Set the text of the number label to the current text of the label with the number clicked on appended to it
				}
			}

		}

	}

	public static void main(String[] args) {
		CubeCalculator calc = new CubeCalculator(); // Create a new CubeCalculator object

		JFrame window = new JFrame("Cube Calculator"); // Create a new window with the title "Cube Calculator"
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the close operation of the window to exit the application when it is closed
		window.setSize(500, 450); // Set the size of the window to 500 pixels x 450 pixels 
		window.add(calc); // Add the CubeCalculator to the window
		window.setVisible(true); // Make the window visible

	}

}
