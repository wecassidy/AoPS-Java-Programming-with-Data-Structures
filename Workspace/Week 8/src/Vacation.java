import java.util.ArrayList; // The list of items in the piecemeal vacation will be represented by an ArrayList

/**
 * Abstract superclass for the vacation classes
 */
public abstract class Vacation {
	/**
	 * The budget of the vacation
	 */
	private int budget; // Declare the attribute for the budget

	/**
	 * Constructor to be used by the subclasses
	 * @param budget the budget of the vacation
	 */
	public Vacation(int budget) {
		if (budget > 0) { // If the budget argument is positive
			this.budget = budget; // Set the budget to the argument
		}
	}

	/**
	 * Get the budget
	 * @return the budget
	 */
	public int getBudget() {
		return this.budget; // Return the budget
	}

	/**
	 * Set the budget
	 * @param budget the new budget
	 */
	public void setBudget(int budget) {
		if (budget > 0) { // If the new budget is positive
			this.budget = budget; // Set the budget to the argument
		}
	}

	public abstract boolean overBudget(); // Add an abstract method for that the subclasses have to override

}

/**
 * Represents an all-inclusive vacation
 */
class AllInclusive extends Vacation { // the all inclusive vacation is inherited from the abstract Vacation class
	/**
	 * The brand of the vacation
	 */
	private String brand; // Declare the attribute for the brand of the vacation

	/**
	 * The rating of the vacation (as an integer number of stars)
	 */
	private int rating; // Declare the attribute for the rating of the vacation

	/**
	 * The price of the vacation
	 */
	private int price; // Declare the attribute for the price of the vacation


	/**
	 * Constructor for the all inclusive vacation
	 * @param budget the budget of the vacation
	 * @param brand the brand of the vacation (e. g. Disney)
	 * @param rating the rating of the vacation as an integer number of stars
	 * @param price the price of the vaction
	 */
	public AllInclusive(int budget, String brand, int rating, int price) {
		super(budget); // Use the superclass's constructor, passing the budget argument as a parameter

		this.brand = brand; // Set the brand of the vacation to the brand argument
		this.rating = rating; // Set the rating of the vacation to the rating argument
		this.price = price; // Set the price of the vacation to the price argument
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return this.brand; // Return the brand of the vacation
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand; // Set the brand of the vacation
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return this.rating; // Return the rating of the vacation
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating; // Set the rating of the vacation
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return this.price; // Return the price of the vacation
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price; // Set the price of the vacation
	}

	/**
	 * Check if the vacation is over-budget
	 * @return if the price of the vacation is greater than the budget
	 */
	@Override // Tell Java that this method overrides the superclass's overBudget() method
	public boolean overBudget() {
		return this.price > super.getBudget(); // The vacation is over budget if and only if the price of the vacation is greater than the budget
	}

}

/**
 * Represents an item in a piecemeal vacation
 */
class Item {
	/**
	 * The name of the item
	 */
	private String name; // Declare the attribute for the name of the item

	/**
	 * The price of the item
	 */
	private int price; // Declare the attribute for the price of the item

	/**
	 * Constructor for an Item
	 * @param name the name of the item (e. g. Hotel)
	 * @param price the price of the item
	 */
	public Item(String name, int price) {
		this.name = name; // Set the value of the name
		this.price = price; // Set the value of the price
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name; // Return the name of the item
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name; // Set the name of the item
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return this.price; // Return the price of the item
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price; // Set the price of the item
	}

}

/**
 * Represents a vacation bought piecemeal
 */
class PiecemealVacation extends Vacation { // Inherit the piecemeal vacation class from the Vacation class
	/**
	 * The items on the vacation as an ArrayList of Items
	 */
	private ArrayList<Item> items; // Declare the ArrayList of Items that will represent the items bought for the piecemeal vacation

	/**
	 * Constructor for the piecemeal vacation
	 * @param budget the budget of the vacation
	 * @param items an ArrayList of Items that represents the items bought for the vacation
	 */
	public PiecemealVacation(int budget, ArrayList<Item> items) {
		super(budget); // Call the constructor of the superclass

		this.items = items; // Set the items attribute to the items argument
	}

	/**
	 * @return the items bought for the vacation
	 */
	public ArrayList<Item> getItems() {
		return this.items; // Return the ArrayList of items
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items; // Set the items attribute
	}

	/**
	 * Get an individual item
	 * @param index the index of the item in the ArrayList of items
	 * @return the item at the index given
	 */
	public Item getItem(int index) {
		return this.items.get(index); // Return the item at the given index
	}

	/**
	 * Sets an item at a given index
	 * @param index
	 * @param item
	 */
	public void setItem(int index, Item item) {
		this.items.set(index, item); // Set the item at the given index to the item argument
	}

	/**
	 * Adds an item to the end of the list of items
	 * @param item the item to add
	 */
	public void addItem(Item item) {
		this.items.add(item); // Add an item at the end of the ArrayList of items
	}

	/**
	 * Adds an item at a given index in the list of items, shifting all the items after it to make room
	 * @param index the index to insert the item at
	 * @param item the item to add
	 */
	public void addItem(int index, Item item) {
		this.items.add(index, item); // Add an item at the specified index in the ArrayList of items
	}
	/**
	 * Checks if the vacation is over budget. A vacation is over budget if and only if the total price of the items is greater than the budget
	 */
	@Override // Tell Java that the next method is going to override the overBudget() method in the superclass
	public boolean overBudget() {
		int totalPrice = 0; // Initialise the sum of the prices of the items in the ArrayList of items bought for the vacation to 0

		for (Item item : this.items) { // Go through each item in the ArrayList of items
			totalPrice += item.getPrice(); // Add the price of the current item to the sum of the prices of the items
		}

		return totalPrice > super.getBudget(); // The vacation is over budget if and only if the sum of the prices of the items bought for the vacation is greater than the budget
	}
}
