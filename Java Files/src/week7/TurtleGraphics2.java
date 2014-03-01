package week7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TurtleGraphics2 extends JPanel {
	/**
	 * The row that the turtle is on.
	 */
	private int row; // Declare the variable for the row of the turtle

	/**
	 * The column that the turtle is on.
	 */
	private int column; // Declare the variable for the column of the turtle

	/**
	 * The direction of the turtle. Can be either {@code "<"} for left, {@code ">"} for right, {@code "^"} for up, or {@code "v"} for down.
	 */
	private String direction; // Declare the variable for the direction

	/**
	 * {@code true} if the pen is down, {@code false} if the pen is up.
	 */
	private boolean penDown; // Declare the variable that stores the state of the pen

	/**
	 * {@code true} if the pen is being used as an eraser, {@code false} if the pen is drawing.
	 */
	private boolean eraser; // Declare the variable that stores whether or not the pen is in eraser mode

	/**
	 * The board.
	 */
	private String[][] board; // Declare the board

	/**
	 * Creates a TurtleGraphics object with a 20x20 board and with a turtle facing right with the pen up.
	 */
	public TurtleGraphics2() {
		this.row = 0; // Set the row of the turtle to 0
		this.column = 0; // Set the column of the turtle to 0

		this.direction = ">"; // Set the direction to right
		this.penDown = false; // Set the state of the pen to false
		this.eraser = false; // Set the mode of the pen to draw

		this.board = new String[20][20]; // Create an array of string arrays (a 2-dimensional string array) and use it as the board

		for (int r = 0; r < this.board.length; r ++) { // Go through each row in the board
			for (int c = 0; c < this.board[r].length; c ++) { // Go through each column in this row
				this.board[r][c] = " "; // Set the current cell to be empty
			}
		}
	}

	/**
	 * Creates a TurtleGraphics object
	 * @param row the number of rows in the board
	 * @param columns the number of columns in the board
	 */
	public TurtleGraphics2(int rows, int columns) {
		this.row = 0; // Set the row of the turtle to 0
		this.column = 0; // Set the column of the turtle to 0

		this.direction = ">"; // Set the direction to right
		this.penDown = false; // Set the state of the pen to false
		this.eraser = false; // Set the mode of the pen to draw

		this.board = new String[rows][columns]; // Create an array of string arrays (a 2-dimensional string array) and use it as the board

		for (int r = 0; r < this.board.length; r ++) { // Go through each row in the board
			for (int c = 0; c < this.board[r].length; c ++) { // Go through each column in this row
				this.board[r][c] = " "; // Set the current cell to be empty
			}
		}
	}

	/**
	 * @return the location
	 */
	public int[] getPos() {
		int[] outArray = new int[] {this.row, this.column}; // Create an array of length 2 with the row and column as entries
		return outArray; // Return the location array
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(int row, int column) {
		this.row = row; // Set the row of the turtle
		this.column = column; // Set the column of the turtle
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return this.direction; // Get the direction of the turtle
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction; // Set the direction of the turtle
	}

	/**
	 * @return the {@code true} if the pen is down, {@code false} otherwise.
	 */
	public boolean isPenDown() {
		return this.penDown; // Return the state of the pen
	}

	/**
	 * @param penDown {@code true} if the pen is to be set down, {@code false} otherwise.
	 */
	public void setPenDown(boolean penDown) {
		this.penDown = penDown; // Set the state of the pen to the input parameter
	}

	/**
	 * Set the eraser
	 * @param eraser the value of the eraser to set
	 */
	public void setEraser(boolean eraser) {
		this.eraser = eraser; // Set the state of the eraser to the input parameter
	}

	/**
	 * Raises the pen if it is down, lowers the pen if it is up.
	 */
	public void togglePen() {
		this.penDown = !this.penDown; // Flip the state of the pen
	}

	/**
	 * @return the board
	 */
	public String[][] getBoard() {
		return this.board; // Return the board
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(String[][] board) {
		this.board = board; // Set the board attribute to the input board
	}

	/**
	 * Get the value of a cell
	 * @param x the x coordinate of the cell
	 * @param y the y coordinate of the cell
	 * @return "*" if the cell has been drawn on or " " if it hasn't
	 */
	public String getCell(int row, int column) {
		return this.board[row][column]; // Return the value of the cell at the given row and column
	}

	/**
	 * Sets the value of a cell
	 * @param x the x coordinate of the cell
	 * @param y the y coordinate of the cell
	 * @param draw whether of not to draw in the cell
	 */
	public void setCell(int row, int column, boolean draw) {
		this.board[row][column] = draw == true ? "*" : " "; // If draw is true, set the cell to "*", otherwise set it to " "
	}

	/**
	 * Draw in a cell
	 * @param row the row to draw in
	 * @param column the column to draw in
	 */
	public void draw(int row, int column) {
		this.board[row][column] = "*"; // Set the contents of the cell at the given row and column to an asterisk
	}

	/**
	 * Erase the contents of a cell
	 * @param row the row to erase
	 * @param column the column erase
	 */
	public void erase(int row, int column) {
		this.board[row][column] = " "; // Set the contents of the cell at the given row and column to a space
	}

	public String toString() {
		/*
		 * The board will be in the form:
		 * |*  >  *** ... *|
		 * |  **  *   ...  |
		 *   .
		 *   .
		 *   .
		 * |*** **       * |
		 */

		String outStr = ""; // outStr is the output string

		for (int r = 0; r < board.length; r ++) { // Loop through each row of the board
			outStr += "|"; // Add a vertical bar to the output string to indicate the start of a new row
			for (int c = 0; c < board[r].length; c ++) { // Loop through each column in this row
				if (r == this.row && c == this.column) {outStr += this.direction;} // If the current cell is the one the turtle is on, draw the turtle

				else {outStr += board[r][c];} // Otherwise, add the contents of the cell at row r and column c to the output string
			}

			outStr += "|\n"; // End the content of the row and start a new line
		}

		return outStr; // Output the output string
	}

	/**
	 * Turns the turtle
	 * @param left {@code true} if the turtle is turning left (counterclockwise), {@code false} if the turtle is turning right (clockwise)
	 */
	public void turn(boolean left) {
		if (left) { // If the turtle is turning left (counterclockwise)
			if (this.direction.equals("^")) {this.direction = "<";} // If the turtle is pointing up, turn it so that it is pointing left
			else if (this.direction.equals("<")) {this.direction = "v";} // If the turtle is pointing left, turn it so that it is pointing down
			else if (this.direction.equals("v")) {this.direction = ">";} // If the turtle is pointing down, turn it so that it is pointing right
			else if (this.direction.equals(">")) {this.direction = "^";} // If the turtle is pointing right, turn it so that it is pointing up
		}

		else {
			if (this.direction.equals("^")) {this.direction = ">";} // If the turtle is pointing up, turn it so that it is pointing right
			else if (this.direction.equals("<")) {this.direction = "^";} // If the turtle is pointing left, turn it so that it is pointing up
			else if (this.direction.equals("v")) {this.direction = "<";} // If the turtle is pointing down, turn it so that it is pointing left
			else if (this.direction.equals(">")) {this.direction = "v";} // If the turtle is pointing right, turn it so that it is pointing down
		}
	}

	/**
	 * Moves the turtle forward <var>n</var> spaces
	 * @param numForward the number of spaces forward
	 */
	public void forward(int numForward) {
		switch (this.direction) { // Do different things, depending on the direction
		case "^": // If the turtle is facing up:
			if (this.penDown) { // If the pen is down:
				for (int i = this.row; i >= Math.max(this.row - numForward, 0); i --) { // Loop through each cell in this column, decrementing the row by 1 each iteration until the turtle is reached
					if (this.eraser) {this.erase(i, this.column);} // If the pen is in eraser mode, erase the contents of the current cell

					else {this.draw(i, this.column);} // Draw in the cell for this iteration.
				}
			}

			this.row = Math.max(this.row - numForward, 0); // Set the row of the turtle to the larger of (the current row of the turtle - the number of steps to go forward, the edge of the board)

			break; // Leave the switch so that the other cases aren't executed

		case "<": // If the turtle is facing left:
			if (this.penDown) { // If the pen is down:
				for (int i = this.column; i >= Math.max(this.column - numForward, 0); i --) { // Loop through each cell in this row, decrementing the column by 1 each iteration until the turtle is reached
					if (this.eraser) {this.erase(this.row, i);} // If the pen is in eraser mode, erase the contents of the current cell

					else {this.draw(this.row, i);} // Draw in the cell for this iteration.
				}
			}

			this.column = Math.max(this.column - numForward, 0); // Set the column of the turtle to the larger of (the current column of the turtle - the number of steps to go forward, the edge of the board)

			break; // Leave the switch so that the other cases aren't executed

		case "v": // If the turtle is facing down:
			if (this.penDown) { // If the pen is down:
				for (int i = this.row; i <= Math.min(this.row + numForward, this.board.length - 1); i ++) { // Loop through each cell in this column, incrementing the row by 1 each iteration until the turtle is reached
					if (this.eraser) {this.erase(this.row, i);} // If the pen is in eraser mode, erase the contents of the current cell

					else {this.draw(this.row, i);} // Draw in the cell for this iteration.
				}
			}

			this.row = Math.min(this.row + numForward, this.board.length - 1); // Set the row of the turtle to the smaller of (the current row of the turtle + the number of steps to go forward, the edge of the board)

			break; // Leave the switch so that the other cases aren't executed

		case ">": // If the turtle is facing right:
			if (this.penDown) { // If the pen is down:
				for (int i = this.column; i <= Math.min(this.column + numForward, this.board[0].length - 1); i ++) { // Loop through each cell in this row, incrementing the column by 1 each iteration until the turtle is reached
					if (this.eraser) {this.erase(this.row, i);} // If the pen is in eraser mode, erase the contents of the current cell

					else {this.draw(this.row, i);} // Draw in the cell for this iteration.
				}
			}

			this.column = Math.min(this.column + numForward, this.board.length - 1);  // Set the column of the turtle to the smaller of (the current column of the turtle + the number of steps to go forward, the edge of the board)

			break; // Leave the switch so that the other cases aren't executed
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Clear the board

		for (int r = 0; r < this.board.length; r ++) { // Loop through all the rows
			for (int c = 0; c < this.board[r].length; c ++) { // Loop through all the columns in this row

				if (this.board[r][c] == " ") {g.drawRect(c * 20, r * 20, 20, 20);} // If the current cell is empty, draw an empty 20x20 square

				else {g.fillRect(c * 20, r * 20, 20, 20);} // Otherwise, draw a full 20x20 square

				if (r == this.row && c == this.column) { // If the current cell is the one the turtle is on:
					Polygon p = new Polygon(); // Create a new Polygon that will represent the turtle

					if (this.direction.equals("^")) { // If the turtle is facing up, create a isosceles triangle facing up
						p.addPoint(c * 20 + 10, r * 20); // The top corner of the triangle
						p.addPoint(c * 20, r * 20 + 20); // The bottom left corner of the triangle
						p.addPoint(c * 20 + 20, r * 20 + 20); // The bottom right corner of the triangle
					}

					if (this.direction.equals(">")) { // If the turtle is facing right, create a isosceles triangle facing right
						p.addPoint(c * 20, r * 20); // The top left point of the triangle
						p.addPoint(c * 20, r * 20 + 20); // The bottom left point of the triangle
						p.addPoint(c * 20 + 20, r * 20 + 10); // The right point of the triangle
					}

					if (this.direction.equals("<")) { // If the turtle is facing left, create a isosceles triangle facing left
						p.addPoint(c * 20, r * 20 + 10); // The top of the triangle
						p.addPoint(c * 20 + 20, r * 20); // The bottom left corner of the triangle
						p.addPoint(c * 20 + 20, r * 20 + 20); // The bottom right corner of the triangle
					}

					if (this.direction.equals("v")) { // If the turtle is facing down, create a isosceles triangle facing down
						p.addPoint(c * 20, r * 20); // The top left corner of the triangle
						p.addPoint(c * 20 + 20, r * 20); // The top right corner of the triangle
						p.addPoint(c * 20 + 10, r * 20 + 20); // The bottom corner of the triangle
					}

					g.setColor(Color.GREEN); // Set the colour to green so that the turtle stands out against the grid

					g.fillPolygon(p); // Add the turtle to the grid

					g.setColor(Color.BLACK); // Set the colour back to black
				}
			}
		}
	}

	public static void main(String[] args) {
		int rows = 0;
		int columns = 0;

		boolean invalidInput = true;
		while (invalidInput) {
			try {
				rows = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of rows in the board, or 0 for the default number (20):", "Enter rows", JOptionPane.QUESTION_MESSAGE)); // Prompt the user to enter the width of the board
				invalidInput = false;
			}

			catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Please enter a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		invalidInput = true;
		while (invalidInput) {
			try {
				columns = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the columns of rows in the board, or 0 for the default number (20):", "Enter columns", JOptionPane.QUESTION_MESSAGE)); // Prompt the user to enter the height of the board
				invalidInput = false;
			}

			catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Please enter a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		rows = rows != 0 ? rows : 20; // If the user entered 0 for the number of rows, set the number of rows to the default (20)
		columns = columns != 0 ? columns : 20; // If the user entered 0 for the number of columns, set the columns of rows to the default (20)

		TurtleGraphics2 tg = new TurtleGraphics2(rows, columns); // Create a new TurtleGraphics object
		JFrame window = new JFrame("Turtle Graphics"); // Create a window with the caption "Turtle Graphics"

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(tg); // Add the TurtleGraphics object to the window
		window.setSize(columns * 20, rows * 20 + 20); // Make the window as big as the board
		window.setVisible(true); // Make the window visible

		String choice = JOptionPane.showInputDialog(null, "Enter:\n"
				+ "\"u\" to put the pen up,\n"
				+ "\"d\" to put the pen down,\n"
				+ "\"l\" to turn left,\n"
				+ "\"r\" to turn right,\n"
				+ "\"e\" to use an eraser,\n"
				+ "\"p\" to draw,\n"
				+ "\"t\" to toggle the pen,\n"
				+ "\"f x\" to move forward x spaces, where x is an integer,\n"
				+ "or \"q\" to quit", "Enter move", JOptionPane.INFORMATION_MESSAGE).toLowerCase(); // Get the user's choice and convert it to all lowercase so that the code is case insensitive


		while (!choice.equals("q")) { // Repeat until the user decides to quit the program
			switch (choice) { // Do different things, depending on the user's input
			case "u": // If the user decided to put the pen up:
				tg.setPenDown(false); // Set the state of the pen to false (up)
				break; // Leave the switch so that the other cases aren't executed

			case "d": // If the user decided to put the pen down:
				tg.setPenDown(true); // Set the state of the pen to true (down)
				break; // Leave the switch so that the other cases aren't executed

			case "l": // If the user decided to turn left:
				tg.turn(true); // Turn the turtle 90deg to the left (counterclockwise)
				break; // Leave the switch so that the other cases aren't executed

			case "r": // If the user decided to turn left:
				tg.turn(false); // Turn the turtle 90deg to the right (clockwise)
				break; // Leave the switch so that the other cases aren't executed

			case "e":
				tg.setEraser(true); // Set the eraser to true
				break; // Leave the switch so that the other cases aren't executed

			case "p":
				tg.setEraser(false); // Set the eraser to false so that the user can draw
				break; // Leave the switch so that the other cases aren't executed

			case "t":
				tg.togglePen(); // Toggle the pen
				break; // Leave the switch so that the other cases aren't executed

			case "q": // If the user decided to quit:
				break; // Do nothing because the end-of-program message and so forth is handled after the while loop

			default: // If none of the cases above are applicable:
				if (choice.length() > 2 && choice.substring(0, 2).equals("f ")) { // Check if the user decided to move forward
					int numForward = Integer.parseInt(choice.substring(2, choice.length())); // Get the number of spaces to move forward

					tg.forward(numForward); // Move forward the number of spaces indicated by the user
				}

				else {JOptionPane.showMessageDialog(null, "I don't understand \"" + choice + "\". Please check your spelling.", "Error", JOptionPane.ERROR_MESSAGE);} // If the user entered an invalid command, let him/her know
			}
			
			tg.repaint(); // Update the window

			choice = JOptionPane.showInputDialog(null,
					"Enter \"l\" to turn left, "
					+ "\"r\" to turn right, "
					+ "\"u\" to lift the pen, "
					+ "\"d\" to lower the pen, "
					+ "\"e\" to use an eraser, "
					+ "\"p\" to draw, "
					+ "\"t\" to toggle the pen, "
					+ "\"f x\" to move forward x spaces, or "
					+ "\"q\" to quit: ", "Choose one", JOptionPane.QUESTION_MESSAGE).toLowerCase(); // Show the one-line version of the menu
		}

		// After the user quits:
		JOptionPane.showMessageDialog(null, "Thank you for using!"); // Print a closing message
		window.dispose();

	}

}
