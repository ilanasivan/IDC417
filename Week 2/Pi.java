import java.lang.Math;

public class Pi {
    /**	This program calculates the value of Pi given the equation for the infinite series of Pi.
     * The program receives two command-line integers, N1 and N2 and approximates Pi by calculating the equation using n+1 terms.
     * The main method assumes N1 is less than or equal to n, and n is less than or equal to N2 (n is the range).
     **/

    // Create part of the pi equation for calculating the infinite series of pi for future use
    public static double sumFunction(int k){
        double sumFunction = (Math.pow(-3,-k))/((2*k)+1);
        return sumFunction;
    }

    public static void main(String[] args){

        // Initialize our console integers and store args
        int N1 = Integer.parseInt(args[0]);
        int N2 = Integer.parseInt(args[1]);

        // Calculating the value of pi
        for (int n = N1; n <= N2; n++){
            double sum = 0;
            for (int k = 0; k <= n; k++){

                // Call stored sumFunction of int k and add the sum to k
                sum += sumFunction(k);
            }

            // Multiply the sum by the square root of 12, from the equation for the infinite series of pi
            sum *= Math.sqrt(12);

            // Generate output
            System.out.println("n = " + n + " : pi = " + sum);
        }
    }
}
