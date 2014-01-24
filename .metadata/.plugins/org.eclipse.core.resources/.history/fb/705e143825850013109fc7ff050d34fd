
public class Forecast {
	private double temp;
	private String skyCond;
	
	/**
	 * @param temp : the temperature
	 * @param skyCond : the sky conditions
	 */
	public Forecast(double newTemp, String newSkyCond) {
		if (temp >= -50 && temp <= 150) {
			this.temp = newTemp;
		}
		else {
			this.temp = 70.0;
		}
		
		this.skyCond = newSkyCond;
	}

	/**
	 * @param temp : the temperature
	 */
	public Forecast(double newTemp) {
		if (temp >= -50 && temp <= 150) {
			this.temp = newTemp;
		}
		else {
			this.temp = 70.0;
		}
		
		this.skyCond = "sunny";
	}

	/**
	 * @param skyCond : the sky conditions
	 */
	public Forecast(String newSkyCond) {
		this.skyCond = newSkyCond;
		this.temp = 70.0;
	}

	/**
	 * A Forecast with temperature 70 and sky conditions sunny
	 */
	public Forecast() {
		this.skyCond = "sunny";
		this.temp = 70.0;
	}
	
	/**
	 * Get the temperature
	 * @return The current temperature
	 */

	public double getTemp() {
		return this.temp;
	}
	
	/**
	 * Set the temperature
	 * @param newTemp : the new temperature
	 */

	public void setTemp(double newTemp) {
		if (temp >= -50 && temp <= 150) {
			this.temp = newTemp;
		}
	}
	
	/**
	 * Get the sky conditions
	 * @return The current sky conditions
	 */

	public String getSkyCond() {
		return this.skyCond;
	}
	
	/**
	 * Set the sky conditions
	 * @param newSkyCond : the new sky conditions
	 */

	public void setSkyCond(String newSkyCond) {
		this.skyCond = newSkyCond;
	}


	/**
	 * Convert the Forecast to a string
	 */
	public String toString() {
		return "Forcast: temperature: " + this.temp + ", sky conditions: " + this.skyCond + ".";
	}

	/**
	 * Check if this object equals another one
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Forecast)) {
			return false;
		}
		else {
			Forecast other = (Forecast) obj;
			return this.skyCond.equals(other.skyCond) && this.temp == other.temp;
		}
	}
	
	/**
	 * Convert the temperature to Celsius
	 * @return The current temperature in Celsius.
	 */
	public double toCelsius() {
		return (this.temp - 32) * 5 / 9;
	}
	
	/**
	 * Check if the forecast is consistent.
	 * @return
	 */
	public boolean isConsistent() {
		return (this.temp < 32 && !this.skyCond.equals("snowy")) || (this.temp > 100 && !this.skyCond.equals("sunny"));
	}
}
