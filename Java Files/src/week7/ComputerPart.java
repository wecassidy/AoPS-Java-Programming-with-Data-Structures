package week7;

public class ComputerPart {
	/**
	 * The name of the ComputerPart.
	 */
	private String name;
	
	/**
	 * The price of the ComputerPart.
	 */
	private int price;
	
	/**
	 * Create a new ComputerPart
	 * @param name the name
	 * @param price the price
	 */
	public ComputerPart(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
