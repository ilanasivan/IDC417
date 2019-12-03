import java.lang.Math;

public class Dice {
    /**	This program calculates the expected value (average) of N sums of m throws of n-sided dice and prints it.
     * The private dice method simulates throwing a single n-sided dice.
     * The dice_sum method returns pseudo-randomly the sum of the integers resulting from m dice throws of an n-sided dice.
     * The main method calculates the expected value and uses dice_sum.
     **/

    // Simulate dice throw
    private static int dice(int n){
        int min = 1;
        int range = n;
        int randomizedValue = (int) (Math.random() * range) + min;
        return randomizedValue;
    }

    // Return sum of integers resulting from m throws of n-sides dice
    private static int dice_sum(int m, int n){
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += dice(n);
        }
        return sum;
    }

    // Calculate average
    public static void main(String[] args){

        // Store console inputs for n (sides), m (throws), N (sums)
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        // Initialize diceSum variable
        int diceSum = 0;

        // Store sum of integers
        for (int i = 0; i < N; i++){
            diceSum += dice_sum(m,n);
        }

        // Calculate the average and store it
        double average = (double) diceSum / N;

        // Generate output
        System.out.println(average);
    }
}
