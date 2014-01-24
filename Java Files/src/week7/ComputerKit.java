package week7;
import java.util.ArrayList;


public class ComputerKit {
	/**
	 * The list of the parts of the ComputerKit
	 */
	private ArrayList <ComputerPart> parts;

	/**
	 * @param parts the parts of the ComputerKit
	 */
	public ComputerKit(ArrayList<ComputerPart> parts) {
		this.parts = parts;
	}
	
	/**
	 * Add a part to the ComputerKit
	 * @param newPart the part to add
	 */
	public void addPart(ComputerPart newPart) {
		this.parts.add(newPart);
	}
	
	/**
	 * Check if a part is in the ComputerKit by the name
	 * @param name the name of the part to check
	 * @return whether or not a part with a name that matches the input string is in the ComputerKit.
	 */
	public boolean partIsInKit(String name) {
		for (ComputerPart part : this.parts) {
			if (part.getName() == name) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Get the total cost
	 * @return The total cost of the ComputerKit.
	 */
	public int cost() {
		int cost = 0;
		
		for (ComputerPart part : this.parts) {
			cost += part.getPrice();
		}
		
		return cost;
	}

}
