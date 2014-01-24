package week5;

public class EmployeeTester {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Tungsten", "CEO", 1000000);
		Employee emp2 = new Employee("Dan Kneezel", "Amazing Teacher", 10000000);
		
		System.out.println(emp1);
		System.out.println(emp2);
		
		Employee emp3 = new Employee("Tungsten", "CEO", 1000000);
		
		if (emp1.equals(emp3)) {
			System.out.println("emp1 is equal to emp3");
		}
		else {
			System.out.println("emp1 is not equal to emp3");
		}
		
		if (emp2.equals(emp3)) {
			System.out.println("Dan Kneezel has been cloned! :o :o :o :o :o");
		}
		else {
			System.out.println("You can't copy Mr. Kneezel.");
		}
		
		emp2.raise(50); // Because Mr. Kneezel deserves a raise. :)
		System.out.println(emp2);
		
		Employee emp4 = new Employee("Arnold", "Jones");
		System.out.println(emp4);
	}
}
