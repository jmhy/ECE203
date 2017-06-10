package antiln;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class AntiLn
{

    /**
     * Main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Initialize variables
        double num, den = 1, answer = 1;
        int i = 1;
        
        //Detect user input and store it in double 'num'
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x for e^x: ");
        num = input.nextDouble();
        
        //Check that the input is not zero
        if(num != 0)
        {
            //Compute e^x for 10 iterations
            while(i <= 10)
            {
                den = den * i;
                answer = answer + (Math.pow(num, i) / den);
                i++;
            }
        }
        
        //e^0 is just 1
        else
        {
            answer = 1;
        }
        
        //Print the answer to e^x
        System.out.printf("The exponential is: %.3f\n", answer);
    }
}