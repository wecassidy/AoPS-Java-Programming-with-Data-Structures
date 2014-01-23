public class Person {
	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person(String username, String address) {
		this.username = username;
		this.address = address;
	}
	public Person() {
		this.username = "John Doe";
		this.address = "123 Main Street";
	}
	public String toString() {
		return username + " lives at " + address;
	}
	
	
	

}
