package fahrtocent;

/** FahrToCent.java
 * @author jmh463
 * This class requests a user to input a temperature in degrees Fahrenheit and
 * returns it in degrees centigrade.
 */

import java.util.Scanner;

public class FahrToCent
{

    /**
     * The main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Reads the user's input and converts it to an integer
        Scanner input = new Scanner(System.in);
        System.out.print("Temperature in Fahrenheit: ");
        int fahr = input.nextInt();
        
        //Converts fahrenheit to celsius
        int cent = (fahr - 32) * 5 / 9;
        
        //Prints the temperature in degrees celsius/centigrade
        System.out.println("Temperature in Centigrades: " + cent); 
   }
}
