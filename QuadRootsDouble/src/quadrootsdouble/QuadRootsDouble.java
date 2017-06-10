package quadrootsdouble;

import java.util.Scanner;

/** QuadRootsDouble.java
 * @author jmh463
 * This class calculates the roots of a quadratic equation from given doubles
 * for a, b, c.
 * The reason that a=7.569, b=4.35, c=0.625 does not produce a correct result is
 * that multiplying/dividing doubles can produce roundoff errors.
 */
public class QuadRootsDouble
{
    /**
     * The main (and only) method of the class. Reads the user's input for a, b,
     * c and calculates the roots of the quadratic equation.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Read user's input for a, b, c and cast them to doubles
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value a: ");
        double a = input.nextDouble();
        System.out.print("Enter value b: ");
        double b = input.nextDouble();
        System.out.print("Enter value c: ");
        double c = input.nextDouble();
        //First check if the quad roots will be real
        if (b * b - 4 * a * c > 0)
        {
            //If real, calculate and print out real representation of roots
            double quad1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double quad2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            //Round to three decimal places
            System.out.printf("The roots are %.3f", quad1);
            System.out.printf(" and %.3f%n", quad2);
        }
        //Check if there will be only one solution and print it
        else if (b * b - 4 * a * c == 0)
        {
            System.out.println("The solution is " + (-b / (2 * a)));
        }
        //If complex, print out in a format that represents complex roots
        else
        {
            double b2 = (-b / (2 * a));
            double quad = Math.sqrt(-1 * (b * b - 4 * a * c)) / (2 * a);
            //Round to three decimal places
            System.out.printf("The roots are %.3f", b2);
            System.out.printf("+%.3f", quad);
            System.out.printf("i and %.3f", b2);
            System.out.printf("-%.3f", quad);
            System.out.println("i");
        }
    }
}