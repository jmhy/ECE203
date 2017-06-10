package quadrant;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class Quadrant
{

    /**
     * Main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Create empty string to be used for the quad adjacency
        String result = "";
        
        //Request and read user input for X1,Y1 and X2,Y2
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point X1: ");
        double x1 = input.nextInt();
        System.out.print("Enter point Y1: ");
        double y1 = input.nextInt();
        System.out.print("Enter point X2: ");
        double x2 = input.nextInt();
        System.out.print("Enter point Y2: ");
        double y2 = input.nextInt();
        
        //Check if any entered value is zero
        if(x1!=0 && x2!=0 && y1!=0 && y2!=0)
        {
            //Check for being in the same quad
            if((x1/x2)>0 && (y1/y2)>0)
            {
                result = "the same quads";
            }
            //Check for being in opposite quads
            else if(((x1/x2)<0 && (y1/y1)>0) || ((x1/x2)>0 && (y1/y1)<0))
            {
                result = "opposite quads";
            }
            //Will be adjacent in any other case
            else
            {
                result = "adjacent quads";
            }
            System.out.println("The coordinates are in " + result);
        }
        
        //In case any value is zero
        else
        {
            System.out.println("None of the coordinates can be zero.");
        }
    }   
}