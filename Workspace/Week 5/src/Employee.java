
public class Employee {
	private String name; // Create the private String attribute name
	private String title; // Create the private String attribute title
	private int salary; // Create the private int attribute salary
	
	/**
	 * Creates a new Employee object
	 * @param newName : the name of the employee
	 * @param newTitle : the title of the employee
	 * @param newSalary : the salary of the employee. If the parameter is negative or 0, then the salary defaults to $25,000
	 */
	public Employee(String newName, String newTitle, int newSalary) {
		this.name = newName; // Set the name attribute of this object to newName
		this.title = newTitle; //Set the title attribute of this object to newTitle
		if (newSalary > 0) {this.salary = newSalary;} // If the entered salary is positive, set the salary attribute of this object to newSalary
		else {this.salary = 25000;} // Otherwise, set the salary attribute of this object to $25,000
	}
	
	/**
	 * Creates a new Employee object with a salary of $25,000
	 * @param newName : the name of the employee
	 * @param newTitle : the title of the employee
	 */
	public Employee(String newName, String newTitle) {
		this.name = newName; // Set the name attribute of this object to newName
		this.title = newTitle; //Set the title attribute of this object to newTitle
		this.salary = 25000; // Set the salary attribute of this object to $25,000
	}

	/**
	 * Gets the name of the employee
	 * @return The name of the employee
	 */
	public String getName() {
		return this.name; // Return the name attribute of this object
	}

	/**
	 * Set the name of the employee
	 * @param newName : the new name of the employee
	 */
	public void setName(String newName) {
		this.name = newName; // Set the name attribute of this object to newName
	}

	/**
	 * Gets the title of the employee
	 * @return The title of the employee
	 */
	public String getTitle() {
		return this.title; // Return the title attribute of this object
	}

	/**
	 * Set the title of the employee
	 * @param newTitle : the new title of the employee
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle; // Set the title attribute of this object to newTitle
	}

	/**
	 * Gets the salary of the employee
	 * @return The salary of the employee
	 */
	public int getSalary() {
		return this.salary; // Return the salary attribute of this object
	}

	/**
	 * Sets the salary of the employee
	 * @param newSalary : the new salary of the employee. If the parameter is negative or 0, then the salary remains the same
	 */
	public void setSalary(int newSalary) {
		if (newSalary > 0) {this.salary = newSalary;} // If the entered salary is positive, set the salary attribute of this object to newSalary
	}

	/**
	 * Convert the Employee object to a string
	 */
	public String toString() {
		return "Name: " + this.name + ", Title: " + this.title + ", Salary: " + this.salary; // Return the name, title, and salary attributes of this object
	}
	
	/**
	 * Check if the Employee object is equal to another object
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Employee)) { // If the other object isn't an Employee object:
			return false; // other can't be equal to this object
		}
		else { // Otherwise:
			Employee otherEmp = (Employee) other; // Force other into an Employee object
			return this.name.equals(otherEmp.name) && this.title.equals(otherEmp.title) && this.salary == otherEmp.salary; // Return whether or not the two objects are identical
		}
	}
	
	/**
	 * Gives the employee a raise by an integer percent
	 * @param percent : the percentage of the raise
	 */
	public void raise(int percent) {
		if (percent > 0) { // Check if the percent is positive
			this.salary += this.salary * percent / 100; // Give the this object a raise by percent%
		}
	}

}
