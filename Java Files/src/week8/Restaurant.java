package week8;

public class Restaurant extends Store {
	private int servedPerYear;
	private int pricePerPerson;

	public Restaurant(String newName, int servedPerYear, int pricePerPerson) {
		super(newName);
		this.servedPerYear = servedPerYear;
		this.pricePerPerson = pricePerPerson;
	}
	
	public String toString() {
		return super.getName() + " serves " + this.servedPerYear + " people per year at an average price of " + this.pricePerPerson;
	}
	
	public double taxesPerYear() {
		return this.servedPerYear * this.pricePerPerson * this.SALES_TAX_RATE;
	}

}
