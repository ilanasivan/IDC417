/*
Assignment number : 1.5
File Name : GenSum.java
Name (First Last) : Ilana Sivan
Student ID : 205634272
Email : ilana.sivan@post.idc.ac.il
 */

import java.lang.Math;

public class GenSum {
/** This method generates three random numbers and finds their sum.
 * The program receives an input of a minimum and maximum for a range and then randomizes three numbers.
 * The program prints out the three random numbers and then their total sum.
 **/

    public static void main(String[] args) {
        //store args
        int min  = Integer.parseInt(args[0]);
        int max  = Integer.parseInt(args[1]) - 1;

        //define range
        int range = max - min + 1;

        //create sum variable
        int sum = 0;

        //randomize three variables and find their sum
        for (int i = 0; i < 3; i++) {
            int rand = (int) (Math.random() * range) + min;
            System.out.println(rand);
            sum += rand;
        }
        //generate output
        System.out.println("Sum = " + sum);
    }
}
