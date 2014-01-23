
public abstract class Vehicle {
	private String owner;
	private int numWheels;

	public Vehicle(String owner, int numWheels) {
		this.owner = owner;
		this.numWheels = numWheels;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getWheels() {
		return this.numWheels;
	}
	
	public void setWheels(int numWheels) {
		this.numWheels = numWheels;
	}

}

class Bicycle extends Vehicle {
	public Bicycle(String owner) {
		super(owner, 2);
	}
}

class MotorizedVehicle extends Vehicle {
	private int engineVolume;
	
	public MotorizedVehicle(String owner, int numWheels, int engineVolume) {
		super(owner, numWheels);
		
		this.engineVolume = engineVolume;
	}
	
	public int horsepower() {
		return this.engineVolume * super.getWheels();
	}
}