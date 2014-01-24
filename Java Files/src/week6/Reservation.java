package week6;
import java.util.Scanner; // Import the Scanner class


public class Reservation {
	/**
	 * The seats on the plane. If an the item at index {@code i} is {@code True}, then seat number {@code i + 1} is reserved.
	 */
	private boolean[] seats; // The array seats represents the seats on the plane. If a seat is reserved, it is set to True

	/**
	 * Creates a new Reservation object.
	 * @param numSeats the number of seats on the plane
	 */
	public Reservation(int numSeats) {
		this.seats = new boolean[numSeats]; // Set the length of the array to numSeats
		for (int i = 0; i < numSeats; i ++) { // Loop through the entire array so that we can unreserve each seat
			this.seats[i] = false; // Unreserve the seat at index i
		}
	}

	/**
	 * Gets the number of first class seats.
	 * @return floor ( (The number of seats on the plane) / 4 )
	 */
	public int numFirstClass() {
		return this.seats.length / 4; // Because the two arguments to the division are both ints, the quotient is automatically truncated
	}

	/**
	 * Get the seats on the plane.
	 * @return r.seats, where r is a Reservation object.
	 */
	public boolean[] getSeats() {
		return this.seats; // Return the seats array
	}

	/**
	 * Reserves a seat.
	 * @param seatNum the number of the seat to be reserved
	 */
	public void reserve(int seatNum) {
		this.seats[seatNum - 1] = true; // Reserve the seat at index seatNum - 1 in the seats attribute (seatIndex = seatNum - 1)
	}

	/**
	 * Cancels the reservation on a seat.
	 * @param seatNum the number of the seat of which to cancel the reservation
	 */
	public void unReserve(int seatNum) {
		this.seats[seatNum - 1] = false; // Cancel the reservation on the seat at index seatNum -1 in the seats attribute
	}

	/**
	 * Checks if there is a seat available in a given class
	 * @param firstClass {@code true} for first class, {@code false} for economy
	 * @return If there is a seat available. There is at least one seat available in a given class if the last seat in the class is not reserved.
	 */
	public boolean seatAvailableInClass(boolean firstClass) {
		if (firstClass) { // If the user wants to check first class:
			if (this.seats.length >= 4) { // If there are first class seats:
				return this.seats[this.numFirstClass() - 1] == false; // Return if the last seat in full class is not reserved
			}

			else {return false;} // If there aren't any first class seats on the plane, return false
		}

		else {return this.seats[this.seats.length - 1] == false;} // If the user chose to check economy, return if the last seat on the plane is available
	}

	/**
	 * Reserves the highest available seat in a given class.
	 * @param firstClass {@code true} for first class, {@code false} for economy
	 * @return The number of the seat reserved, or 0 if the plane is full.
	 */
	public int reserveHighestInClass(boolean firstClass) {
		if (firstClass) { // If the user chose first class:
			for (int i = 0; i < this.numFirstClass(); i ++) { // Loop through all the seats in first class
				if (this.seats[i] == false) { // If the seat at index i is available:
					this.reserve(i + 1); // Reserve seat number i + 1
					return i + 1; // Return the number of the reserved seat
				}
			}
		}
		
		else { // If the user chose economy:
			for (int i = this.numFirstClass(); i < this.seats.length; i ++) { // Loop through all the seats in economy
				if (this.seats[i] == false) { // If the seat at index i is available:
					this.reserve(i + 1); // Reserve seat number i + 1
					return i + 1; // Return the number of the reserved seat
				}
			}
		}

		return 0; // Return 0 if the plane is full
	}

	/**
	 * Checks if the plane is full.
	 * @return {@code true} if the plane is full, {@code false} otherwise
	 */
	public boolean isFull() {
		for (boolean seat : this.seats) { // Loop through all the seats on the plane
			if (seat == false) {return false;} // If the seat at this iteration is available, then return false because the plane is not full
		}

		return true; // If the method gets this far, the plane must be full because there are no seats available
	}

	/**
	 * Cancels all reservations on this plane.
	 */
	public void emptyPlane() {
		for (int i = 0; i < this.seats.length; i ++) {this.seats[i] = false;} // Loop through all the seats and set each one to false
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Create a Scanner object for input

		System.out.println("Please enter the number of seats on the plane:"); // Prompt the user to enter the number of seats
		int numSeats = scan.nextInt(); // Get the number of seats entered

		Reservation r = new Reservation(numSeats); // Create a new Reservation object that represents the plane

		int choice = 0; // Choice is the user's choice of option, stored as a number

		System.out.println("Welcome to Tungsten Airlines Reservation Service!"); // Greet the user (yes, I had to call it Tungsten Airlines. :) )
		System.out.println("Enter:");
		System.out.println("0 for first class,");
		System.out.println("1 for economy,");
		System.out.println("2 to cancel a reservation,");
		System.out.println("3 to clear all reservations on this plane, or");
		System.out.println("4 to quit."); // List the options

		do { // Use a do/while loop instead of a while loop so that the code inside it is executed at least once.
			choice = scan.nextInt(); // Get the user's choice as a number

			switch (choice) { // Switch on the user's choice
			case 0: // If the user chose first class:
				if (!r.isFull()) { // Check that the plane is not full
					if (r.seatAvailableInClass(true)) { // Check that there is at least one first class seat available
						int reserved = r.reserveHighestInClass(true); // Reserve the highest available seat in first class. Reservation.reserveHighestInClass() returns the number of the seat that was reserved, or 0 if no seat was reserved
						System.out.printf("You have reserved seat %d.\n", reserved); // Alert the user to the reservation
					}

					else { // If there are no first class seats available:
						System.out.println("We're sorry, but there are no first class seats available. Can you fly economy? Enter 0 for no, or any other integer for yes."); // Tell the user that first class is full and ask if he/she can change to economy
						int canChange = scan.nextInt(); // Get the user's choice as an integer

						if (canChange == 0) {System.out.println("You have not reaserved a seat.");} // If the user can't change section, then let him/her know that the he/she hasn't reserved a seat

						else { // If the user can change section:
							int reserved = r.reserveHighestInClass(false); // Reserve the highest seat available in economy (There is guaranteed to be a seat available because we checked if the plane was full earlier)
							System.out.printf("You have reserved seat %d.\n", reserved); // Let the user know which seat he/she has reserved
						}

					}
				}

				else {System.out.println("We're sorry, but the plane is full.");} // If the plane is full, alert the user to this fact

				break; // Leave the switch so that the other cases aren't executed

			case 1: // If the user chose economy:
				if (!r.isFull()) { // Check that there are seats available
					if (r.seatAvailableInClass(false)) { // Check that there is at least one economy seat available
						int reserved = r.reserveHighestInClass(false); // Reserve the highest available seat in economy. Reservation.reserveHighestInClass() returns the number of the seat that was reserved, or 0 if no seat was reserved
						System.out.printf("You have reserved seat %d.\n", reserved); // Let the user know which seat he/she has reserved
					}

					else { // If there are no seats available in economy:
						System.out.println("We're sorry, but there are no economy seats available. Can you fly first class? Enter 0 for no, or any other integer for yes."); // Tell the user that economy is full and ask if he/she can change to first class
						int canChange = scan.nextInt(); // Get the user's choice as an integer

						if (canChange == 0) {System.out.println("You have not reaserved a seat.");} // If the user can't change section, then let him/hre know that the he/she hasn't reserved a seat 

						else { // If the user can change section:
							int reserved = r.reserveHighestInClass(false); // Reserve the highest available seat in first class. Reservation.reserveHighestInClass() returns the number of the seat that was reserved, or 0 if no seat was reserved. Reservation.reserveHighestInClass() returns the number of the seat that was reserved, or 0 if no seat was reserved
							System.out.printf("You have reserved seat %d.\n", reserved); // Let the user know which seat he/she has reserved
						}
					}
				}

				else {System.out.println("We're sorry, but the plane is full.");} // If the plane is full, alert the user to this fact

				break; // Leave the switch so that the other cases aren't executed

			case 2: // If the user chose to cancel a reservation
				System.out.println("Please enter the number of the seat to be canceled:"); // Prompt the user to enter the number of the seat to be cancelled
				int cancelNum = scan.nextInt(); // Get the number of the seat entered

				if (cancelNum < r.getSeats().length) { // If the seat number entered is valid:
					if (r.getSeats()[cancelNum - 1] == true) { // If the seat is reserved:
						r.unReserve(cancelNum); // Cancel the reservation of the seat
						System.out.printf("You have canceled the reservation of seat %d.\n", cancelNum); // Alert the success of the cancellation to the user
					}

					else {System.out.printf("Seat %d is not reserved.\n", cancelNum);} // If the seat isn't reserved, tell the user
				}

				else {System.out.printf("%d is not a valid seat number.\n", cancelNum);} // If the user entered an invalid seat number, say so.

				break; // Leave the switch so that the other cases aren't executed

			case 3: // If the user chose to empty the plane
				r.emptyPlane(); // Empty the plane
				System.out.println("You have cancelled all reservations."); // Let the user know that the plane has been emptied succesfully

				break; // Leave the switch so that the other cases aren't executed

			case 4: // If the user chose to quit
				System.out.println("Thank you for using Tungsten Airlines Reservation System."); // Thank the user for using the system

				break; // Leave the switch so that the default case isn't executed

			default: // If the user didn't enter a valid number
				System.out.println("Please enter a valid number."); // Ask the user to enter a valid number
			}

			if (choice != 4) { // If the user didn't quit
				System.out.println(); // Print a blank line for space
				System.out.println("Enter 0 for first class, 1 for economy, 2 to cancel, 3 to clear the plane, or 4 to quit:"); // Give the short version of the menu of options
			}

		}
		while (choice != 4); // Loop the code in the do block while the choice isn't 4 (the user hasn't quit)

		scan.close(); // Close the scanner object
	}


}
