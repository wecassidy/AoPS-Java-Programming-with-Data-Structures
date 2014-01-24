package week8;

public class Student extends Person {
	private int age;
	
	public Student (String username, String address, int age) {
		super(username, address);
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return super.toString() + " and is " + this.age;
	}
}
