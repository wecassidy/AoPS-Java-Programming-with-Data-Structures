package week10;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class Machine {

	public static void main(String[] args) {
		JFrame window = new JFrame("Vending Machine");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setSize(500, 450);

		window.setLayout(new GridLayout(4,1));

		ChangeBin cb = new ChangeBin();
		window.add(cb);

		Soda grapeSplash = new Soda("Grape Splash","grapeSplash.png", cb);
		Soda locaCola = new Soda("Loca Cola", "locaCola.png", cb);
		Soda sprintSoda = new Soda("Sprint", "sprintSoda.png", cb);

		window.add(grapeSplash);
		window.add(locaCola);
		window.add(sprintSoda);

		window.setVisible(true);

	}

}
