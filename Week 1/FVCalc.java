/*
Assignment number : 1.1
File Name : FVCalc.java
Name (First Last) : Ilana Sivan
Student ID : 205634272
Email : ilana.sivan@post.idc.ac.il
 */
import java.lang.Math;

public class FVCalc {
/**	The method computes the value of a car that loses a fixed percent of its value every year.
 * The program will run when it receives the initial value of the car (an integer), the loss rate (as a double), and the number of years of ownership (an integer).
 * The values must be entered in the order above for the program to run.
 * The final result is a rounded integer.
 **/

	//initializing variables
    int currentValue;
    double lossRate;
    int yearsCarWasOwned;

	public static void main(String[] args){
		//store args
	    int currentValue = Integer.parseInt(args[0]);
	    double lossRate = Double.parseDouble(args[1]);
	    int yearsCarWasOwned = Integer.parseInt(args[2]);

	    // convert lossRate value into percentage
        double percentage = lossRate/100;

        //formula for value loss
		double calculatedValue =  Math.round(currentValue * Math.pow(1-percentage, yearsCarWasOwned));

		//cast double to int
	    int futureValue = (int) calculatedValue;

	    //generate output
        System.out.println("After " + yearsCarWasOwned + " years, a $" + currentValue + " car that loses " + lossRate + "% annually is worth $" + futureValue);
	}
}