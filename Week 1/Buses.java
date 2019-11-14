/*
Assignment number : 1.2
File Name : Buses.java
Name (First Last) : Ilana Sivan
Student ID : 205634272
Email : ilana.sivan@post.idc.ac.il
 */

public class Buses {
/**The method checks what is the most cost-efficient way to transport tourists, with busses and/or shuttles, and provides a cost.
 * The cost of a single bus is 500 ILS and the cost of a single shuttle is 300 ILS.
 * A bus can take up to fifty passengers and a shuttle can take up to 12 passengers at a time.
 * The method returns the total amount of busses and shuttles necessary to transport a given number of tourists and the total cost.
 **/
	public static void main(String[] args) {
		//establish variables
		int busCost = 500;
		int shuttleCost = 300;
		int maxBusPassengers= 50;
		int maxShuttlePassengers = 12;
		int numberOfShuttles=0;
		int passengers = Integer.parseInt(args[0]);
		int numberOfBuses = passengers/maxBusPassengers;
		int passengersLeftOut = passengers%maxBusPassengers;

		//validate
		if (passengersLeftOut<0){
			System.out.println("We can't send transportation for non-existant travelers");
			return;
		} else if (passengersLeftOut>12) {
			numberOfBuses++;
		} else if (passengersLeftOut<=12 && passengersLeftOut!=0){
			numberOfShuttles++;
		}

		//establish price
		int totalBusCost = numberOfBuses*busCost;
		int totalShuttleCost = numberOfShuttles*shuttleCost;
		int totalCost = totalBusCost+totalShuttleCost;

		//generate output
		System.out.println("Use " + numberOfBuses + " buses and " + numberOfShuttles + " shuttles at a cost of " + totalCost + " ILS");
    }
}
