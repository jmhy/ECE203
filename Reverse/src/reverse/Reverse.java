package reverse;

import java.util.Scanner;

/** Reverse.java
 * @author jmh463
 * This class accepts a string specified by the user and returns the string in
 * exactly reverse order.
 */
public class Reverse
{
    /**
     * The main method that does all of the work for this class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        //Reads the user's input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to be reversed: ");
        
        //Creates a string "str" from the user's input
        String str = input.nextLine();
        
        //Prints the string in reverse order
        System.out.println(new StringBuilder(str).reverse().toString());
    }
}
