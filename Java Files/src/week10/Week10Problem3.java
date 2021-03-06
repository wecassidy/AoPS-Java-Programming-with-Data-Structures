package week10;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Week10Problem3 extends JPanel {
	private JButton[][] buttons;
	private int[] winLoc;
	private int clicks;

	public Week10Problem3() {
		super();

		this.setLayout(new GridLayout(4, 6));
		
		this.buttons = new JButton[4][6];

		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 6; j ++) {
				JButton button = new JButton((i + 1) + " " + (j + 1));
				button.addActionListener(new BHandler());
				
				this.add(button);
				
				this.buttons[i][j] = button;
			}
		}

		this.winLoc = new int[2];

		Random r = new Random();
		this.winLoc[0] = r.nextInt(4);
		this.winLoc[1] = r.nextInt(6);

		this.clicks = 0;
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setSize(600, 400);

		Week10Problem3 buttons = new Week10Problem3();
		window.add(buttons);

		window.setVisible(true);

	}

	private class BHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();

			if (clicks < 5) {
				try {
					if (Integer.parseInt(source.getText().substring(0, 1)) - 1 == winLoc[0] && Integer.parseInt(source.getText().substring(2, 3)) - 1 == winLoc[1]) {
						source.setText("Won");
					}

					else {
						source.setText("No");
					}

				}

				catch (NumberFormatException nfe) {}
			}
			
			else {
				source.setText("Lost");
				
				buttons[winLoc[0]][winLoc[1]].setText("Here");
			}
			
			clicks ++;
		}
		
	}

}
