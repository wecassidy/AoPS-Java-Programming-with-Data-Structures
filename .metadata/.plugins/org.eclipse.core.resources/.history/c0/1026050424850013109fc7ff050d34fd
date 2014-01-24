import javax.swing.JOptionPane;

public class WelcomeDialogueErrors {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		String message = String.format("Hi, %s! Welcome to Java!\n", name); // give friendly message
		JOptionPane.showMessageDialog(null, message);
		int ageNow = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
		int ageNext = ageNow + 1; // Calculate the age next year
		message = String.format("Next year, you will be %d.", ageNext); // print the age next year
		JOptionPane.showMessageDialog(null, message);
        if (ageNow < 30)
        {
            JOptionPane.showMessageDialog(null, "Wow, you're old!");
        }
	}

}
