package apps;

import java.util.Scanner;

import data.Aircraft;

public class JetDriver {
	static Scanner keyboard = new Scanner(System.in);
	static Aircraft[] airArray = new Aircraft[100];

	public static void main(String[] args) {

		/*
		 * (String manufacturer, String model, String modelVariant, double
		 * price, int maxSpeed, int serviceCeiling, int maxRange, int dryWeight,
		 * int maxTakeOffWeight, int fuelCapacity, int yearIntroduced)
		 */

		airArray[0] = new Aircraft("General Dynamics / Lockheed Martin Aeronautics", "F-16", "Fighting Falcon", 18.8,
				1320, 50000, 2620, 18900, 42300, 7000, 1978);
		airArray[1] = new Aircraft("McDonnell Douglas / Boeing Defense, Space & Security", "F-15", "Eagle", 29.9, 1650,
				65000, 3450, 28000, 68000, 13455, 1976);
		airArray[2] = new Aircraft("North American Aviation", "P-51", "Mustang", 0.050985, 440, 41900, 1650, 7635,
				12100, 2807, 1942);
		airArray[3] = new Aircraft("McDonnell Douglas / Boeing Northrop", "F-18", "Hornet", 29, 1190, 50000, 2071,
				23000, 51900, 10860, 1983);
		airArray[4] = new Aircraft("Lockheed Martin Aeronautics / Boeing Defense, Space & Security", "F-22", "Raptor",
				150, 1500, 65000, 1840, 43340, 83500, 18000, 2005);
		airArray[5] = new Aircraft("Northrop Grumman", "B-2", "Spirit", 737, 630, 50000, 6900, 158000, 376000, 167000,
				1997);
		airArray[6] = new Aircraft("Lockheed Martin Aeronautics", "F-35", "Lightning", 122.8, 1200, 60000, 2220, 29098,
				70000, 18498, 2006);

		boolean quit = false;

		System.out.println("\n**********Welcome to the Aircraft Repository**********\n\n");

		do {

			System.out.println("What would you like to do?\n");
			System.out.println("1. List fleet" + "\n2. View fastest jet" + "\n3. View jet with longest range"
					+ "\n4. Add a jet to Fleet" + "\n5. Quit");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			/*
			 * Added this extra .nextLine(), as using .nextLine() after
			 * .nextInt() causes problems. Super thanks to Stack Overflow for
			 * this one!!!
			 * https://stackoverflow.com/questions/27141183/scanner-nextline-
			 * occasionally-skips-input Could have closed the scanner, but
			 * wanted to solve the issue.
			 */

			if (choice == 1) { // For all jets, they have lots of info
				for (int i = 0; i < airArray.length; i++) {
					if (airArray[i] != null) {
						System.out.println(airArray[i]);
					} else {
						continue;
					}
				}
			} else if (choice == 2) { // for the fastest jet
				int fastestSpeed = 0;
				int fastestJet = 0;
				for (int i = 0; i < airArray.length; i++) {
					if (airArray[i] != null && airArray[i].getMaxSpeed() > fastestSpeed) {
						fastestSpeed = airArray[i].getMaxSpeed();
						fastestJet = i;
					} else {
						continue;
					}
				}
				System.out.println(airArray[fastestJet]);
			} else if (choice == 3) { // for longest range
				int longestRange = 0;
				int rangeJet = 0;
				for (int i = 0; i < airArray.length; i++) {
					if (airArray[i] != null && airArray[i].getMaxRange() > longestRange) {
						longestRange = airArray[i].getMaxRange();
						rangeJet = i;
					} else {
						continue;
					}
				}
				System.out.println(airArray[rangeJet]);
			} else if (choice == 4) { // To input info about a new jet.

				toCreateNewJet(); // Calls method at bottom of page.

			} else {
				keyboard.close();
				quit = true;
			}
		} while (quit == false);

	}

	private static void toCreateNewJet() {

		for (int i = 0; i < airArray.length; i++) {
			if (airArray[i] == null) {
				/*
				 * This is actually a whole bunch of requests for input, and I
				 * hate the mass of it, would prefer to put it somewhere and
				 * make it cleaner.
				 * 	***UPDATE***
				 * Crushed out 100+ lines from this.
				 */

				System.out.println("Here you can input info for the aircraft.");

				System.out.print("Please enter the manufacturer: ");
				String manufacturer = keyboard.nextLine();

				System.out.print("Please enter the model: ");
				String model = keyboard.nextLine();

				System.out.print("Please enter the common name: ");
				String variant = keyboard.nextLine();

				String[] inputArray = { "Please enter the price (million USD): ", "Please enter the max speed (mph): ",
						"Please enter the service ceiling (feet): ", "Please enter the max range (miles): ",
						"Please enter the dry weight (lbs): ", "Please enter the max take off weight (lbs): ",
						"Please enter the fuel capacity: ", "Please enter when the aircraft entered service: " };

				airArray[i] = new Aircraft(manufacturer, model, variant, inputIntsForAircraft(inputArray[0]),
						inputIntsForAircraft(inputArray[1]), inputIntsForAircraft(inputArray[2]),
						inputIntsForAircraft(inputArray[3]), inputIntsForAircraft(inputArray[4]),
						inputIntsForAircraft(inputArray[5]), inputIntsForAircraft(inputArray[6]),
						inputIntsForAircraft(inputArray[7]));
				//This is the magic, and crushed down the code.

				break;

			} else {
				continue;
			}
		}
	}

	private static int inputIntsForAircraft(String value) {
		int valForInput;
		do {
			System.out.print(value);
			while (!keyboard.hasNextInt()) {
				System.out.print("This needs to be a positive number, try again: ");
				keyboard.next();
			}
			return valForInput = keyboard.nextInt();
		} while (valForInput <= 0);
	}
}
