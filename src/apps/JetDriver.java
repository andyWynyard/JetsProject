package apps;

import java.util.Scanner;

import data.Aircraft;

public class JetDriver {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		Aircraft[] airArray = new Aircraft[100];
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
			 * Added this, as using .nextLine() after .nextInt() causes
			 * problems. Super thanks to Stack Overflow for this one!!!
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
			} else if (choice == 2) { //for the fastest jet
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
			} else if (choice == 4) {	// To input info about a new jet. 
				for (int i = 0; i < airArray.length; i++) {
					if (airArray[i] == null) {
						System.out.println("Here you can input info for the aircraft.");

						System.out.print("Please enter the manufacturer: ");
						String manufacturer = keyboard.nextLine();

						System.out.print("Please enter the model: ");
						String model = keyboard.nextLine();

						System.out.print("Please enter the common name: ");
						String variant = keyboard.nextLine();

						System.out.print("Please enter the price (million USD): ");
						int price = keyboard.nextInt();

						System.out.print("Please enter the max speed (mph): ");
						int maxSpeed = keyboard.nextInt();

						System.out.print("Please enter the service ceiling (feet): ");
						int serviceCeiling = keyboard.nextInt();

						System.out.print("Please enter the max range (miles): ");
						int maxRange = keyboard.nextInt();

						System.out.print("Please enter the dry weight (lbs): ");
						int dryWeight = keyboard.nextInt();

						System.out.print("Please enter the max take off weight (lbs): ");
						int maxTakeOffWeight = keyboard.nextInt();

						System.out.print("Please enter the fuel capacity: ");
						int fuelCapacity = keyboard.nextInt();

						System.out.print("Please enter when the aircraft entered service: ");
						int yearIntroduced = keyboard.nextInt();

						System.out.println("Thanks for the info!!!");

						airArray[i] = new Aircraft(manufacturer, model, variant, price, maxSpeed, serviceCeiling,
								maxRange, dryWeight, maxTakeOffWeight, fuelCapacity, yearIntroduced);

						break;
					} else {
						continue;
					}
				}
			} else {
				keyboard.close();
				quit = true;
			}
		} while (quit == false);

	}

}
