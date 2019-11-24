
import java.lang.Math;

public class PythagoreanIdentity {

    public static void main (String[] args) {

        // Store args
        double input = Double.parseDouble(args[0]);

        // Creating formulas
        double inputSin = Math.sin(input);
        double inputCos = Math.cos(input);

        // Calculating the pythagorean identity and rounding it to the theoretical value
        double calculatedIdentity = Math.round(Math.pow(inputSin,2) + Math.pow(inputCos,2));

        // Generate output
        System.out.println("sin(" + input +")^2 + cos(" + input + ")^2 = " + calculatedIdentity);

    }
}
