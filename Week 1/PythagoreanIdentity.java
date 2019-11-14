/*
Assignment number : 1.4
File Name : PythagoreanIdentity.java
Name (First Last) : Ilana Sivan
Student ID : 205634272
Email : ilana.sivan@post.idc.ac.il
 */

import java.lang.Math;

public class PythagoreanIdentity {
/** This method
 *
 *
 **/

    public static void main (String[] args) {

        //store args
        double input = Double.parseDouble(args[0]);

        //creating formulas
        double inputSin = Math.sin(input);
        double inputCos = Math.cos(input);

        //calculating the pythagorean identity and rounding it to the theoretical value
        double calculatedIdentity = Math.round(Math.pow(inputSin,2) + Math.pow(inputCos,2));

        //generate output
        System.out.println("sin(" + input +")^2 + cos(" + input + ")^2 = " + calculatedIdentity);

    }
}
