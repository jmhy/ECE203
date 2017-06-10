package antwalk;

import java.util.Scanner;

/** AntWalk.java
 * @author jmh463
 * This class models an ant in a room. The user specifies the length, width,
 * height of the room. Then, the shortest distance across the room is calculated.
 */
public class AntWalk
{
    /**
     * The main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {   
        //Reads the user's input for the room dimensions
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the room length: ");
        double l = input.nextInt();
        System.out.print("Enter the room width: ");
        double w = input.nextInt();
        System.out.print("Enter the room height: ");
        double h = input.nextInt();
        
        /*
        Calculate the shortest distance. Answer will vary depending upon which
        corner the ant starts.
        */
        double min1 = Math.min(Math.sqrt((l + w) * (l + w) + h * h), Math.sqrt((w + h) * (w + h) + l * l));
        double min2 = Math.min(Math.sqrt((w + h) * (w + h) + l * l), Math.sqrt((h + l) * (h + l) + w * w));
        
        //Print out the minimum distance
        System.out.println("The shortest distance to the opposite corner is " + Math.min(min1, min2));
    }
}
