
import java.lang.Math;

public class Quadratic {
/** This method calculates the roots of a quadratic equation and prints the output of the roots and the formula given three values.
 * The method parses variables a, b, and c in order as doubles and calculates the roots of the equation.
 * The program treats the solution as well as the variables as doubles.
 * The program assumes the determinant must be real.
 **/

    public static void main(String[] args) {
       
        // Store args
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        // Create a determinant for future use
        double determinant = Math.pow(b, 2) - (4 * a * c);

        // Condition for a determinant greater than 0
        if (determinant > 0){
            //quadratic equation
            double root1 = (-b + Math.sqrt(determinant))/(2*a);
            double root2 = (-b - Math.sqrt(determinant))/(2*a);
                
            // Generate output with smaller x first
                if (root1<root2) {
                    System.out.println(a + "x^2 + " + b + "x + " + c + " ->");
                    System.out.println("x= " + root1 + ", " + root2);
                } else if (root2<root1) {
                    System.out.println(a + "x^2 + " + b + "x + " + c + " ->");
                    System.out.println("x= " + root2 + ", " + root1);
                }
        
            //Condition for a determinant equal to 0
        } else if (determinant==0) {
            
            // Quadratic equation
            double root1 = -b / (2 * a);
            
            //Generate output
            System.out.println(a + "x^2 + " + b + "x + " + c + " ->");
            System.out.println("x= " + root1);
            
        // Condition for a determinant that is less than 0
        } else if (determinant<0){
            System.out.println ("Hey, we were told to assume all solutions are real!");

        }

    }

}
