package week6;

public class HighTemps {
	private double[] highs = new double[7];
	
	public HighTemps(double[] newHighs) {
		if (newHighs.length == 7) {
			this.highs = newHighs;
		}
	}

	/**
	 * @return the highs
	 */
	public double[] getHighs() {
		return this.highs;
	}

	/**
	 * @param highs the highs to set
	 */
	public void setHighs(double[] highs) {
		this.highs = highs;
	}
	
	public String toString() {
		String outStr = "Highs for the last week: ";
		
		for (double temp : this.highs) {
			outStr += temp + ", ";
		}
		
		return outStr;
	}
	
	/**
	 * Get the number of temperatures above 100 or below 0
	 * @return The number of temperatures x such that {@code x < 0} or {@code x > 100}
	 */
	public int numExtremeTemps() {
		int count = 0;

		for (double temp : this.highs) {
			if (temp < 0 || temp > 100) {
				count ++;
			}
		}
		
		return count;
	}
	
	/**
	 * 
	 * @return
	 */
	public double largestChange() {
		double highDiff = 0.0;
		
		for (int i = 1; i < this.highs.length; i ++) {
			if (Math.abs(this.highs[i] - this.highs[i - 1]) > highDiff) {
				highDiff = Math.abs(this.highs[i] - this.highs[i - 1]);
			}
		}
		
		return highDiff;
	}

}
