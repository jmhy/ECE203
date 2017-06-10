package sqrt;

import java.util.Scanner;

/** Sqrt.java
 * @author jmh463
 * This class class prompts the user to enter an integer and returns a double
 * representation of the square root.
 */
public class Sqrt
{

    /**
     * The main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Reads the user's input and converts it to an integer
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the square number: ");
        int sqr = input.nextInt();
        
        //Check if the input is positive or negative
        if (sqr < 0)
        {
            /* 
            If negative, takes the square root and appends an i to represent
            a complex number. Prints the result to two decimal placess.
            */
            sqr = sqr * -1;
            System.out.printf("The square root is: %.2f", Math.sqrt(sqr));
            System.out.println("i");
        }
        else
        {
            //If positive, just prints the square root to two decimal places
            System.out.printf("The square root is: %.2f%n", Math.sqrt(sqr));
        }
    }
}