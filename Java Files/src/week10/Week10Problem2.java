package week10;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Week10Problem2 extends JPanel {
	
	public Week10Problem2() {
		super();
		
		this.setLayout(new GridLayout(5, 5));
		
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				JButton button = new JButton((i + 1) + " " + (j + 1));
				button.addActionListener(new BHandler());
				this.add(button);
			}
		}
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setSize(500, 500);

		Week10Problem2 buttons = new Week10Problem2();
		window.add(buttons);
		
		window.setVisible(true);

	}
	
	private class BHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setText("Visible");
			
		}
		
	}

}
