package week10;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class ChangeBin extends JPanel {
	private JLabel status;
	private JLabel coinmesg;
	private int total;

	public ChangeBin() {
		super(); // Call the constructor of the superclass

		this.total = 0;

		this.status = new JLabel("Welcome!");
		this.status.setVerticalAlignment(SwingConstants.TOP);

		this.coinmesg = new JLabel("Cents: " + this.total, JLabel.RIGHT);
		this.coinmesg.setVerticalAlignment(SwingConstants.TOP);

		JButton nickelB = new JButton("Add a nickel");
		JButton dimeB = new JButton("Add a dime");
		JButton quarterB = new JButton("Add a quarter");
		JButton backB = new JButton("Get change back");

		this.setLayout(new GridLayout(3, 2));

		this.add(this.status);
		this.add(this.coinmesg);

		this.add(nickelB);
		this.add(dimeB);
		this.add(quarterB);
		this.add(backB);

		ButtonHandler bh = new ButtonHandler();

		nickelB.addActionListener(bh);
		dimeB.addActionListener(bh);
		quarterB.addActionListener(bh);
		backB.addActionListener(bh);
	}

	public int getTotal() {
		return this.total;
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String which = event.getActionCommand();

			if (which.equals("Get change back")) {
				status.setText("You get " + total + " back");
				total = 0;
				coinmesg.setText("Cents: " + total);
			}

			else {
				if (which.equals("Add a nickel")) {
					total +=5;
				}

				else if (which.equals("Add a dime")) {
					total += 10;
				}

				else {
					total += 25;
				}

				status.setText("");
				coinmesg.setText("Cents: " + total);
			}

		}

	}

	public int getChange() {
		return this.total;
	}

	public void setStatus(String status) {
		this.status.setText(status);
	}

	public void reset() {
		total = 0;
		coinmesg.setText("Cents: " + total);
	}

}
