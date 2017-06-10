package dampedosc;

import java.util.Scanner;

/** DampedOsc.java
 * @author jmh463
 * This class calculates the damped sinusoidal oscillation from a specified time.
 */
public class DampedOsc
{
    /**
     * The main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Reads the user's input to set the time interval
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the time in seconds: ");
        double t = input.nextInt();
        
        //Calculates v(t) with the specified time
        double v = 5 * Math.exp(-0.1 * t) * Math.cos(0.01*t);
        
        //Prints out v(t)
        System.out.println("The sinusoidal oscillation v(t) is: " + v);
    }
}
