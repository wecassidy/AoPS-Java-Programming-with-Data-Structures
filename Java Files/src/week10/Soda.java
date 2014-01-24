package week10;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Soda extends JPanel {
	public static final int CAP = 2;
	public static final int COST = 60;
	private String brand;
	private int numLeft;
	private JLabel message;
	private ChangeBin cb;

	public Soda(String name, String imageFile, ChangeBin bin) {
		super();
		this.brand = name;
		this.numLeft = CAP;
		this.cb = bin;

		ImageIcon icon = new ImageIcon(imageFile,brand);

		this.message = new JLabel("Cans left = " + numLeft, icon, JLabel.CENTER);

		JButton dispenseB = new JButton(brand);
		setLayout(new FlowLayout());
		add(message);
		add(dispenseB);
		ButtonHandler bh = new ButtonHandler();
		dispenseB.addActionListener(bh);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int cents;
			String mesg;
			cents = cb.getChange();

			if (cents >= COST && numLeft > 0) {
				numLeft--;
				message.setText("Cans left = " + numLeft);
				
				if (numLeft == 0) {
					message.setForeground(Color.ORANGE);
				}
				
				mesg = "You get " + brand;
				
				if (cents != COST) {
					mesg = mesg + " & " + (cents-COST) + " cents";
				}
				
				cb.setStatus(mesg);
				cb.reset();
			}

			else if (cents >= COST && numLeft == 0) {
				cb.setStatus("No " + brand + " available!");
			}
			
			else if (cents < COST) {
				cb.setStatus("You need " + (COST - cents) + " more");
			}
		}
	}

}
