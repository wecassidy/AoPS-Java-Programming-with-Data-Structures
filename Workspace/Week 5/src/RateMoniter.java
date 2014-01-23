import java.util.Calendar; // Import the Calender class


public class RateMoniter {
	private String firstName; // Create the private String attribute firstName
	private String lastName; // Create the private String attribute lastName
	private int birthYear; // Create the private int attribute birthYear
	
	/**
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param birthYear the birth year
	 */
	public RateMoniter(String firstName, String lastName, int birthYear) {
		this.firstName = firstName; // Assign a value to this.firstName
		this.lastName = lastName; // Assign a value to this.lastName
		this.birthYear = birthYear; // Assign a value to this.birthYear
	}

	/**
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName; // Return the first name
	}

	/**
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName; // Assign a new value this this.firstName
	}

	/**
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName; // Return the last name
	}

	/**
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName; // Assign a new value this this.lastName
	}
	
	/**
	 * Gets the full name
	 * @return the full name as a string
	 */
	public String getName() {
		return this.firstName + ' ' + this.lastName; // Return the full name
	}
	
	/**
	 * Sets the full name
	 * @param firstName the new first name
	 * @param lastName the new last name
	 */
	public void setName(String firstName, String lastName) {
		this.firstName = firstName; // Assign a new value this this.firstName
		this.lastName = lastName; // Assign a new value this this.lastName
	}

	/**
	 * @return the birth year
	 */
	public int getBirthYear() {
		return birthYear; // Return the birth year
	}

	/**
	 * @param birthYear the new birth year
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;  // Assign a new value this this.birthYear
	}

	public String toString() {
		return "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nMaximum heart rate: " + this.getMaxHeartRate();
		/*
		 * Return format:
		 * Name: (first name) (last name)
		 * Age: (age)
		 * Maximum heart rate: (maximum heart rate)
		 */
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof RateMoniter)) {
			return false;
		}
		else {
			RateMoniter other = (RateMoniter) obj;
			return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName) && this.birthYear == other.birthYear;
		}
	}
	
	/**
	 * Get the age
	 * @return the age current age based on the calendar year
	 */
	public int getAge() {
		return Calendar.getInstance().get(Calendar.YEAR) - this.birthYear; // Return the age
	}
	
	/**
	 * Get the maximum heart rate
	 * @return the maximum heart rate
	 */
	public int getMaxHeartRate() {
		return 220 - this.getAge(); // Max heart rate = 220 - age
	}
	
	/**
	 * Checks if a given heart rate is in the target heart rate range
	 * @param heartRate the heart rate being checked
	 * @return 50% of max heart rate <= passed heart rate <= 85% of max heart rate
	 */
	public boolean isInTarget(int heartRate) {
		return heartRate >= this.getMaxHeartRate() * 0.50 && heartRate <= this.getMaxHeartRate() * 0.85; // Your target heart rate is a range between 50% and 85% of the maximum
	}
	
}
